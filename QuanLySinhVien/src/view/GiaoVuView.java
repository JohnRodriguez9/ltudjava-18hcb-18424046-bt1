/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author DELL
 */
public class GiaoVuView {
    public static void ManHinhChinh() {
        System.out.println("Man hinh giao vu");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Moi ban nhap lua chon");
        System.out.println("1. Them danh sach lop tu file csv vao he thong");
        System.out.println("2. Them mot sinh vien vao he thong");
        System.out.println("3. Them thoi khoa bieu tu file csv vao he thong");
        System.out.println("4. Huy mon, dang ky hoc cai thien");
        System.out.println("5. Xem danh sach lop");
        System.out.println("6. Xem lai thoi khoa bieu");
        System.out.println("7. Them bang diem tu file csv vao he thong");
        System.out.println("8. Xem lai bang diem, thong ke");
        System.out.println("9. Cap nhat diem cua mot sinh vien");
        System.out.println("10. Thoat chuong trinh");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public static void ThongBaoLopDaTonTai() {
        System.out.println("Lop hoc da ton tai trong he thong ! Vui long nhap lop khac");
    }
}
