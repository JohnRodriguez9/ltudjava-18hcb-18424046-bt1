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
 * @author Nhan
 */
public class LopMonHoc {
    private Lop lop;
    private MonHoc monHoc;
    private List<SinhVien> danhSachSinhVienMonHoc;
    
    // constructor
    public LopMonHoc() {
        this.monHoc = new MonHoc();
        this.lop = new Lop();
        this.danhSachSinhVienMonHoc = new ArrayList<>();
    }
    
    // getter
    public Lop lop() {
        return this.lop;
    }
    
    public MonHoc MonHoc() {
        return this.monHoc;
    }
    
    public List<SinhVien> DanhSachSinhVienMonHoc() {
        return this.danhSachSinhVienMonHoc;
    }
    
    // setter
    public void lop(Lop lop) {
        this.lop = lop;
    }
    
    public void monHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }
    
    public void DanhSachSinHVienMonHoc(List<SinhVien> danhSachSinhVienMonHoc) {
        this.danhSachSinhVienMonHoc = danhSachSinhVienMonHoc;
    }
    
    // Them sinh vien vao danh sach lop thuoc mon hoc tuong ung
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
}
