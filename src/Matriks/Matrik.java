package Matriks;

class Pecahan {
    private int pembilang;
    private int penyebut;

    public Pecahan(int pembilang, int penyebut) {
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public Pecahan tambah(Pecahan other) {
        int newPembilang = this.pembilang * other.penyebut + other.pembilang * this.penyebut;
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan kurang(Pecahan other) {
        int newPembilang = this.pembilang * other.penyebut - other.pembilang * this.penyebut;
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan kali(Pecahan other) {
        int newPembilang = this.pembilang * other.pembilang;
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    public Pecahan bagi(Pecahan other) {
        int newPembilang = this.pembilang * other.penyebut;
        int newPenyebut = this.penyebut * other.pembilang;
        return sederhanakan(new Pecahan(newPembilang, newPenyebut));
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    private Pecahan sederhanakan(Pecahan pecahan) {
        int gcd = gcd(pecahan.pembilang, pecahan.penyebut);
        return new Pecahan(pecahan.pembilang / gcd, pecahan.penyebut / gcd);
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }
}

public class Matrik {
    private Pecahan[][] data;
    private int baris;
    private int kolom;

    public Matrik(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        data = new Pecahan[baris][kolom];
    }

    public void isiData(Pecahan[][] data) {
        if (data.length != baris || data[0].length != kolom) {
            System.out.println("Ukuran data tidak sesuai");
            return;
        }
        this.data = data;
    }

    public Matrik tambah(Matrik other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Ukuran matriks tidak sesuai");
            return null;
        }
        Matrik hasil = new Matrik(this.baris, this.kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil.data[i][j] = this.data[i][j].tambah(other.data[i][j]);
            }
        }
        return hasil;
    }

    public Matrik kurang(Matrik other) {
        if (this.baris != other.baris || this.kolom != other.kolom) {
            System.out.println("Ukuran matriks tidak sesuai");
            return null;
        }
        Matrik hasil = new Matrik(this.baris, this.kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil.data[i][j] = this.data[i][j].kurang(other.data[i][j]);
            }
        }
        return hasil;
    }

    public Pecahan dotProduct(Matrik other, int barisKedua) {
        if (this.kolom != other.baris) {
            System.out.println("Ukuran matriks tidak sesuai");
            return null;
        }
        Pecahan hasil = new Pecahan(0, 1);
        for (int i = 0; i < kolom; i++) {
            hasil = hasil.tambah(this.data[barisKedua][i].kali(other.data[i][0]));
        }
        return hasil;
    }

    public Matrik transpose() {
        Matrik hasil = new Matrik(kolom, baris);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil.data[j][i] = this.data[i][j];
            }
        }
        return hasil;
    }

    public Matrik invers() {
        // Implementasikan perhitungan invers matriks di sini.
        // Ini adalah tugas yang cukup kompleks dan melibatkan aljabar linear.
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                sb.append(data[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
