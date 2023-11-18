/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ledin
 */
public class NhanVien {

    private Integer id;
    private String taiKhoan;
    private String ten;
    private String matKhau;
    private String diaChi;
    private String sdt;
    private String email;
    private Boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(Integer id, String taiKhoan, String ten, String matKhau, String diaChi, String sdt, String email, Boolean vaiTro) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.ten = ten;
        this.matKhau = matKhau;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.vaiTro = vaiTro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

}
