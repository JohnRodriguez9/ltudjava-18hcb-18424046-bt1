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
import java.util.StringTokenizer;
import models.Lop;
import models.SinhVien;

/**
 *
 * @author DELL
 */
public class QuanLySinhVien {

    public static List<SinhVien> DocFile(String tenFile, String dinhDang) throws 
            UnsupportedEncodingException, FileNotFoundException, IOException {
        List<SinhVien> listSinhVien;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream("Data/Demo.csv"), "UTF-8"))) {
            String line;
            List<String> lines = new ArrayList<>();
            listSinhVien = new ArrayList<SinhVien>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }   lines.forEach((element) -> {
                String[] token = element.split(",");
                SinhVien sv = new SinhVien();
                sv.mssv(Integer.parseInt(token[0].replaceAll("\\uFEFF", "")));
                sv.hoten(token[1]);
                sv.gioiTinh(token[2]);
                sv.cmnd(token[3]);
                
                listSinhVien.add(sv);
            });
        }
        
        return listSinhVien;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        System.out.print("Nhập tên lớp: ");
        Scanner nhapTenLop = new Scanner(System.in);
        
        String tenLop = nhapTenLop.nextLine();
        
        List<SinhVien> listSinhVien = DocFile("Data/Demo.csv", "UTF-8");
        System.out.println("Lop ban vua nhap: " + tenLop);
         
        Lop lop = new Lop();
        lop.maLop(tenLop);
        lop.danhSachSinhVien(listSinhVien);
        lop.Xuat();
        
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
        
    }
    
}
