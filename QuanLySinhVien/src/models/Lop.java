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
    private ArrayList<SinhVien> danhSachSinhVien;
    
    public Lop() {
        this.maLop = "";
        this.danhSachSinhVien = new ArrayList<SinhVien>();
    }
    
    // getter
    public String MaLop() {
        return this.maLop;
    }
    
    public ArrayList<SinhVien> DanhSachSinhVien() {
        return this.danhSachSinhVien;
    }
    
    // setter
    public void maLop(String maLop) {
        this.maLop = maLop;
    }
    
    public void danhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }
}
