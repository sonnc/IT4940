/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesmapping;

/**
 *
 * @author sonnguyen
 */
public class SinhVienDeTai {
    private int mssv;
    private String hoTen;
    private String lop;
    private int khoa;
    private int maDeTai;
    private String tenDeTai;
    private int maCongTy;
    private String tenCongTy;
    private double chiSoSoKhop;
    private int id;

    public SinhVienDeTai() {
    }

    public SinhVienDeTai(int mssv, String hoTen, String lop, int khoa, int maDeTai, String tenDeTai, int maCongTy, String tenCongTy, double chiSoSoKhop) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.lop = lop;
        this.khoa = khoa;
        this.maDeTai = maDeTai;
        this.tenDeTai = tenDeTai;
        this.maCongTy = maCongTy;
        this.tenCongTy = tenCongTy;
        this.chiSoSoKhop = chiSoSoKhop;
    }



    public String getHoTen() {
        return hoTen;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getKhoa() {
        return khoa;
    }

    public void setKhoa(int khoa) {
        this.khoa = khoa;
    }

    public int getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(int maDeTai) {
        this.maDeTai = maDeTai;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public int getMaCongTy() {
        return maCongTy;
    }

    public void setMaCongTy(int maCongTy) {
        this.maCongTy = maCongTy;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public double getChiSoSoKhop() {
        return chiSoSoKhop;
    }

    public void setChiSoSoKhop(double chiSoSoKhop) {
        this.chiSoSoKhop = chiSoSoKhop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
