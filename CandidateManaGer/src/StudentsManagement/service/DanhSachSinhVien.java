package StudentsManagement.service;

import StudentsManagement.AppUntils.AppUntils;
import StudentsManagement.AppUntils.CSVUntils;
import StudentsManagement.AppUntils.Regex;
import StudentsManagement.Model.SinhVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachSinhVien implements IDanhSachSinhVien {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String PATH = "data\\sinhvien.csv";

    public List<SinhVien> showDanhSach() {
        List<String> listSV = CSVUntils.read(PATH);
        List<SinhVien> sinhVienList = new ArrayList<>();
        for (String string : listSV) {
            sinhVienList.add(SinhVien.parseSinhVien(string));
        }
        return sinhVienList;
    }

    public void danhSachSinhVien() {
        int count = 0;
        for (SinhVien sinhVien : showDanhSach()) {
            count++;
            System.out.println(SinhVien.SinhvienFomat(sinhVien));
            if (count % 5 == 0) {
                System.out.println("Nhan 'y' de xem tiep");
                String next = SCANNER.nextLine();
                if (next.equals("y")) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    public void themSinhVien() {
        List<SinhVien> list = showDanhSach();
        list.add(createSV());
        System.out.println("them thanh cong");
        for (SinhVien sinhVien : list) {
            System.out.println(SinhVien.SinhvienFomat(sinhVien));
        }
        if (AppUntils.areYouSure("Cap nhat file")){
        CSVUntils.write(PATH, list);
        }
    }

    public SinhVien createSV() {
        boolean repeat;
        Long maSV = System.currentTimeMillis() / 1000;
        String tenSV;
        do {
            System.out.println("Nhap ten SV: ");
            tenSV = AppUntils.inputStringAgain("Ten sv");
        } while (!Regex.isNameValid(tenSV));
        int tuoi;
        boolean nhaplai = false;
        do {
            System.out.println("Nhap tuoi cua SV: ");
            tuoi = AppUntils.inputNumberAgain();
            if (tuoi < 17 || tuoi > 80) {
                System.out.println("tuoi phai lon hon  17 va nho hon 80");
                nhaplai = true;
            } else {
                nhaplai = false;
            }
        } while (nhaplai);
        String gioiTinh;
        do {
            System.out.println("Nhap gioi tinh cua SV(Nam, Nu, LGBT): ");
            gioiTinh = AppUntils.inputStringAgain("gioi tinh");
            if (gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nu") || gioiTinh.equalsIgnoreCase("LGBT")) {
                repeat = false;
            } else {
                repeat = true;
                System.out.println("Gioi tinh la Nam, Nu hoac LGBT");
            }
        } while (repeat);
        System.out.println("Nhap dia chi cua SV: ");
        String diachi = AppUntils.inputStringAgain("diachi");
        Double diemTB;
        do {
            System.out.println("Nhap diem TB cua SV: ");
            diemTB = AppUntils.retryParseDouble();
            if (diemTB > 10 || diemTB < 0) {
                nhaplai = true;
                System.out.println("Diem tu khoang 0-10");
            } else {
                nhaplai = false;
            }
        } while (nhaplai);
        return new SinhVien(maSV, tenSV, tuoi, gioiTinh, diachi, diemTB);
    }

    public void chinhSuaThongTIn() {
        boolean repeat = false;
        List<SinhVien> sinhVienList = new ArrayList<>(showDanhSach());
        do {
            System.out.println("Nhap ma SV: ");
            Long maSV = AppUntils.retryParseLong();
            for (SinhVien sinhVien : sinhVienList) {
                if (sinhVien.getMaSinhVien().equals(maSV)) {
                    SinhVien sinhVienMoi = createSV();
                    sinhVien.setDiaChi(sinhVienMoi.getDiaChi());
                    sinhVien.setDiemTB(sinhVienMoi.getDiemTB());
                    sinhVien.setGioiTinh(sinhVienMoi.getGioiTinh());
                    sinhVien.setHoTen(sinhVienMoi.getHoTen());
                    sinhVien.setTuoi(sinhVienMoi.getTuoi());
                    if (AppUntils.areYouSure("Cap nhat file")){
                        CSVUntils.write(PATH, sinhVienList);
                    }
                    System.out.println("them thanh cong");
                    System.out.println(SinhVien.SinhvienFomat(sinhVien));
                    repeat = false;
                    return;
                }
            }
            System.out.println("Khong tim dc sinh vien tren");
            System.out.println("Bam 'y' de nhap lai");
            String nhaplai = SCANNER.nextLine();
            if (nhaplai.equalsIgnoreCase("y")) {
                repeat = true;
            }
            if (nhaplai.isEmpty()) {
                repeat = false;
            }
        } while (repeat);
    }

    public void xoaSV() {
        boolean repeat = false;
        int count = 0;
        List<SinhVien> list = new ArrayList<>(showDanhSach());
        List<SinhVien> list1 = new ArrayList<>();
        do {
            System.out.println("Nhap ma SV: ");
            Long maSV = AppUntils.retryParseLong();
            for (SinhVien sinhVien : showDanhSach()) {
                if (sinhVien.getMaSinhVien().equals(maSV)) {
                    System.out.println("Nhap 'y' de xoa SV ra khoi danh sach");
                    String xoa = SCANNER.nextLine();
                    count++;
                    if (xoa.equalsIgnoreCase("y")) {
                        System.out.println("Da xoa ");
                        repeat = false;
                    } else {
                        list1.add(sinhVien);
                        repeat = AppUntils.areYouSure("Nhap lai ma SV");
                    }
                } else {
                    list1.add(sinhVien);
                }
            }
            if (count == 0) {
                System.out.println("Khong tim dc sinh vien tren");
            }
            if (AppUntils.areYouSure("Cap nhat file")){
                CSVUntils.write(PATH, list1);
            }
        } while (repeat);
    }
}
