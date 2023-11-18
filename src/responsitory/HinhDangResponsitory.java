/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;
import model.HinhDang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author GIGABYTE
 */
public class HinhDangResponsitory {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
    
    public List<HinhDang> getAll(){
        sql = "select ID,kieu_dang from HinhDang";
        List<HinhDang> list = new ArrayList<>();
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                HinhDang hd = new HinhDang(rs.getInt(1), rs.getString(2));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public int addHinhDang(HinhDang hd){
        sql = "insert into HinhDang values (?)";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getLoai_hinh_dang());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int deleteHinhDang(int id){
        sql = "delete from HinhDang where id=?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int updateSinhVien(HinhDang hd, int id){
        sql = "update HinhDang set name = ? where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hd.getLoai_hinh_dang());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
