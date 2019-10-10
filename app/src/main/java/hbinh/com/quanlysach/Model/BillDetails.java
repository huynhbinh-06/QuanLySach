package hbinh.com.quanlysach.Model;

public class BillDetails {

    String mahoadonchitiet;
    String mahoadon;
    String masach;
    String soluong;
    String prices;

    public BillDetails(String mahoadon, String masach, String soluong,String prices) {
        this.mahoadon = mahoadon;
        this.masach = masach;
        this.soluong = soluong;
        this.prices = prices;
    }

    public BillDetails() {
    }

    public String getMahoadonchitiet() {
        return mahoadonchitiet;
    }

    public void setMahoadonchitiet(String mahoadonchitiet) {
        this.mahoadonchitiet = mahoadonchitiet;
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

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}

