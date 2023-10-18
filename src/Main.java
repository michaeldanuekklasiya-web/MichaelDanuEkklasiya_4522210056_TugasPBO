import Matriks.*;
import Pecahan.*;

public class Main {
    public static void main(String[] args) {
        Pecahan pecahan1 = new Pecahan(1, 2);
        Pecahan pecahan2 = new Pecahan(3, 4);

        System.out.println("Pecahan 1: " + pecahan1);
        System.out.println("Pecahan 2: " + pecahan2);

        Pecahan hasilTambah = pecahan1.tambah(pecahan2);
        Pecahan hasilKurang = pecahan1.kurang(pecahan2);
        Pecahan hasilKali = pecahan1.kali(pecahan2);
        Pecahan hasilBagi = pecahan1.bagi(pecahan2);

        System.out.println("Penjumlahan : " + pecahan1 + " + " + pecahan2 + " = " + hasilTambah);
        System.out.println("Pengurangan : " + pecahan1 + " - " + pecahan2 + " = " + hasilKurang);
        System.out.println("Perkalian   : " + pecahan1 + " : " + pecahan2 + " = " + hasilKali);
        System.out.println("Pembagian   : " + pecahan1 + " x " + pecahan2 + " = " + hasilBagi);

        Pecahan p1 = new Pecahan(1, 2);
        Pecahan p2 = new Pecahan(1, 3);
        Pecahan p3 = new Pecahan(1, 4);
        Pecahan p4 = new Pecahan(1, 5);

        Matrik matriks1 = new Matrik(2, 2);

        Matrik matriks2 = new Matrik(2, 2);

        Matrik hasilTambah1 = matriks1.tambah(matriks2);
        Matrik hasilKurang1 = matriks1.kurang(matriks2);
        Matrik hasilTranspose = matriks1.transpose();

        System.out.println("Matriks 1:");
        System.out.println(matriks1.toString());

        System.out.println("Matriks 2:");
        System.out.println(matriks2.toString());

        System.out.println("Hasil Penjumlahan Matriks:");
        System.out.println(hasilTambah.toString());

        System.out.println("Hasil Pengurangan Matriks:");
        System.out.println(hasilKurang.toString());

        System.out.println("Transpose Matriks 1:");
        System.out.println(hasilTranspose.toString());
    }
}