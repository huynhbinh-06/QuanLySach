package hbinh.com.quanlysach.Model;

public class TopBook {

    int mahoadonCT;
    String mahoadon;
    String masach;
    int soluongmua;

    public TopBook(int mahoadonCT, String mahoadon, String masach, int soluongmua) {
        this.mahoadonCT = mahoadonCT;
        this.mahoadon = mahoadon;
        this.masach = masach;
        this.soluongmua = soluongmua;
    }

    public TopBook() {
    }

    public TopBook(String masach, int soluongmua) {
        this.masach = masach;
        this.soluongmua = soluongmua;
    }

    public int getMahoadonCT() {
        return mahoadonCT;
    }

    public void setMahoadonCT(int mahoadonCT) {
        this.mahoadonCT = mahoadonCT;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public int getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(int soluongmua) {
        this.soluongmua = soluongmua;
    }
}
