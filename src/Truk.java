public class Truk extends Kendaraan implements Servisable, Refuelable {
    private double muatan = 0;
    private final double kapasitasMuatan;
    private int kmTerakhirServis = 0;

    public Truk(String nomorRangka, String merek, int tahun, double kapasitasMuatan) {
        super(nomorRangka, merek, tahun);
        this.kapasitasMuatan = kapasitasMuatan;
    }

    public Truk(String nomorRangka, String merek) {
        this(nomorRangka, merek, 2025, 8.0);
    }

    public double getMuatan() {
        return muatan;
    }

    public void setMuatan(double muatan) {
        this.muatan = muatan;
    }

    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public int getKmTerakhirServis() {
        return kmTerakhirServis;
    }

    public void setKmTerakhirServis(int kmTerakhirServis) {
        this.kmTerakhirServis = kmTerakhirServis;
    }

    public void muat(double ton) {
        if (muatan + ton > kapasitasMuatan) {
            System.out.println(getMerek() + ": kelebihan muatan!");
        } else {
            muatan = muatan + ton;
            System.out.println(getMerek() + " memuat " + ton + " ton.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Truk muatan " + muatan + "/" + kapasitasMuatan + " ton";
    }

    @Override
    public void berkendara(int jarak) {
        double kmPerLiter = 3.0 - (muatan / kapasitasMuatan);
        double dibutuhkan = jarak / kmPerLiter;

        if (!isMesinMenyala()) {
            System.out.println(getMerek() + ": mesin belum menyala.");
        } else if (getBahanBakar() >= dibutuhkan) {
            setBahanBakar(getBahanBakar() - dibutuhkan);
            setOdometer(getOdometer() + jarak);
            System.out.println(getMerek() + " mengantar muatan " + muatan
                    + " ton sejauh " + jarak + " km.");
        } else {
            System.out.println(getMerek() + ": BBM tidak cukup.");
        }
    }

    @Override
    public boolean perluServis() {
        return getOdometer() - kmTerakhirServis >= 3000;
    }

    @Override
    public void servis() {
        kmTerakhirServis = getOdometer();
        System.out.println(getMerek() + " selesai diservis pada " + kmTerakhirServis + " km.");
    }

    @Override
    public String statusBahanBakar() {
        if (getBahanBakar() < 20) {
            return "Kritis";
        } else {
            return "Aman";
        }
    }
}