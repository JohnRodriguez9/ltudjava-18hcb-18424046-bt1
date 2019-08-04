/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Scanner;

/**
 *
 */
public class SinhVien {
    protected int mssv;
    protected String hoTen;
    private String gioiTinh;
    private String cmnd;
    private String tenDangNhap;
    private String matKhau;
    
    public SinhVien() {
        this.mssv = -1;
        this.hoTen = "";
        this.gioiTinh = "";
        this.cmnd = "";
        this.tenDangNhap = "";
        this.matKhau = "";
    }
    
    public SinhVien(
            int mssv, 
            String hoTen, 
            String gioiTinh, 
            String cmnd,
            String tenDangNhap,
            String matKhau) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    
    //getter
    public int MSSV() {
        return this.mssv;
    }
    
    public String HoTen() {
        return this.hoTen;
    }
    
    public String GioiTinh() {
        return this.gioiTinh;
    }
    
    public String CMND() {
        return this.cmnd;
    }
    
    public String TenDangNhap() {
        return this.tenDangNhap;
    }
    
    public String MatKhau() {
        return this.matKhau;
    }
    
    //setter
    public void mssv(int mssv) {
        this.mssv = mssv;
    }
    
    public void hoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public void gioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public void cmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    
    public void tenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    
    public void matKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    // method
    public void Nhap() {
        Scanner nhapSV = new Scanner(System.in);
        System.out.print("Nhap MSSV: ");
        this.mssv = Integer.parseInt(nhapSV.nextLine());
        
        System.out.print("Nhap ho va ten: ");
        this.hoTen = nhapSV.nextLine();
        
        System.out.print("Nhập gioi tinh: ");
        this.gioiTinh = nhapSV.nextLine();
        
        System.out.print("Nhap CMND: ");
        this.cmnd = nhapSV.nextLine();
        
        this.tenDangNhap = Integer.toString(this.mssv);
        this.matKhau = Integer.toString(this.mssv);
    }
    
    public void Xuat() {
        System.out.format("%10d %15s %10s %14s", this.mssv, this.hoTen, this.gioiTinh, this.cmnd);
        System.out.println();
    }
}
