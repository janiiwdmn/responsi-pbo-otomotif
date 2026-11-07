public abstract class Kendaraan {
    public static final int BATAS_KECEPATAN = 120;

    private final String nomorRangka;
    private String merek;
    private int tahun;
    private double bahanBakar = 0;
    private int odometer = 0;
    private boolean mesinMenyala = false;

    public Kendaraan(String nomorRangka, String merek, int tahun) {
        this.nomorRangka = nomorRangka;
        this.merek = merek;
        this.tahun = tahun;
    }

    public Kendaraan(String nomorRangka, String merek) {
        this(nomorRangka, merek, 2025);
    }

    public String getNomorRangka() {
        return nomorRangka;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public double getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(double bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public boolean isMesinMenyala() {
        return mesinMenyala;
    }

    public void setMesinMenyala(boolean mesinMenyala) {
        this.mesinMenyala = mesinMenyala;
    }

    public void nyalakanMesin() {
        this.mesinMenyala = true;
        System.out.println(merek + ": mesin menyala.");
    }

    public void matikanMesin() {
        this.mesinMenyala = false;
        System.out.println(merek + ": mesin mati.");
    }

    public void isiBahanBakar(double liter) {
        this.bahanBakar = this.bahanBakar + liter;
    }

    public String getInfo() {
        return merek + " (" + tahun + ") | BBM: " + String.format("%.1f", bahanBakar)
                + " L | Odometer: " + odometer + " km";
    }

    public abstract void berkendara(int jarak);
}