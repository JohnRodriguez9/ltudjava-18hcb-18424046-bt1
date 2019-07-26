/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class DiemSinhVien extends SinhVien {
    private double diemGiuaKy;
    private double diemCuoiKy;
    private double diemKhac;
    private double diemTong;
    private boolean dau;
    
    // constructor
    public DiemSinhVien() {
        this.diemGiuaKy = 0;
        this.diemCuoiKy = 0;
        this.diemKhac = 0;
        this.diemTong = 0;
        this.dau = false;
    }
    
    // getter
    public double DiemGiuaKy() {
        return this.diemGiuaKy;
    }
    
    public double DiemCuoiKy() {
        return this.diemCuoiKy;
    }
    
    public double DiemKhac() {
        return this.diemKhac;
    }
    
    public double DiemTong() {
        return this.diemTong;
    }
    
    public boolean Dau() {
        return this.dau;
    }
    
    // setter
    public void diemGiuaKy(double diemGiuaKy) {
        this.diemGiuaKy = diemGiuaKy;
    }
    
    public void diemCuoiKy(double diemCuoiKy) {
        this.diemCuoiKy = diemCuoiKy;
    }
    
    public void diemKhac(double diemKhac) {
        this.diemKhac = diemKhac;
    }
    
    public void diemTong(double diemTong) {
        this.diemTong = diemTong;
    }
    
    public void dau(boolean dau) {
        this.dau = dau;
    }
    
    public void NhapDiem() {
        System.out.print("Nhap diem giua ky: ");
        Scanner nhapDiemGiuaKy = new Scanner(System.in);
        this.diemGiuaKy = Double.parseDouble(nhapDiemGiuaKy.nextLine());
        
        System.out.print("Nhap diem cuoi ky: ");
        Scanner nhapDiemCuoiKy = new Scanner(System.in);
        this.diemCuoiKy = Double.parseDouble(nhapDiemCuoiKy.nextLine());
        
        System.out.print("Nhap diem khac: ");
        Scanner nhapDiemKhac = new Scanner(System.in);
        this.diemKhac = Double.parseDouble(nhapDiemKhac.nextLine());
        
        System.out.print("Nhap diem tong: ");
        Scanner nhapDiemTong = new Scanner(System.in);
        this.diemTong = Double.parseDouble(nhapDiemTong.nextLine());
    }
    
    public void XuatDiem() {
        System.out.format("%10d %15s %8.2f %8.2f %8.2f %8.2f", this.mssv, this.hoTen, this.diemGiuaKy, this.diemCuoiKy, this.diemKhac, this.diemTong);
        System.out.println();
    }
}
