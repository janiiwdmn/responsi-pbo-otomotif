public class Main {
    public static void main(String[] args) {

        // (2) konstanta, dipanggil pakai nama class-nya langsung
        System.out.println("Batas kecepatan: " + Kendaraan.BATAS_KECEPATAN + " km/jam");

        // (3,4,5) bikin objek, ada yang lengkap, ada yang pakai nilai bawaan
        Mobil m1 = new Mobil("MR-001", "Toyota", 2022, 4);
        Mobil m2 = new Mobil("MR-002", "Honda");
        Motor mt = new Motor("MT-001", "Honda Vario");
        Truk hino = new Truk("TR-001", "Hino Dutro");

        // (3) ubah merek lewat setter, nomor rangka cuma bisa dibaca
        m2.setMerek("Honda Brio");
        System.out.println(m2.getMerek() + " | rangka: " + m2.getNomorRangka()
                + " | tahun: " + m2.getTahun());

        // (1,7,8) coba berkendara: mesin mati, BBM cukup, BBM kurang
        m1.berkendara(50);
        m1.nyalakanMesin();
        m1.isiBahanBakar(10);
        m1.berkendara(60);
        m1.berkendara(100);

        // motor, boncengan bikin lebih boros
        mt.nyalakanMesin();
        mt.isiBahanBakar(2);
        mt.setBerboncengan(true);
        mt.berkendara(30);

        // truk, muatan kedua ditolak karena kelebihan
        hino.nyalakanMesin();
        hino.muat(5);
        hino.muat(5);
        hino.isiBahanBakar(100);
        hino.berkendara(40);
        m1.matikanMesin();

        // (1,5,6) getInfo versi masing-masing, ada yang nambah info dari class induk
        System.out.println(m1.getInfo());
        System.out.println(mt.getInfo());
        System.out.println(hino.getInfo());

        // (9) satu daftar, isinya mobil, motor, dan truk, dicek lewat interface
        Refuelable[] daftar = {m1, mt, hino};
        for (Refuelable x : daftar) {
            System.out.println(x.statusBahanBakar());
        }

        // (9,10) objek yang sama dipakai lewat dua interface berbeda
        m1.setOdometer(5200);
        Servisable s = m1;
        System.out.println("Perlu servis? " + s.perluServis());
        s.servis();
        System.out.println("Perlu servis? " + s.perluServis());
        Refuelable r = m1;
        System.out.println("Status BBM Mobil: " + r.statusBahanBakar());
    }
}