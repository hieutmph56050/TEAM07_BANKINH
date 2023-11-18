package model;

import responsitory.SanPhamResponsitory;

public class SanPham {

    private SanPhamResponsitory dao = new SanPhamResponsitory();
    private int id, dmID, plID, clID, thID;
    private String ma, ten, moTa, ngayTao, ngaySua;
    private String danhMuc, phanLoai, chatLieu, thuongHieu;
    private int gia, soLuong, trangThai, mauSacId, hinhDangId;
    private String  mauSac, hinhDang;

    public SanPham(String ma, String ten, String moTa, String danhMuc, String phanLoai, String chatLieu, String thuongHieu, int gia, int soLuong, int trangThai, String mauSac, String hinhDang) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.danhMuc = danhMuc;
        this.phanLoai = phanLoai;
        this.chatLieu = chatLieu;
        this.thuongHieu = thuongHieu;
        this.gia = gia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.mauSac = mauSac;
        this.hinhDang = hinhDang;
    }

    public SanPham(int dmID, int plID, int clID, int thID, String ma, String ten, String moTa, int gia, int soLuong, int trangThai, int mauSacId, int hinhDangId) {
        this.dmID = dmID;
        this.plID = plID;
        this.clID = clID;
        this.thID = thID;
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
        this.mauSacId = mauSacId;
        this.hinhDangId = hinhDangId;
    }
    
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public SanPhamResponsitory getDao() {
        return dao;
    }

    public int getId() {
        return id;
    }

    public int getDmID() {
        return dmID;
    }

    public int getPlID() {
        return plID;
    }

    public int getClID() {
        return clID;
    }

    public int getThID() {
        return thID;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGia() {
        return gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getMauSacId() {
        return mauSacId;
    }

    public int getHinhDangId() {
        return hinhDangId;
    }

    public String getMauSac() {
        return mauSac;
    }

    public String getHinhDang() {
        return hinhDang;
    }
    
    
}
