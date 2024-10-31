package uploadAndDownload;

import org.junit.jupiter.api.Test;

public class downloadBelajar {
    //String / Integer Parsing
    // Learn Function and Method
    // Type data
    // return data
    @Test
    public void belajar() throws InterruptedException {

        int luasPersegiPanjang = hitungLuasPersegiPanjang(5, 3);
        System.out.println(luasPersegiPanjang);
        int totalAja = hitunganSederhanaTanpaReturn("4", "7");
        System.out.println("totalAja: " + totalAja);

        String total1 = hitungTotalPanjagPersegiString(5, 5);
        System.out.println(Integer.valueOf(total1));
    }

    public Integer hitunganSederhanaTanpaReturn(String panjang, String lebar) {
        //System.out.println(panjang + lebar);
        int panjangInt = Integer.valueOf(panjang);
        int lebarInt = Integer.valueOf(lebar);
        int total = panjangInt + lebarInt;

        return total;
    }

    @Test
    public String hitungTotalPanjagPersegiString(int panjang, int lebar) {
        //System.out.println(panjang + lebar);
        int panjangInt = Integer.valueOf(panjang);
        int lebarInt = Integer.valueOf(lebar);
        int total = panjangInt + lebarInt;
        return String.valueOf(total);
    }

    //learning return in void method
    @Test
    public void xxx() {
        if (true == true) {
            System.out.println("sebelum return");
            return;
        }else {
            System.out.println("Ga test");
        }
        // after this will not proceed
        System.out.println("Ga muncul");
    }

    public Integer hitungLuasPersegiPanjang(int panjang, int lebar) {
        int luas = panjang * lebar; // ==> primitive ==> 0
        Integer.valueOf(luas);

        return luas;
    }

}
