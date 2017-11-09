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
public class CongTyDeTai {

    private int msct;
    private String tenCongTy;
    private String diaChi;
    private String dienThoai;
    private String email;
    private String website;
    private String linhVucHoatDong;
    private String moTa;
    private String avatar;
    
    private int id;
    private int maCongTy;
    private String tenDeTai;
    private String noiDung;
    private String yeuCau;
    private String nguoiDang;
    private int soLuong;

    public CongTyDeTai() {
    }

    
    
    public CongTyDeTai(int msct, String tenCongTy, String diaChi, String dienThoai, String email, String website, String linhVucHoatDong, String moTa, int id, int maCongTy, String tenDeTai, String noiDung, String yeuCau, String nguoiDang) {
        this.msct = msct;
        this.tenCongTy = tenCongTy;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.email = email;
        this.website = website;
        this.linhVucHoatDong = linhVucHoatDong;
        this.moTa = moTa;
        this.id = id;
        this.maCongTy = maCongTy;
        this.tenDeTai = tenDeTai;
        this.noiDung = noiDung;
        this.yeuCau = yeuCau;
        this.nguoiDang = nguoiDang;
    }

    public int getMsct() {
        return msct;
    }

    public void setMsct(int msct) {
        this.msct = msct;
    }

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLinhVucHoatDong() {
        return linhVucHoatDong;
    }

    public void setLinhVucHoatDong(String linhVucHoatDong) {
        this.linhVucHoatDong = linhVucHoatDong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaCongTy() {
        return maCongTy;
    }

    public void setMaCongTy(int maCongTy) {
        this.maCongTy = maCongTy;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getYeuCau() {
        return yeuCau;
    }

    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    public String getNguoiDang() {
        return nguoiDang;
    }

    public void setNguoiDang(String nguoiDang) {
        this.nguoiDang = nguoiDang;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    
}
