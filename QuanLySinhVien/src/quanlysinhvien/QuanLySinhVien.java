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

    static String pathBangDiem = "Data/BangDiem/";
    static String pathLop = "Data/Lop/";
    static String pathTKB = "Data/TKB/";

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
            System.out.println("Khong tim thay file theo ten lop ban vua nhap");
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
            return listMonHoc;
        } catch (Exception e) {
            System.out.println("Khong tim thay file theo ten lop ban vua nhap");
        }

        return null;
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
            return danhSachDiemSinhVien;
        } catch (Exception e) {
            System.out.println("Khong tim thay file theo ten lop va ma mon hoc ban vua nhap");
        }

        return null;
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
        List<LopMonHoc> danhSachLopMonHoc = new ArrayList<>();
        List<ThoiKhoaBieu> danhSachThoiKhoaBieu = new ArrayList<>();
        List<BangDiem> danhSachBangDiem = new ArrayList<>();

        String tenDangNhapGiaoVu = "giaovu";
        String matKhauGiaoVu = "giaovu";

        while (true) {
            System.out.println("Chuong trinh quan ly sinh vien");
            Scanner dangNhap = new Scanner(System.in);
            System.out.print("Ten dang nhap: ");
            String tenDangNhap = dangNhap.nextLine();
            System.out.print("Mat khau: ");
            String matKhau = dangNhap.nextLine();

            if (tenDangNhap.equals(tenDangNhapGiaoVu) && matKhau.equals(matKhauGiaoVu)) {
                while (true) {
                    System.out.println("Chuong trinh quan ly sinh vien");
                    GiaoVuView.ManHinhChinh();

                    System.out.print("Moi ban nhap lua chon: ");
                    Scanner nhapLuaChon = new Scanner(System.in);
                    String luaChon = nhapLuaChon.nextLine();

                    // 1. Them mot lop vao he thong
                    if (luaChon.equals("1")) {
                        // Them mot lop moi vao he thong
                        System.out.print("Nhap ma lop ban muon them vao he thong:");
                        Scanner nhapMaLop = new Scanner(System.in);
                        String maLop = nhapMaLop.nextLine();
                        maLop = maLop.toUpperCase();
                        List<SinhVien> danhSachSinhVien = DocDanhSachLop(pathLop + maLop + ".csv", "UTF-8");

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

                    // 2. Them moi mot sinh vien vao mot lop
                    if (luaChon.equals("2")) {
                        System.out.print("Nhap lop ban muon them sinh vien: ");
                        Scanner nhapLop = new Scanner(System.in);
                        String lopHoc = nhapLop.nextLine();

                        if (!danhSachLop.isEmpty()) {
                            boolean tonTaiLop = false;
                            for (int i = 0; i < danhSachLop.size(); i++) {
                                if (danhSachLop.get(i).MaLop().equals(lopHoc)) {
                                    tonTaiLop = true;
                                    SinhVien sinhVien = new SinhVien();
                                    if (danhSachLop.get(i).ThemSinhVien(sinhVien)) {
                                        GiaoVuView.ThongBaoThemSinhVienThanhCong();
                                    } else {
                                        GiaoVuView.ThongBaoSinhVienDaTonTai();
                                    }
                                    break;
                                }
                            }

                            if (tonTaiLop == false) {
                                GiaoVuView.ThongBaoLopKhongTonTai();
                            }
                        } else {
                            GiaoVuView.ThongBaoDSLopRong();
                        }
                    }

                    // 3. Them thoi khoa bieu vao he thong
                    if (luaChon.equals("3")) {
                        System.out.print("Nhap lop muon them thoi khoa bieu: ");
                        Scanner nhapLopThoiKhoaBieu = new Scanner(System.in);
                        String lopHoc = nhapLopThoiKhoaBieu.nextLine();

                        if (!danhSachLop.isEmpty()) {
                            boolean tonTaiLop = false;

                            for (int lop = 0; lop < danhSachLop.size(); lop++) {
                                tonTaiLop = true;
                                if (danhSachLop.get(lop).MaLop().equals(lopHoc)) {
                                    List<MonHoc> danhSachMonHoc = DocDanhSachMonHoc(pathTKB + lopHoc + ".csv", "UTF-8");
                                    ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();
                                    thoiKhoaBieu.lop(danhSachLop.get(lop));
                                    thoiKhoaBieu.danhSachMonHoc(danhSachMonHoc);
                                    thoiKhoaBieu.Xuat();

                                    for (int monHoc = 0; monHoc < thoiKhoaBieu.DanhSachMonHoc().size(); monHoc++) {
                                        LopMonHoc lopMonHoc = new LopMonHoc();
                                        lopMonHoc.lop(lopHoc);
                                        lopMonHoc.monHoc(thoiKhoaBieu.DanhSachMonHoc().get(monHoc));
                                        lopMonHoc.DanhSachSinHVienMonHoc(danhSachLop.get(lop).DanhSachSinhVien());

                                        danhSachLopMonHoc.add(lopMonHoc);
                                    }
                                    danhSachThoiKhoaBieu.add(thoiKhoaBieu);
                                    break;
                                }
                            }

                            if (tonTaiLop == false) {
                                GiaoVuView.ThongBaoLopKhongTonTai();
                            }
                        } else {
                            GiaoVuView.ThongBaoDSLopRong();
                        }
                    }

                    // 4. Huy mon, dang ky hoc cai thien
                    if (luaChon.equals("4")) {
                        System.out.print("Nhap lua chon cua ban(1: Chon khong hoc mon hoc, 2: Dang ky hoc cai thien): ");
                        Scanner nhapLuaChonMonHoc = new Scanner(System.in);
                        String luaChonMonHoc = nhapLuaChonMonHoc.nextLine();

                        // 1. Huy mon
                        if (luaChonMonHoc.equals("1")) {
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

                        // 2. Dang ky hoc cai thien
                        if (luaChonMonHoc.equals("2")) {
                            System.out.print("Nhap MSSV: ");
                            Scanner nhapMSSV = new Scanner(System.in);
                            int mssv = Integer.parseInt(nhapMSSV.nextLine());

                            SinhVien themSinhVien = new SinhVien();

                            System.out.print("Nhap ma lop cua sinh vien ban vua nhap: ");
                            Scanner nhapMaLop = new Scanner(System.in);
                            String maLop = nhapMaLop.nextLine();

                            if (!danhSachLop.isEmpty()) {
                                for (int lop = 0; lop < danhSachLop.size(); lop++) {
                                    if (maLop.equals(danhSachLop)) {
                                        themSinhVien = danhSachLop.get(lop).TimSinhVien(mssv);
                                    }
                                }
                            } else {
                                GiaoVuView.ThongBaoDSLopRong();
                            }

                            System.out.print("Nhap ma mon hoc ban muon hoc cai thien trong hoc ky nay: ");
                            Scanner nhapMaMonHoc = new Scanner(System.in);
                            String maMonHoc = nhapMaMonHoc.nextLine();

                            for (int i = 0; i < danhSachLopMonHoc.size(); i++) {
                                if (danhSachLopMonHoc.get(i).MonHoc().MaMonHoc().equals(maMonHoc)) {
                                    danhSachLopMonHoc.get(i).ThemSinhVien(themSinhVien);
                                    danhSachLopMonHoc.get(i).Xuat();
                                }
                            }
                        }
                    }

                    // 5. Xem lai danh sach lop
                    if (luaChon.equals("5")) {
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
                    }

                    // 6. Xem lai thoi khoa bieu
                    if (luaChon.equals("6")) {
                        System.out.print("Nhap lop ban muon xem thoi khoa bieu: ");
                        Scanner nhapXemThoiKhoaBieu = new Scanner(new InputStreamReader(System.in));
                        String xemThoiKhoaBieuLop = nhapXemThoiKhoaBieu.nextLine();

                        for (int tkb = 0; tkb < danhSachThoiKhoaBieu.size(); tkb++) {
                            String layMaLop = danhSachThoiKhoaBieu.get(tkb).Lop().MaLop();
                            System.out.println(layMaLop);
                            if (xemThoiKhoaBieuLop.equals(layMaLop)) {
                                danhSachThoiKhoaBieu.get(tkb).Xuat();
                                break;
                            }
                        }
                    }

                    // 7. Them bang diem tu file csv vao he thong
                    if (luaChon.equals("7")) {
                        Scanner nhapBangDiem = new Scanner(new InputStreamReader(System.in));
                        System.out.print("Nhap lop ban muon them bang diem: ");
                        String maLop = nhapBangDiem.nextLine();
                        System.out.print("Nhap ma mon hoc ban muon them bang diem: ");
                        String maMonHoc = nhapBangDiem.nextLine();

                        List<DiemSinhVien> danhSachDiemSinhVien = DocDanhSachDiemSinhVien(pathBangDiem + maLop + "-" + maMonHoc + ".csv", "UTF-8");

                        BangDiem bangDiem = new BangDiem();
                        bangDiem.maLop(maLop);
                        bangDiem.maMonHoc(maMonHoc);
                        bangDiem.danhSachDiemSinhVien(danhSachDiemSinhVien);
                        danhSachBangDiem.add(bangDiem);
                        GiaoVuView.ThongBaoThemBangDiemThanhCong();
                    }

                    // 8. Xem lai ban diem va thong ke
                    if (luaChon.equals("8")) {
                        Scanner nhapBangDiem = new Scanner(new InputStreamReader(System.in));
                        System.out.print("Nhap lop ban muon xem bang diem: ");
                        String tenLop = nhapBangDiem.nextLine();
                        System.out.print("Nhap ma mon hoc ban muon xem bang diem: ");
                        String maMonHoc = nhapBangDiem.nextLine();

                        for (int bangDiem = 0; bangDiem < danhSachBangDiem.size(); bangDiem++) {
                            if (danhSachBangDiem.get(bangDiem).MaLop().equals(tenLop)
                                    && danhSachBangDiem.get(bangDiem).MaMonHoc().equals(maMonHoc)) {
                                danhSachBangDiem.get(bangDiem).XetDau();

                                System.out.println("So luong sinh vien dau: " + danhSachBangDiem.get(bangDiem).SoLuongSinhVienDau());
                                danhSachBangDiem.get(bangDiem).XuatBangDiemDau();
                                danhSachBangDiem.get(bangDiem).XuatBangDiemRot();

                                System.out.println("Ty le phan tram sinh vien dau: " + danhSachBangDiem.get(bangDiem).TyLeSinhVienDau() * 100 + "%");
                                System.out.println("Ty le phan tram sinh vien rot: " + danhSachBangDiem.get(bangDiem).TyLeSinhVienRot() * 100 + "%");
                            }
                        }

                    }

                    // 9. Cap nhat diem cua mot sinh vien
                    if (luaChon.equals("9")) {
                        Scanner nhapBangDiem = new Scanner(new InputStreamReader(System.in));
                        System.out.print("Nhap lop ban muon cap nhat bang diem: ");
                        String tenLop = nhapBangDiem.nextLine();
                        System.out.print("Nhap ma mon hoc ban muon cap nhat bang diem: ");
                        String maMonHoc = nhapBangDiem.nextLine();

                        for (int bangDiem = 0; bangDiem < danhSachBangDiem.size(); bangDiem++) {
                            if (danhSachBangDiem.get(bangDiem).MaLop().equals(tenLop)
                                    && danhSachBangDiem.get(bangDiem).MaMonHoc().equals(maMonHoc)) {
                                System.out.print("Nhap ma so sinh vien ban muon cap nhat diem: ");
                                int mssv = Integer.parseInt(nhapBangDiem.nextLine());
                                danhSachBangDiem.get(bangDiem).CapNhatDiemSinhVien(mssv);
                            }
                        }
                    }

                    // 0. Thoat khoi chuong trinh
                    if (luaChon.equals("0")) {
                        System.out.println("Ban da thoat khoi man hinh giao vu");
                        break;
                    }

                    System.out.print("Nhap bat cu phim nao de tiep tuc chuong trinh");
                    nhapLuaChon.nextLine();
                }
            }
        }
    }
}
