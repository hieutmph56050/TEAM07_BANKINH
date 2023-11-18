/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;


import model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SanPhamResponsitory {

    private Connection con = new DBContext().getConnection();
    private ArrayList<SanPham> arrSp = null;

    public ArrayList<SanPham> getArrSp() {
        return arrSp;
    }

    public ArrayList<SanPham> getAllSP() {
        arrSp = new ArrayList<>();
        try {
            String query = "select sanpham.ma_san_pham, sanpham.ten, sanpham.mo_ta, danhmuc.ten_danh_muc,\n"
                    + "phanloai.phan_loai, chatlieu.chat_lieu, thuonghieu.ten_thuong_hieu, spct.gia,\n"
                    + "spct.so_luong, mausac.ten_mau, hinhdang.kieu_dang, spct.trang_thai\n"
                    + "from \n"
                    + "sanpham inner join danhmuc on sanpham.danh_muc_id = danhmuc.id\n"
                    + "inner join phanloai on sanpham.phan_loai_id = phanloai.id\n"
                    + "inner join chatlieu on sanpham.chat_lieu_id = chatlieu.id\n"
                    + "inner join thuonghieu on sanpham.thuong_hieu_id = thuonghieu.id\n"
                    + "inner join spct on spct.san_pham_id = sanpham.id\n"
                    + "inner join mausac on spct.mau_sac_id = mausac.id\n"
                    + "inner join hinhdang on spct.hinh_dang_id = hinhdang.id";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ma = rs.getString(1);
                String ten = rs.getString(2);
                String moTa = rs.getString(3);
                String dm = rs.getString(4);
                String pl = rs.getString("phan_loai");
                String cl = rs.getString("chat_lieu");
                String th = rs.getString("ten_thuong_hieu");
                int gia = rs.getInt("so_luong");
                int sl = rs.getInt(9);
                String mau = rs.getString(10);
                String hd = rs.getString(11);
                int tt = rs.getInt(12);
                SanPham sp = new SanPham(ma, ten, moTa, dm, pl, cl, th, gia, sl, tt, mau, hd);
                arrSp.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrSp;
    }

    public void themSP(SanPham sp) {
        try {
            String query = "insert into SanPham (ma_san_pham, ten, mo_ta, danh_muc_id, thuong_hieu_id, phan_loai_id, chat_lieu_id)"
                    + " values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getMoTa());
            ps.setInt(4, sp.getDmID());
            ps.setInt(5, sp.getThID());
            ps.setInt(6, sp.getPlID());
            ps.setInt(7, sp.getClID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getId(SanPham sp) {
        int n = 0;
        try {
            String query = "Select ID FROM SanPham where ma_san_pham = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sp.getMa());
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    
    public boolean check(SanPham sp){
         try {
            String query = "Select ID FROM SanPham where ma_san_pham = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sp.getMa());
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return true;
    }
    public void themCTSP(SanPham sp) {
        try {
            String query = "INSERT INTO SPCT (san_pham_id, mau_sac_id, hinh_dang_id, gia, so_luong, trang_thai) "
                    + "values(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, getId(sp));
            ps.setInt(2, sp.getMauSacId());
            ps.setInt(3, sp.getHinhDangId());
            ps.setInt(4, sp.getGia());
            ps.setInt(5, sp.getSoLuong());
            ps.setInt(6, sp.getTrangThai());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public void suaSp(SanPham sp){
        try {
            String query = "UPDATE SanPham SET ten = ?, mo_ta = ?, danh_muc_id = ?, thuong_hieu_id = ?, phan_loai_id = ?, chat_lieu_id = ? WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getMoTa());
            ps.setInt(3, sp.getDmID());
            ps.setInt(4, sp.getThID());
            ps.setInt(5, sp.getPlID());
            ps.setInt(6, sp.getClID());
            ps.setInt(7, getId(sp));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public void suaCTSP(SanPham sp, int id){
        try {
            String query = "UPDATE SPCT SET gia = ?"
                    + "so_luong = ?"
                    + "trang_thai = ?"
                    + "mau_sac_id = ?"
                    + "hinh_dang_id = ?"
                    
                    +"WHERE ID = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,sp.getGia());
            ps.setInt(2, sp.getSoLuong());
            ps.setInt(3, sp.getTrangThai());
            ps.setInt(4, sp.getMauSacId());
            ps.setInt(5, sp.getHinhDangId());
            ps.setInt(6, id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> getMau() {
        ArrayList<String> arrMau = new ArrayList<>();
        try {
            String query = "Select * from mausac";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrMau.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrMau;
    }

    public ArrayList<String> getDanhMuc() {
        ArrayList<String> arrDanhMuc = new ArrayList<>();
        try {
            String query = "Select * from DanhMuc";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrDanhMuc.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrDanhMuc;
    }

    public ArrayList<String> getThuongHieu() {
        ArrayList<String> arrTH = new ArrayList<>();
        try {
            String query = "Select * from ThuongHieu";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrTH.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrTH;
    }

    public ArrayList<String> getHinhDang() {
        ArrayList<String> arrHD = new ArrayList<>();
        try {
            String query = "Select * from HinhDang";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrHD.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrHD;
    }

    public ArrayList<String> getChatLieu() {
        ArrayList<String> arrCL = new ArrayList<>();
        try {
            String query = "Select * from chatlieu";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrCL.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrCL;
    }

    public ArrayList<String> getAnh() {
        ArrayList<String> arrAnh = new ArrayList<>();
        try {
            String query = "Select * from Anh";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrAnh.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrAnh;
    }

    public ArrayList<String> getPhanLoai() {
        ArrayList<String> arrPL = new ArrayList<>();
        try {
            String query = "Select * from PhanLoai";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                String ten = rs.getString(2);
                arrPL.add(ten);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arrPL;
    }
}
