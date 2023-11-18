/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.sql.*;
import java.util.ArrayList;
import model.ThuongHieu;

/**
 *
 * @author dat07
 */
public class ThuongHieuResponsitory {

    private ArrayList<ThuongHieu> list = new ArrayList<>();
    private Connection con = new DBContext().getConnection();
    private ResultSet rs = null;
    private PreparedStatement pstm = null;

    public ArrayList<ThuongHieu> getList() {
        this.list.clear();
        try {
            rs = con.createStatement().executeQuery("SELECT * FROM ThuongHieu");
            while (rs.next()) {
                this.list.add(new ThuongHieu(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    ArrayList<ThuongHieu> data = new ArrayList<>();

    public ArrayList<ThuongHieu> findById(Integer id) {
        this.data.clear();
        try {
            pstm = con.prepareStatement("SELECT * FROM ThuongHieu WHERE ID = ?");
            pstm.setObject(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                this.data.add(new ThuongHieu(rs.getInt(1), rs.getString(2)));
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean del(String id) {
        try {
            pstm = con.prepareStatement("DELETE FROM ThuongHieu WHERE ID = ?");
            pstm.setObject(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean insert(ThuongHieu th) {
        try {
            pstm = con.prepareStatement("""
                                        INSERT INTO [dbo].[ThuongHieu]
                                                   ([ten_thuong_hieu])
                                             VALUES(?)
                                        """);

            pstm.setObject(1, th.getTenth());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean chaneg(ThuongHieu th) {
        try {
            pstm = con.prepareStatement("""
                                        UPDATE [dbo].[ThuongHieu]
                                           SET [ten_thuong_hieu] = ?
                                         WHERE ID = ?
                                        """);
            pstm.setObject(1, th.getTenth());
            pstm.setObject(2, th.getId());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
