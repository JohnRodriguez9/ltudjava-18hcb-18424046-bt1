/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 */
public class SinhVienView {
        // Man hinh chinh
    public static void ManHinhChinh() {
        System.out.println("Man hinh sinh vien");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Moi ban nhap lua chon");
        System.out.println("1. Xem diem theo mon hoc");
        System.out.println("2. Doi mat khau");
        System.out.println("0. Thoat chuong trinh");
        for(int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
