/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlysinhvien;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Lop;
import models.MonHoc;
import models.SinhVien;
import models.ThoiKhoaBieu;

/**
 *
 * @author DELL
 */
public class QuanLySinhVien {

    public static List<SinhVien> DocDanhSachLop(String tenFile, String dinhDang) throws 
            UnsupportedEncodingException, FileNotFoundException, IOException {
        
        List<SinhVien> listSinhVien;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(tenFile), dinhDang))) {
            String line;
            List<String> lines = new ArrayList<>();
            
            listSinhVien = new ArrayList<SinhVien>();
            
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }   lines.forEach((element) -> {
                String[] token = element.split(",");
                SinhVien sv = new SinhVien();
                sv.mssv(Integer.parseInt(token[1].replaceAll("\\uFEFF", "")));
                sv.hoten(token[2]);
                sv.gioiTinh(token[3]);
                sv.cmnd(token[4]);
                
                listSinhVien.add(sv);
            });
        }
        
        return listSinhVien;
    }
    
        public static List<MonHoc> DocDanhSachMonHoc(String tenFile, String dinhDang) throws 
            UnsupportedEncodingException, FileNotFoundException, IOException {
        List<MonHoc> listMonHoc;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(tenFile), dinhDang))) {
            String line;
            List<String> lines = new ArrayList<>();
            
            listMonHoc = new ArrayList<MonHoc>();
            
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }   lines.forEach((element) -> {
                String[] token = element.split(",");
                MonHoc mh = new MonHoc();
                mh.maMonHoc(token[1]);
                mh.tenMonHoc(token[2]);
                mh.phongHoc(token[3]);
                listMonHoc.add(mh);
            });
        }
        
        return listMonHoc;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        System.out.print("Nhập tên lớp: ");
        Scanner nhapTenLop = new Scanner(System.in);
        
        String tenLop = nhapTenLop.nextLine();
        
        List<SinhVien> listSinhVien = DocDanhSachLop("Data/Lop/Demo.csv", "UTF-8");
        System.out.println("Lop ban vua nhap: " + tenLop);
         
        Lop lop = new Lop();
        lop.maLop(tenLop);
        lop.danhSachSinhVien(listSinhVien);
        lop.Xuat();
        
        /*
        System.out.print("Nhap lớp muốn thêm sinh viên: ");
        Scanner nhapLop = new Scanner(System.in);
        String lopHoc = nhapLop.nextLine();
        
        if (lopHoc.equals(tenLop)) {
            SinhVien sinhVien = new SinhVien();
            lop.ThemSinhVien(sinhVien);
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            lop.Xuat();
        }
        */
        
        System.out.print("Nhap lớp muốn thêm thời khóa biểu: ");
        Scanner nhapLopThoiKhoaBieu = new Scanner(System.in);
        String lopHocThoiKhoaBieu = nhapLopThoiKhoaBieu.nextLine();
        
        if (lopHocThoiKhoaBieu.equals(tenLop)) {
            List<MonHoc> listMonHoc = DocDanhSachMonHoc("Data/TKB/Demo.csv", "UTF-8");
            ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();
            
            thoiKhoaBieu.lop(lop);
            thoiKhoaBieu.danhSachMonHoc(listMonHoc);
            thoiKhoaBieu.Xuat();
        }
    }
    
}
