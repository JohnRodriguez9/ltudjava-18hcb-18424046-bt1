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
 * @author DELL
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
        
        this.danhSachSinhVien.forEach((sinhVien) -> {
            sinhVien.Xuat();
        });
    }
    
    public void ThemSinhVien(SinhVien sv) {
        if (sv != null) { 
            sv.Nhap();
            this.danhSachSinhVien.add(sv);
        }
    }
}
