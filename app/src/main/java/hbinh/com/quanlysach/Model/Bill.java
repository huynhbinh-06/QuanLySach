package hbinh.com.quanlysach.Model;

public class Bill {

    String mahoadon;
    String ngaymua;

    public Bill(String mahoadon, String ngaymua) {
        this.mahoadon = mahoadon;
        this.ngaymua = ngaymua;
    }

    public Bill() {
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }
}
