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
    private int mssv;
    private String hoTen;
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
    
    public void hoten(String hoTen) {
        this.hoTen = hoTen;
    }
    
    public void gioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public void cmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    
    public void Nhap() {
        System.out.print("Nhập MSSV: ");
        Scanner nhapMSSV = new Scanner(System.in);
        this.mssv = Integer.parseInt(nhapMSSV.nextLine());
        
        System.out.print("Nhập họ và tên: ");
        Scanner nhapHoTen = new Scanner(System.in);
        this.hoTen = nhapHoTen.nextLine();
        
        System.out.print("Nhập giới tính: " + this.gioiTinh);
        Scanner nhapGioiTinh = new Scanner(System.in);
        this.gioiTinh = nhapGioiTinh.nextLine();
        
        System.out.print("Nhập CMND: " + this.cmnd);
        Scanner nhapCMND = new Scanner(System.in);
        this.cmnd = nhapCMND.nextLine();
    }
    
    public void Xuat() {
        System.out.println("MSSV: " + this.mssv);
        System.out.println("Họ tên: " + this.hoTen);
        System.out.println("Giới tính: " + this.gioiTinh);
        System.out.println("CMND: " + this.cmnd);
        System.out.println();
    }
}
