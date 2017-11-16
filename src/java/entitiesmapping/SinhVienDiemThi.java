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
public class SinhVienDiemThi {
    private int mssv;
    private String hoTen;
    private String lop;
    private double diemQuaTrinhCT;
    private double diemCuoiKyCT;
    private double diemQuaTrinh;
    private double diemBaoCaoQuaTrinh;
    private double diemPhanHoi;
    private double diemCuoiKy;
    private int soLuongPhanHoi;

    public SinhVienDiemThi() {
    }

    public SinhVienDiemThi(int mssv, String hoTen, String lop, double diemQuaTrinhCT, double diemCuoiKyCT, double diemQuaTrinh, double diemCuoiKy) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.lop = lop;
        this.diemQuaTrinhCT = diemQuaTrinhCT;
        this.diemCuoiKyCT = diemCuoiKyCT;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemCuoiKy = diemCuoiKy;
    }

    public double getDiemBaoCaoQuaTrinh() {
        return diemBaoCaoQuaTrinh;
    }

    public void setDiemBaoCaoQuaTrinh(double diemBaoCaoQuaTrinh) {
        this.diemBaoCaoQuaTrinh = diemBaoCaoQuaTrinh;
    }

    public double getDiemPhanHoi() {
        return diemPhanHoi;
    }

    public void setDiemPhanHoi(double diemPhanHoi) {
        this.diemPhanHoi = diemPhanHoi;
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

    public double getDiemQuaTrinhCT() {
        return diemQuaTrinhCT;
    }

    public void setDiemQuaTrinhCT(double diemQuaTrinhCT) {
        this.diemQuaTrinhCT = diemQuaTrinhCT;
    }

    public double getDiemCuoiKyCT() {
        return diemCuoiKyCT;
    }

    public void setDiemCuoiKyCT(double diemCuoiKyCT) {
        this.diemCuoiKyCT = diemCuoiKyCT;
    }

    public double getDiemQuaTrinh() {
        return diemQuaTrinh;
    }

    public void setDiemQuaTrinh(double diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
    }

    public double getDiemCuoiKy() {
        return diemCuoiKy;
    }

    public void setDiemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }

    public int getSoLuongPhanHoi() {
        return soLuongPhanHoi;
    }

    public void setSoLuongPhanHoi(int soLuongPhanHoi) {
        this.soLuongPhanHoi = soLuongPhanHoi;
    }

    
    
    
}
