package StudentsManagement.Model;

import java.time.Instant;

public class SinhVien {
    Long maSinhVien;
    String hoTen;
    int tuoi;
    String gioiTinh;
    String diaChi;
    Double diemTB;

    SinhVien() {

    }

    public SinhVien(Long maSinhVien, String hoTen, int tuoi, String gioiTinh, String diaChi, Double diemTB) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.diemTB = diemTB;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public Long getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(Long maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(Double diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", maSinhVien, hoTen, tuoi, gioiTinh, diaChi, diemTB);
    }
    public static String SinhvienFomat(SinhVien sinhVien ) {
        return String.format("%24s,%24s,%12s,%12s,%24s,%12s",
                sinhVien.getMaSinhVien(), sinhVien.getHoTen(), sinhVien.getTuoi(), sinhVien.getGioiTinh(), sinhVien.getDiaChi(), sinhVien.getDiemTB());
    }

    public static SinhVien parseSinhVien(String string) {
        String[] strings = string.split(",");
        Long maSV = Long.parseLong(strings[0].trim());
        String hoTen = strings[1].trim();
        int tuoi = Integer.parseInt(strings[2].trim());
        String gioiTinh = strings[3].trim();
        String diachi = strings[4].trim();
        Double diemTB = Double.valueOf(strings[5].trim());
        return new SinhVien(maSV, hoTen, tuoi, gioiTinh, diachi, diemTB);
    }
}
