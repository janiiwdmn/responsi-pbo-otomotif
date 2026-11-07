public class Mobil extends Kendaraan implements Servisable, Refuelable {
    private int jumlahPintu;
    private final double kmPerLiter = 12.0;
    private int kmTerakhirServis = 0;

    public Mobil(String nomorRangka, String merek, int tahun, int jumlahPintu) {
        super(nomorRangka, merek, tahun);
        this.jumlahPintu = jumlahPintu;
    }

    public Mobil(String nomorRangka, String merek) {
        this(nomorRangka, merek, 2025, 4);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKmPerLiter() {
        return kmPerLiter;
    }

    public int getKmTerakhirServis() {
        return kmTerakhirServis;
    }

    public void setKmTerakhirServis(int kmTerakhirServis) {
        this.kmTerakhirServis = kmTerakhirServis;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Mobil " + jumlahPintu + " pintu";
    }

    @Override
    public void berkendara(int jarak) {
        double dibutuhkan = jarak / kmPerLiter;
        if (!isMesinMenyala()) {
            System.out.println(getMerek() + ": mesin belum menyala.");
        } else if (getBahanBakar() >= dibutuhkan) {
            setBahanBakar(getBahanBakar() - dibutuhkan);
            setOdometer(getOdometer() + jarak);
            System.out.println(getMerek() + " menempuh " + jarak + " km.");
        } else {
            System.out.println(getMerek() + ": BBM tidak cukup.");
        }
    }

    @Override
    public boolean perluServis() {
        return getOdometer() - kmTerakhirServis >= 5000;
    }

    @Override
    public void servis() {
        kmTerakhirServis = getOdometer();
        System.out.println(getMerek() + " selesai diservis pada " + kmTerakhirServis + " km.");
    }

    @Override
    public String statusBahanBakar() {
        if (getBahanBakar() < 5) {
            return "Kritis";
        } else {
            return "Aman";
        }
    }
}