package StudentsManagement.service;

import StudentsManagement.Model.SinhVien;

import java.util.List;

public interface IDanhSachSinhVien {
    List<SinhVien> showDanhSach();
    void danhSachSinhVien();
    void themSinhVien();
    SinhVien createSV();
    void chinhSuaThongTIn();
    void xoaSV();
}
