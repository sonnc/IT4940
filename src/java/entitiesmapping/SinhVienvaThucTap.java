/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitiesmapping;

import java.util.Date;

/**
 *
 * @author sonnguyen
 */
public class SinhVienvaThucTap {

    private int mssv;
    private String hoTen;
    private String lop;
    private int khoa;
    private String vienKhoa;
    private String email;
    private int dienThoai;
    private String avatar;
    private Date ngaySinh;
    private String diaChi;
    private boolean lapTop;
    private int id; // mã xếp của sinh viên
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private int maCongTy;
    private int nguoiHuongDan;
    private int maDeTai;
    private boolean trangThai;
    private double soKhop;
    private int soLanThucTap;

    public SinhVienvaThucTap() {
    }

    public SinhVienvaThucTap(int mssv, String hoTen, String lop, int khoa, String vienKhoa, String email, int dienThoai, String avatar, Date ngaySinh, String diaChi, boolean lapTop, int id, Date thoiGianBatDau, Date thoiGianKetThuc, int maCongTy, int nguoiHuongDan, int maDeTai, boolean trangThai, double soKhop) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.lop = lop;
        this.khoa = khoa;
        this.vienKhoa = vienKhoa;
        this.email = email;
        this.dienThoai = dienThoai;
        this.avatar = avatar;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.lapTop = lapTop;
        this.id = id;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.maCongTy = maCongTy;
        this.nguoiHuongDan = nguoiHuongDan;
        this.maDeTai = maDeTai;
        this.trangThai = trangThai;
        this.soKhop = soKhop;
    }

    public int getMssv() {
        return mssv;
    }

    public void setMssv(int mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
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

    public String getVienKhoa() {
        return vienKhoa;
    }

    public void setVienKhoa(String vienKhoa) {
        this.vienKhoa = vienKhoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean getLapTop() {
        return lapTop;
    }

    public void setLapTop(boolean lapTop) {
        this.lapTop = lapTop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public int getMaCongTy() {
        return maCongTy;
    }

    public void setMaCongTy(int maCongTy) {
        this.maCongTy = maCongTy;
    }

    public int getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(int nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }

    public int getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(int maDeTai) {
        this.maDeTai = maDeTai;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getSoKhop() {
        return soKhop;
    }

    public void setSoKhop(double soKhop) {
        this.soKhop = soKhop;
    }

    public int getSoLanThucTap() {
        return soLanThucTap;
    }

    public void setSoLanThucTap(int soLanThucTap) {
        this.soLanThucTap = soLanThucTap;
    }
    
    
}
