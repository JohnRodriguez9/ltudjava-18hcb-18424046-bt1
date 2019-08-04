/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 */
public class DangNhapView {
    // Man hinh chinh
    public static void ManHinhChinh() {
        System.out.println("Chuong trinh quan ly sinh vien");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Moi ban nhap lua chon");
        System.out.println("1. Dang nhap vao he thong");
        System.out.println("0. Thoat");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    // Thong bao
    public static void ThongBaoDangNhapThatBai() {
        System.out.println("Ten dang nhap hoac mat khau khong dung, vui long kiem tra lai");
    }
    
    public static void ThongBaoDoiMatKhauThanhCong() {
        System.out.println("Doi mat khau thanh cong");
    }
    
    public static void ThongBaoMatKhauHienTaiKhongDung() {
        System.out.println("Mat khau hien tai khong dung");
    }
    
    public static void ThongBaoXacNhanMatKhauKhongDung() {
        System.out.println("Xac nhan mat khau moi khong dung");
    }
    
    public static void ThongBaoDoiMatKhauThatBai() {
        System.out.println("Doi mat khau that bai");
    }
}
