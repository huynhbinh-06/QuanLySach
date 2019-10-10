package hbinh.com.quanlysach.Model;

public class AddBook {

    String masach;
    String matheloai;
    String tacgia;
    String nxb;
    double giabia;
    int soluong;

    public AddBook(String masach, String matheloai, String tacgia, String nxb, double giabia, int soluong) {
        this.masach = masach;
        this.matheloai = matheloai;
        this.tacgia = tacgia;
        this.nxb = nxb;
        this.giabia = giabia;
        this.soluong = soluong;
    }

    public AddBook() {
    }

    public AddBook(String masach, double giabia) {
        this.masach = masach;
        this.giabia = giabia;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public double getGiabia() {
        return giabia;
    }

    public void setGiabia(double giabia) {
        this.giabia = giabia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
