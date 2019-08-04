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
 */
public class ThoiKhoaBieu {
    private Lop lop;
    private List<MonHoc> danhSachMonHoc;
    
    // constructor
    public ThoiKhoaBieu() {
        this.lop = new Lop();
        this.danhSachMonHoc = new ArrayList<>();
    }
    
    // getter
    public Lop Lop() {
        return this.lop;
    }
    
    public List<MonHoc> DanhSachMonHoc() {
        return this.danhSachMonHoc;
    }
    
    // setter
    public void lop(Lop lop) {
        this.lop = lop;
    }
    
    // method
    public void danhSachMonHoc(List<MonHoc> danhSachMonHoc) {
        this.danhSachMonHoc = danhSachMonHoc;
    }
    
    public void Xuat() {
        System.out.println("Lop: " + this.lop.MaLop());
        
        System.out.printf("%10s %25s %10s", "Ma mon hoc", "Ten mon hoc", "Phong hoc");
        System.out.println();
        this.danhSachMonHoc.forEach((monHoc) -> {
            monHoc.Xuat();
        });
        
        System.out.println();
    }
}
