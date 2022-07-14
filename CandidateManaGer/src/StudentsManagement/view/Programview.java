package StudentsManagement.view;

import StudentsManagement.AppUntils.AppUntils;
import StudentsManagement.AppUntils.CSVUntils;
import StudentsManagement.Model.SinhVien;
import StudentsManagement.service.DanhSachSinhVien;

import java.util.*;

public class Programview {
    DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();

    public void Orderview() {
        Programview programview = new Programview();
        int chose;
        do {
            System.out.println("----  CHUONG TRINH QUAN LI SINH VIEN  ----");
            System.out.println("chon chuc nang theo so(de tiep tuc)");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2.Them Moi");
            System.out.println("3. Cap Nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Doc tu file");
            System.out.println("7. Ghi vao file");
            System.out.println("8. Thoat");
            System.out.println("chon chuc nang");
            chose = AppUntils.choseAgain(1, 8);
            switch (chose) {
                case 1:
                    danhSachSinhVien.danhSachSinhVien();
                    break;
                case 2:
                    danhSachSinhVien.themSinhVien();
                    break;
                case 3:
                    danhSachSinhVien.chinhSuaThongTIn();
                    break;
                case 4:
                    danhSachSinhVien.xoaSV();
                    break;
                case 5:
                    programview.SortView();
                    break;
                case 6:
                    if (AppUntils.areYouSure("Doc tu file")) {
                        for (SinhVien sinhVien : danhSachSinhVien.showDanhSach()) {
                            System.out.println(SinhVien.SinhvienFomat(sinhVien));
                        }
                    }
                    break;
                case 7:
                    if (AppUntils.areYouSure("Ghi file")) {
                        CSVUntils.write("data\\sinhvien.csv", danhSachSinhVien.showDanhSach());
                    }
                    break;
            }
        } while (chose != 8);
    }

    public void SortView() {
        int number;
        do {
            System.out.println("----  Sap Xep Sinh Vien Theo Diem Trung Binh  ----");
            System.out.println("1. Diem Tb tang dan");
            System.out.println("2. Diem Tb giam dan");
            System.out.println("3. thoat");
            System.out.println("chon chuc nang: ");
            number = AppUntils.choseAgain(1, 3);
            switch (number) {
                case 1:
                    List<SinhVien> list = new ArrayList<>(danhSachSinhVien.showDanhSach());
                    Collections.sort(list, new Comparator<SinhVien>() {
                        @Override
                        public int compare(SinhVien o1, SinhVien o2) {
                            Double number = o1.getDiemTB() - o2.getDiemTB();
                            if (number > 0) {
                                return 1;
                            } else if (number < 0) {
                                return -1;
                            } else
                                return 0;
                        }
                    });
                    for (SinhVien sinhVien : list) {
                        System.out.println(SinhVien.SinhvienFomat(sinhVien));
                    }
                    break;
                case 2:
                    List<SinhVien> list2 = new ArrayList<>(danhSachSinhVien.showDanhSach());
                    Collections.sort(list2, new Comparator<SinhVien>() {
                        @Override
                        public int compare(SinhVien o1, SinhVien o2) {
                            Double number = o2.getDiemTB() - o1.getDiemTB();
                            if (number > 0) {
                                return 1;
                            } else if (number < 0) {
                                return -1;
                            } else
                                return 0;
                        }
                    });
                    for (SinhVien sinhVien : list2) {
                        System.out.println(SinhVien.SinhvienFomat(sinhVien));
                    }
                    break;
            }
        } while (number != 3);
    }

    public static void main(String[] args) {
        Programview programview = new Programview();
        programview.Orderview();
    }
}
