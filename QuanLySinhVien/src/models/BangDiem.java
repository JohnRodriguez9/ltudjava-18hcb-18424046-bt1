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
    private String maLop;
    private String maMonHoc;
    private List<DiemSinhVien> danhSachDiemSinhVien;
    private int soLuongSinhVienDau;
    
    // constructor
    public BangDiem() {
        this.maLop = "";
        this.maMonHoc = "";
        this.danhSachDiemSinhVien = new ArrayList<>();
        this.soLuongSinhVienDau = 0;
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
    
    public int SoLuongSinhVienDau() {
        return this.soLuongSinhVienDau;
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
    
    public void soLuongSinhVienDau(int soLuongSinhVienDau) {
        this.soLuongSinhVienDau = soLuongSinhVienDau;
    }
    
    public void XuatBangDiem() {
        System.out.println("Bang diem cua lop: " + this.maLop + '-' + this.maMonHoc);
        
        System.out.printf("%10s %15s %8s %8s %8s %8s", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem tong");
        System.out.println();
        for(int i = 0; i < this.danhSachDiemSinhVien.size(); i++) {
            this.danhSachDiemSinhVien.get(i).XuatDiem();
        }
    }
    
    public void XetDau() {
        for(int i = 0; i < this.danhSachDiemSinhVien.size(); i++) {
            if(this.danhSachDiemSinhVien.get(i).DiemTong() >= 5) {
                this.danhSachDiemSinhVien.get(i).dau(true);
                this.soLuongSinhVienDau++;
            }
        }
    }
    
    public void XuatBangDiemDau() {
        System.out.println("Danh sach dau");
        
        System.out.printf("%10s %15s %8s %8s %8s %8s", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem tong");
        System.out.println();
        
        for(int i = 0; i < this.danhSachDiemSinhVien.size(); i++) {
            boolean ketQua = this.danhSachDiemSinhVien.get(i).Dau();
            
            if (ketQua) {
                this.danhSachDiemSinhVien.get(i).XuatDiem();
            }
        }
    }

    public void XuatBangDiemRot() {
        System.out.println("Danh sach dau");

        System.out.printf("%10s %15s %8s %8s %8s %8s", "MSSV", "Ho ten", "Diem GK", "Diem CK", "Diem Khac", "Diem tong");
        System.out.println();

        for (int i = 0; i < this.danhSachDiemSinhVien.size(); i++) {
            boolean ketQua = this.danhSachDiemSinhVien.get(i).Dau();

            if (ketQua) {
                this.danhSachDiemSinhVien.get(i).XuatDiem();
            }
        }
    }
    
    public double TyLeSinhVienDau() {
        int soLuongSinhVien = this.danhSachDiemSinhVien.size();
        return ((double)this.soLuongSinhVienDau) / soLuongSinhVien;
    }
    
    public double TyLeSinhVienRot() {
        int soLuongSinhVien = this.danhSachDiemSinhVien.size();
        return ((double)(soLuongSinhVien - this.soLuongSinhVienDau))/ soLuongSinhVien;
    } 
}
