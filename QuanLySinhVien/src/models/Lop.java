/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nhan
 */
public class Lop {
    private String maLop;
    private List<SinhVien> danhSachSinhVien;
    
    public Lop() {
        this.maLop = "";
        this.danhSachSinhVien = new ArrayList<>();
    }
    
    // getter
    public String MaLop() {
        return this.maLop;
    }
    
    public List<SinhVien> DanhSachSinhVien() {
        return this.danhSachSinhVien;
    }
    
    // setter
    public void maLop(String maLop) {
        this.maLop = maLop;
    }
    
    public void danhSachSinhVien(List<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }
    
    public void Xuat() {
        System.out.println("Lop: " + this.maLop);
        
        System.out.printf("%10s %15s %10s %12s", "MSSV", "Ho ten", "Gioi Tinh", "CMND");
        System.out.println();
        this.danhSachSinhVien.forEach((sinhVien) -> {
            sinhVien.Xuat();
        });
        System.out.println();
    }
    
    public void ThemSinhVien(SinhVien sv) {
        if (sv != null) { 
            sv.Nhap();
            this.danhSachSinhVien.add(sv);
        }
    }
    
    // Tim kiem sinh vien theo mssv tuong ung
    public SinhVien TimSinhVien(int mssv) {
        SinhVien sv = new SinhVien();
        
        this.danhSachSinhVien.forEach((sinhVien) -> {
            if (sinhVien.MSSV() == mssv) {
                sv.mssv(sinhVien.MSSV());
                sv.hoTen(sinhVien.HoTen());
                sv.gioiTinh(sinhVien.GioiTinh());
                sv.cmnd(sinhVien.CMND());
            }
        });
        
        return sv;
    }
}
