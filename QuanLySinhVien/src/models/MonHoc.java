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
public class MonHoc {
    private String maMonHoc;
    private String tenMonHoc;
    private String phongHoc;
    
    // constructor
    public MonHoc() {
        this.maMonHoc = "";
        this.tenMonHoc = "";
        this.phongHoc = "";
    }
    
    // getter
    public String MaMonHoc() {
        return this.maMonHoc;
    }
    
    public String TenMonHoc() {
        return this.tenMonHoc;
    }
    
    public String PhongHoc() {
        return this.phongHoc;
    }
    
    // setter
    public void maMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }
            
    public void tenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
    
    public void phongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }
    
    public void Xuat() {
        System.out.println("Mã môn học: " + this.maMonHoc);
        System.out.println("Tên môn học: " + this.tenMonHoc);
        System.out.println("Phòng học: " + this.phongHoc);
        System.out.println();
    }
}
