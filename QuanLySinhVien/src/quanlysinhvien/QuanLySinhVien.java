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
import models.BangDiem;
import models.DiemSinhVien;
import models.Lop;
import models.LopMonHoc;
import models.MonHoc;
import models.SinhVien;
import models.ThoiKhoaBieu;
import view.GiaoVuView;

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

            listSinhVien = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            lines.forEach((element) -> {
                String[] token = element.split(",");
                SinhVien sv = new SinhVien();
                sv.mssv(Integer.parseInt(token[1].replaceAll("\\uFEFF", "")));
                sv.hoTen(token[2]);
                sv.gioiTinh(token[3]);
                sv.cmnd(token[4]);

                listSinhVien.add(sv);
            });

            return listSinhVien;
        } catch (Exception e) {
            System.out.println("Vui long nhap dung ten lop");
        }
        return null;
    }

    // Doc danh sach mon hoc tu file va dinh dang tuong ung
    public static List<MonHoc> DocDanhSachMonHoc(String tenFile, String dinhDang) throws
            UnsupportedEncodingException, FileNotFoundException, IOException {
        List<MonHoc> listMonHoc;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(tenFile), dinhDang))) {
            String line;
            List<String> lines = new ArrayList<>();

            listMonHoc = new ArrayList<>();

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

    // Doc bang diem mon hoc tu file va dinh dang tuong ung
    public static List<DiemSinhVien> DocDanhSachDiemSinhVien(String tenFile, String dinhDang) throws
            UnsupportedEncodingException, FileNotFoundException, IOException {
        List<DiemSinhVien> danhSachDiemSinhVien;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(tenFile), dinhDang))) {
            String line;
            List<String> lines = new ArrayList<>();

            danhSachDiemSinhVien = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            lines.forEach((element) -> {
                String[] token = element.split(",");
                DiemSinhVien diemSinhVien = new DiemSinhVien();
                diemSinhVien.mssv(Integer.parseInt(token[1].replaceAll("\\uFEFF", "")));
                diemSinhVien.hoTen(token[2]);
                diemSinhVien.diemGiuaKy(Double.parseDouble(token[3].replaceAll("\\uFEFF", "")));
                diemSinhVien.diemCuoiKy(Double.parseDouble(token[4].replaceAll("\\uFEFF", "")));
                diemSinhVien.diemKhac(Double.parseDouble(token[5].replaceAll("\\uFEFF", "")));
                diemSinhVien.diemTong(Double.parseDouble(token[6].replaceAll("\\uFEFF", "")));
                danhSachDiemSinhVien.add(diemSinhVien);
            });
        }

        return danhSachDiemSinhVien;
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        List<Lop> danhSachLop = new ArrayList<>();

        while (true) {
            System.out.println("Chuong trinh quan ly sinh vien");
            GiaoVuView.ManHinhChinh();

            System.out.print("Moi ban nhap lua chon: ");
            Scanner nhapLuaChon = new Scanner(System.in);
            String luaChon = nhapLuaChon.nextLine();

            if (luaChon.equals("1")) {
                // Them mot lop moi vao he thong
                System.out.print("Nhap ma lop ban muon them vao he thong:");
                Scanner nhapMaLop = new Scanner(System.in);
                String maLop = nhapMaLop.nextLine();
                maLop = maLop.toUpperCase();;
                List<SinhVien> danhSachSinhVien = DocDanhSachLop("Data/Lop/" + maLop + ".csv", "UTF-8");

                if (danhSachSinhVien != null) {
                    if (danhSachLop.isEmpty()) {
                        Lop lop = new Lop();
                        lop.maLop(maLop);
                        lop.danhSachSinhVien(danhSachSinhVien);
                        lop.Xuat();
                        danhSachLop.add(lop);
                    } else {
                        for (int i = 0; i < danhSachLop.size(); i++) {
                            if (danhSachLop.get(i).MaLop().equals(maLop)) {
                                GiaoVuView.ThongBaoLopDaTonTai();
                                return;
                            } else {
                                Lop lop = new Lop();
                                lop.maLop(maLop);
                                lop.danhSachSinhVien(danhSachSinhVien);
                                lop.Xuat();
                                danhSachLop.add(lop);
                                break;
                            }
                        }
                    }
                }
            }

            if (luaChon.equals("10")) {
                System.out.println("Ban da thoat khoi man hinh giao vu");
                break;
            }

            System.out.print("Nhap bat cu phim nao de tiep tuc chuong trinh");
            nhapLuaChon.nextLine();
        }

        /*
        List<DiemSinhVien> danhSachDiemSinhVien = DocDanhSachDiemSinhVien("Data/BangDiem/18HCB-CTT001.csv", "UTF-8");
        List<Lop> danhSachLop = new ArrayList<>();
        List<ThoiKhoaBieu> danhSachThoiKhoaBieu = new ArrayList<>();
        Lop lop = new Lop();
        lop.maLop("17HCB");
        lop.danhSachSinhVien(listSinhVien);
        danhSachLop.add(lop);
        //lop.Xuat();

        List<SinhVien> listSinhVien1 = DocDanhSachLop("Data/Lop/18HCB.csv", "UTF-8");
        Lop lop1 = new Lop();
        lop1.maLop("18HCB");
        lop1.danhSachSinhVien(listSinhVien1);
        //lop1.Xuat();
        danhSachLop.add(lop1);
         */
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
 /*
        List<LopMonHoc> danhSachLopMonHoc = new ArrayList<>();
         */
 /*
        System.out.print("Nhap lop muon them thoi khoa bieu: ");
        Scanner nhapLopThoiKhoaBieu = new Scanner(System.in);
        String lopHocThoiKhoaBieu = nhapLopThoiKhoaBieu.nextLine();
         */
 /*
        String lopHocThoiKhoaBieu = "17HCB";
        if (lopHocThoiKhoaBieu.equals("17HCB")) {
            List<MonHoc> listMonHoc = DocDanhSachMonHoc("Data/TKB/17HCB.csv", "UTF-8");
            ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();

            thoiKhoaBieu.lop(lop);
            thoiKhoaBieu.danhSachMonHoc(listMonHoc);
            //thoiKhoaBieu.Xuat();
            
            thoiKhoaBieu.DanhSachMonHoc().forEach((monHoc) -> {
                LopMonHoc lopMonHoc = new LopMonHoc();
                lopMonHoc.lop("17HCB");
                lopMonHoc.monHoc(monHoc);
                lopMonHoc.DanhSachSinHVienMonHoc(listSinhVien);
                danhSachLopMonHoc.add(lopMonHoc);
            }); 
            
            danhSachThoiKhoaBieu.add(thoiKhoaBieu);
        }
         */
 /*
        System.out.print("Nhap lop muon them thoi khoa bieu: ");
        Scanner nhapLopThoiKhoaBieu1 = new Scanner(System.in);
        String lopHocThoiKhoaBieu1 = nhapLopThoiKhoaBieu1.nextLine();
         */
 /*
        String lopHocThoiKhoaBieu1 = "18HCB";
        if (lopHocThoiKhoaBieu1.equals("18HCB")) {
            List<MonHoc> listMonHoc1 = DocDanhSachMonHoc("Data/TKB/18HCB.csv", "UTF-8");
            ThoiKhoaBieu thoiKhoaBieu1 = new ThoiKhoaBieu();

            thoiKhoaBieu1.lop(lop1);
            thoiKhoaBieu1.danhSachMonHoc(listMonHoc1);
            //thoiKhoaBieu1.Xuat();
            
            thoiKhoaBieu1.DanhSachMonHoc().forEach((monHoc) -> {
                LopMonHoc lopMonHoc1 = new LopMonHoc();
                lopMonHoc1.lop("18HCB");
                lopMonHoc1.monHoc(monHoc);
                lopMonHoc1.DanhSachSinHVienMonHoc(listSinhVien1);
                danhSachLopMonHoc.add(lopMonHoc1);
            }); 
            
            danhSachThoiKhoaBieu.add(thoiKhoaBieu1);
        }
         */
 /*
        danhSachLopMonHoc.forEach((lopMonHoc) -> {
            lopMonHoc.Xuat();
        });
         */
 /*
        System.out.print("Nhap lua chon cua ban(1: Chon khong hoc mon hoc, 2: Dang ky hoc cai thien): ");
        Scanner nhapLuaChonMonHoc = new Scanner(System.in);
        String luaChonMonHoc = nhapLuaChonMonHoc.nextLine();
        
        if(luaChonMonHoc.equals("1")) {
            System.out.print("Nhap MSSV: ");
            Scanner nhapMSSV = new Scanner(new InputStreamReader(System.in));
            int mssv = Integer.parseInt(nhapMSSV.nextLine());
            
            System.out.print("Nhap ma lop: ");
            Scanner nhapMaLop = new Scanner(new InputStreamReader(System.in));
            String maLop = nhapMaLop.nextLine();
            
            System.out.print("Nhap ma mon hoc ban khong muon hoc trong hoc ky nay: ");
            Scanner nhapMaMonHoc = new Scanner(new InputStreamReader(System.in));
            String maMonHoc = nhapMaMonHoc.nextLine();
            
             
            danhSachLopMonHoc.forEach((lopMonHoc) -> {
                if (lopMonHoc.Lop().equals(maLop) 
                        && lopMonHoc.MonHoc().MaMonHoc().equals(maMonHoc)) {
                    lopMonHoc.XoaSinhVien(maLop, maMonHoc, mssv);
                    lopMonHoc.Xuat();
                }
            });
        }
        
        if (luaChonMonHoc.equals("2")) {
            System.out.print("Nhap MSSV: ");
            Scanner nhapMSSV = new Scanner(System.in);
            int mssv = Integer.parseInt(nhapMSSV.nextLine());
            
            SinhVien themSinhVien = new SinhVien();
            
            System.out.print("Nhap ma lop cua sinh vien ban vua nhap: ");
            Scanner nhapMaLop = new Scanner(System.in);
            String maLop = nhapMaLop.nextLine();
            
            if(maLop.equals("17HCB")) {
                themSinhVien = lop.TimSinhVien(mssv);    
            }
            
            if(maLop.equals("18HCB")) {
                themSinhVien = lop1.TimSinhVien(mssv);   
            }
            
            System.out.print("Nhap ma mon hoc ban muon hoc cai thien trong hoc ky nay: ");
            Scanner nhapMaMonHoc = new Scanner(System.in);
            String maMonHoc = nhapMaMonHoc.nextLine();
            
            themSinhVien.Xuat();
            for(int i = 0; i < danhSachLopMonHoc.size(); i++) {
                if (danhSachLopMonHoc.get(i).MonHoc().MaMonHoc().equals(maMonHoc)) {
                    danhSachLopMonHoc.get(i).ThemSinhVien(themSinhVien);
                    danhSachLopMonHoc.get(i).Xuat();
                }
            }
        }
        
        System.out.print("Nhap lua chon cua ban (1: Xem danh sach lop, 2: Xem danh sach lop theo mon hoc): ");
        Scanner nhapLuaChonLop = new Scanner(System.in);
        String luaChonLop = nhapLuaChonLop.nextLine();
        
        if (luaChonLop.equals("1")) {
            System.out.print("Nhap ma lop ban muon xem danh sach: ");
            Scanner nhapMaLop = new Scanner(new InputStreamReader(System.in));
            String maLop = nhapMaLop.nextLine();
            
            for (int i = 0; i < danhSachLop.size(); i++) {
                String layMaLop = danhSachLop.get(i).MaLop();
                if (maLop.equals(layMaLop)) {
                    danhSachLop.get(i).Xuat();
                    break;
                }
            }
        }
        
        if (luaChonLop.equals("2")) {
            System.out.print("Nhap ma lop: ");
            Scanner nhapMaLop = new Scanner(new InputStreamReader(System.in));
            String maLop = nhapMaLop.nextLine();
            
            System.out.print("Nhap ma mon hoc tuong ung: ");
            Scanner nhapMaMonHoc = new Scanner(new InputStreamReader(System.in));
            String maMonHoc = nhapMaMonHoc.nextLine();
            
            for (int i = 0; i < danhSachLopMonHoc.size(); i++) {
                String layMaLop = danhSachLopMonHoc.get(i).Lop();
                String layMaMonHoc = danhSachLopMonHoc.get(i).MonHoc().MaMonHoc();
                
                if (maLop.equals(layMaLop) && maMonHoc.equals(layMaMonHoc)) {
                    danhSachLopMonHoc.get(i).Xuat();
                    break;
                }
            }
        }
        
        System.out.print("Nhap lop ban muon xem thoi khoa bieu: ");
        Scanner nhapXemThoiKhoaBieu = new Scanner(new InputStreamReader(System.in));
        String xemThoiKhoaBieuLop = nhapXemThoiKhoaBieu.nextLine();
        
        for (int i = 0; i < danhSachThoiKhoaBieu.size(); i++) {
            String layMaLop = danhSachThoiKhoaBieu.get(i).Lop().MaLop();
            
            if (xemThoiKhoaBieuLop.equals(layMaLop)) {
                danhSachThoiKhoaBieu.get(i).Xuat();
                break;
            }
        }
        
        DiemSinhVien diemSinhVien = new DiemSinhVien();
        diemSinhVien.Xuat();
                
        BangDiem bangDiem = new BangDiem();
        bangDiem.maLop("18HCB");
        bangDiem.maMonHoc("CTT001");
        bangDiem.danhSachDiemSinhVien(danhSachDiemSinhVien);
        bangDiem.XuatBangDiem();
        
        bangDiem.XetDau();
        System.out.println("So luong sinh vien dau: " + bangDiem.SoLuongSinhVienDau());
        bangDiem.XuatBangDiemDau();
        bangDiem.XuatBangDiemRot();
        
        System.out.println("Ty le phan tram sinh vien dau: " + bangDiem.TyLeSinhVienDau() * 100 + "%");
        System.out.println("Ty le phan tram sinh vien rot: " + bangDiem.TyLeSinhVienRot() * 100 + "%");
        
        bangDiem.CapNhatDiemSinhVien(1842001);
        bangDiem.XuatBangDiem();
         */
    }
}
