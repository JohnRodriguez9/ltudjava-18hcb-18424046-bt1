/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

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
}
