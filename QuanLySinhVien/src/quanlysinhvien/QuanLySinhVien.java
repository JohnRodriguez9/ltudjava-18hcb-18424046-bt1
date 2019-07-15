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
import java.util.StringTokenizer;
import models.SinhVien;

/**
 *
 * @author DELL
 */
public class QuanLySinhVien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader reader = new BufferedReader(new InputStreamReader(
            new FileInputStream("Data/Demo.csv"), "UTF-8"));
        List<String> lines = new ArrayList<>();
        List<SinhVien> listSinhVien = new ArrayList<SinhVien>();
        List<String> tokenLine = new ArrayList<>();
        String line = null;
        
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        
        lines.forEach((element) -> {
            String[] token = element.split(",");
            SinhVien sv = new SinhVien();
            sv.mssv(Integer.parseInt(token[0].replaceAll("\\uFEFF", "")));
            sv.hoten(token[1]);
            sv.gioiTinh(token[2]);
            sv.cmnd(token[3]);
            
            listSinhVien.add(sv);
        });
        
        listSinhVien.forEach((sinhVien) -> {
            System.out.println(sinhVien.MSSV());
            System.out.println(sinhVien.HoTen());
            System.out.println(sinhVien.GioiTinh());
            System.out.println(sinhVien.CMND());
        });
    }
    
}
