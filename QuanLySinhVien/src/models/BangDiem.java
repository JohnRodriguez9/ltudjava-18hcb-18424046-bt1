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
public class BangDiem {
    String maLop;
    String maMonHoc;
    List<DiemSinhVien> danhSachDiemSinhVien;
    
    // constructor
    public BangDiem() {
        this.maLop = "";
        this.maMonHoc = "";
        List<DiemSinhVien> danhSachDiemSinhVien = new ArrayList<>();
    }
    
    // getter
    public String MaLop() {
        return this.maLop;
    }
    
    public String MaMonHoc() {
        return this.maMonHoc;
    }
    
    public List<DiemSinhVien> DanhSachDiemSinhVien() {
        return this.danhSachDiemSinhVien;
    }
    
    // setter
    public void maLop(String maLop) {
        this.maLop = maLop;
    }
    
    public void maMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
    
    public void danhSachDiemSinhVien(List<DiemSinhVien> danhSachDiemSinhVien) {
        this.danhSachDiemSinhVien = danhSachDiemSinhVien;
    }
    
    public void XuatBangDiem() {
        System.out.println("Bang diem cua lop: " + this.maLop + '-' + this.maMonHoc);
        
        System.out.printf("%10s %15s %8s %8s %8s %8s", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem tong");
        System.out.println();
        for(int i = 0; i < danhSachDiemSinhVien.size(); i++) {
            danhSachDiemSinhVien.get(i).XuatDiem();
        }
    }
}
