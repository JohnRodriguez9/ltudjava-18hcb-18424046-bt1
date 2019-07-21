/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Nhan
 */
public class LopMonHoc {
    private String lop;
    private MonHoc monHoc;
    private List<SinhVien> danhSachSinhVienMonHoc;
    
    // constructor
    public LopMonHoc() {
        this.monHoc = new MonHoc();
        this.lop = "";
        this.danhSachSinhVienMonHoc = new ArrayList<>();
    }
    
    // getter
    public String Lop() {
        return this.lop;
    }
    
    public MonHoc MonHoc() {
        return this.monHoc;
    }
    
    public List<SinhVien> DanhSachSinhVienMonHoc() {
        return this.danhSachSinhVienMonHoc;
    }
    
    // setter    
    public void lop(String lop) {
        this.lop = lop;
    }
    
    public void monHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
    
    public void DanhSachSinHVienMonHoc(List<SinhVien> danhSachSinhVienMonHoc) {
        this.danhSachSinhVienMonHoc = danhSachSinhVienMonHoc;
    }
    
    // Them mot sinh vien vao danh sach lop thuoc mon hoc tuong ung
    public void ThemSinhVien(SinhVien sv) {
        if (sv != null) { 
            this.danhSachSinhVienMonHoc.forEach((sinhVienMonHoc) -> {
                if (sinhVienMonHoc.MSSV() == sv.MSSV()) {
                   return;
                }
            });
            
            this.danhSachSinhVienMonHoc.add(sv);
        }
    }
    
    // Xoa mot sinh vien trong danh sach lop thuoc mon hoc tuong ung theo ma lop va ma mon hoc
    public void XoaSinhVien(String maLop, String maMonHoc, int mssv) {
        if (maLop != null && maMonHoc != null && mssv != 0) {
            this.danhSachSinhVienMonHoc.removeIf(s -> s.MSSV() == mssv);
        }
    }
    
    public void Xuat() {
        System.out.println("Lop: " + this.lop + '-' + this.MonHoc().MaMonHoc());
        
        System.out.printf("%10s %15s %10s %12s", "MSSV", "Ho ten", "Gioi Tinh", "CMND");
        System.out.println();
        this.danhSachSinhVienMonHoc.forEach((sinhVien) -> {
            sinhVien.Xuat();
        });
        System.out.println();
    }
}
