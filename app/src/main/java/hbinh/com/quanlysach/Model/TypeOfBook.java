package hbinh.com.quanlysach.Model;

import android.support.annotation.NonNull;

public class TypeOfBook {

    String matheloai;
    String tentheloai;
    int vitriloaisach;
    String motaloaisach;

    public TypeOfBook(String matheloai, String tentheloai, int vitriloaisach, String motaloaisach) {
        this.matheloai = matheloai;
        this.tentheloai = tentheloai;
        this.vitriloaisach = vitriloaisach;
        this.motaloaisach = motaloaisach;
    }

    public TypeOfBook() {
    }

    public String getMatheloai() {
        return matheloai;
    }

    public void setMatheloai(String matheloai) {
        this.matheloai = matheloai;
    }

    public String getTentheloai() {
        return tentheloai;
    }

    public void setTentheloai(String tentheloai) {
        this.tentheloai = tentheloai;
    }

    public int getVitriloaisach() {
        return vitriloaisach;
    }

    public void setVitriloaisach(int vitriloaisach) {
        this.vitriloaisach = vitriloaisach;
    }

    public String getMotaloaisach() {
        return motaloaisach;
    }

    public void setMotaloaisach(String motaloaisach) {
        this.motaloaisach = motaloaisach;
    }

    @Override
    public String toString() {
        return matheloai + " - " + tentheloai;
    }
}

