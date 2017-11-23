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
public class XuatFileThongTinSinhVien {

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
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private int nguoiHuongDan;
    private boolean trangThai;
    private double soKhop;
    private int soLanThucTap;
    private String tenCongTy;
    private String tenDeTai;
    private String baoCaoQuaTrinh;
    private String baoCaoCuoiKy;
    private String chamCong;
    private String danhGia;
    private double diemPhanHoi;
    private double diemBaoCaoQT;
    private double diemQT;
    private double diemCuoiKy;

    public XuatFileThongTinSinhVien() {
    }

    public XuatFileThongTinSinhVien(int mssv, String hoTen, String lop, int khoa, String vienKhoa, String email, int dienThoai, String avatar, Date ngaySinh, String diaChi, boolean lapTop, Date thoiGianBatDau, Date thoiGianKetThuc, int nguoiHuongDan, boolean trangThai, double soKhop, int soLanThucTap, String tenCongTy, String tenDeTai, String baoCaoQuaTrinh, String baoCaoCuoiKy, String chamCong, String danhGia, double diemPhanHoi, double diemBaoCaoQT, double diemQT, double diemCuoiKy) {
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
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.nguoiHuongDan = nguoiHuongDan;
        this.trangThai = trangThai;
        this.soKhop = soKhop;
        this.soLanThucTap = soLanThucTap;
        this.tenCongTy = tenCongTy;
        this.tenDeTai = tenDeTai;
        this.baoCaoQuaTrinh = baoCaoQuaTrinh;
        this.baoCaoCuoiKy = baoCaoCuoiKy;
        this.chamCong = chamCong;
        this.danhGia = danhGia;
        this.diemPhanHoi = diemPhanHoi;
        this.diemBaoCaoQT = diemBaoCaoQT;
        this.diemQT = diemQT;
        this.diemCuoiKy = diemCuoiKy;
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

    public int getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(int nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
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

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public String getBaoCaoQuaTrinh() {
        return baoCaoQuaTrinh;
    }

    public void setBaoCaoQuaTrinh(String baoCaoQuaTrinh) {
        this.baoCaoQuaTrinh = baoCaoQuaTrinh;
    }

    public String getBaoCaoCuoiKy() {
        return baoCaoCuoiKy;
    }

    public void setBaoCaoCuoiKy(String baoCaoCuoiKy) {
        this.baoCaoCuoiKy = baoCaoCuoiKy;
    }

    public String getChamCong() {
        return chamCong;
    }

    public void setChamCong(String chamCong) {
        this.chamCong = chamCong;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public double getDiemPhanHoi() {
        return diemPhanHoi;
    }

    public void setDiemPhanHoi(double diemPhanHoi) {
        this.diemPhanHoi = diemPhanHoi;
    }

    public double getDiemBaoCaoQT() {
        return diemBaoCaoQT;
    }

    public void setDiemBaoCaoQT(double diemBaoCaoQT) {
        this.diemBaoCaoQT = diemBaoCaoQT;
    }

    public double getDiemQT() {
        return diemQT;
    }

    public void setDiemQT(double diemQT) {
        this.diemQT = diemQT;
    }

    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

}
