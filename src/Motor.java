public class Motor extends Kendaraan implements Refuelable {
    private boolean berboncengan = false;
    private final double kmPerLiter = 40.0;

    public Motor(String nomorRangka, String merek, int tahun) {
        super(nomorRangka, merek, tahun);
    }

    public Motor(String nomorRangka, String merek) {
        this(nomorRangka, merek, 2025);
    }

    public boolean isBerboncengan() {
        return berboncengan;
    }

    public void setBerboncengan(boolean berboncengan) {
        this.berboncengan = berboncengan;
    }

    public double getKmPerLiter() {
        return kmPerLiter;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Motor";
    }

    @Override
    public void berkendara(int jarak) {
        double konsumsi = kmPerLiter;
        if (berboncengan) {
            konsumsi = kmPerLiter * 0.8;
        }
        double dibutuhkan = jarak / konsumsi;

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
    public String statusBahanBakar() {
        if (getBahanBakar() < 1) {
            return "Kritis";
        } else {
            return "Aman";
        }
    }
}