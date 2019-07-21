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
    
    // Doc danh sach file tu dinh dang tuong ung
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
            }
            lines.forEach((element) -> {
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

    // Doc danh sach mon hoc tu file va dinh dang tuong ung
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
            }
            lines.forEach((element) -> {
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

        List<SinhVien> listSinhVien = DocDanhSachLop("Data/Lop/17HCB.csv", "UTF-8");
        Lop lop = new Lop();
        lop.maLop("17HCB");
        lop.danhSachSinhVien(listSinhVien);
        lop.Xuat();

        List<SinhVien> listSinhVien1 = DocDanhSachLop("Data/Lop/18HCB.csv", "UTF-8");
        Lop lop1 = new Lop();
        lop1.maLop("18HCB");
        lop1.danhSachSinhVien(listSinhVien1);
        lop1.Xuat();

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
        System.out.print("Nhap lop muon them thoi khoa bieu: ");
        Scanner nhapLopThoiKhoaBieu = new Scanner(System.in);
        String lopHocThoiKhoaBieu = nhapLopThoiKhoaBieu.nextLine();

        if (lopHocThoiKhoaBieu.equals("17HCB")) {
            List<MonHoc> listMonHoc = DocDanhSachMonHoc("Data/TKB/17HCB.csv", "UTF-8");
            ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();

            thoiKhoaBieu.lop(lop);
            thoiKhoaBieu.danhSachMonHoc(listMonHoc);
            thoiKhoaBieu.Xuat();
        }

        System.out.print("Nhap lop muon them thoi khoa bieu: ");
        Scanner nhapLopThoiKhoaBieu1 = new Scanner(System.in);
        String lopHocThoiKhoaBieu1 = nhapLopThoiKhoaBieu1.nextLine();

        if (lopHocThoiKhoaBieu1.equals("18HCB")) {
            List<MonHoc> listMonHoc1 = DocDanhSachMonHoc("Data/TKB/18HCB.csv", "UTF-8");
            ThoiKhoaBieu thoiKhoaBieu1 = new ThoiKhoaBieu();

            thoiKhoaBieu1.lop(lop1);
            thoiKhoaBieu1.danhSachMonHoc(listMonHoc1);
            thoiKhoaBieu1.Xuat();
        }

        System.out.print("Nhap lua chon cua ban(1: Chon khong hoc mon hoc, 2: Dang ky hoc cai thien): ");
        Scanner nhapLuaChon = new Scanner(System.in);
        String luaChon = nhapLuaChon.nextLine();
        
        if(luaChon.equals("1")) {
            System.out.print("Nhap mon hoc ban khong muon hoc trong hoc ky nay: ");
            Scanner nhapMonHoc = new Scanner(new InputStreamReader(System.in));
            String monHoc = nhapMonHoc.nextLine();
            
            System.out.print("Mon hoc ban vua chon: " + monHoc);
        }
    }

}
