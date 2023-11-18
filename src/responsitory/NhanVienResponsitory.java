/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ledin
 */
public class NhanVienResponsitory {

    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = DBContext.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("ID"));
                nv.setTaiKhoan(rs.getString("tai_khoan"));
                nv.setTen(rs.getString("ten"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setSdt(rs.getString("SDT"));
                nv.setEmail(rs.getString("email"));
                nv.setMatKhau(rs.getString("mat_khau"));
                nv.setVaiTro(rs.getBoolean("vai_tro"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
