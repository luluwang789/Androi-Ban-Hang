package com.example.trana.cuahangthietbionline.Model;

public class KhackHang {
    private  int id;
    private String ten;
    private String ho;
    private String sdt;
    private String email;
    private String pass;
    private String diachi;
    private String gioitinh;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public KhackHang(int id ,String ten, String ho, String sdt, String email, String pass, String diachi, String gioitinh) {
        this.id=id;
        this.ten = ten;
        this.ho = ho;
        this.sdt = sdt;
        this.email = email;
        this.pass = pass;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }



}
