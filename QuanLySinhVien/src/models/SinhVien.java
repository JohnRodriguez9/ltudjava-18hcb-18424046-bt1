/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Scanner;

/**
 *
 * @author Nhan
 */
public class SinhVien {
    protected int mssv;
    protected String hoTen;
    private String gioiTinh;
    private String cmnd;
    
    public SinhVien() {
        this.mssv = -1;
        this.hoTen = "";
        this.gioiTinh = "";
        this.cmnd = "";
    }
    
    public SinhVien(int mssv, String hoTen, String gioiTinh, String cmnd) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
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
    }
    
    public void Xuat() {
        System.out.format("%10d %15s %10s %14s", this.mssv, this.hoTen, this.gioiTinh, this.cmnd);
        System.out.println();
    }
}
