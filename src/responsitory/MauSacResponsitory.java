/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MauSac;

/**
 *
 * @author ledin
 */
public class MauSacResponsitory {

    public void insert(MauSac entity) {
        String sql = "INSERT INTO [dbo].[MauSac]\n" + "([ten_mau])\n" +  VALUES(?)";


        DBContext.update(sql, entity.getTen());
    }

    public void update(MauSac entity) {
        String sql = """
                        UPDATE [dbo].[MauSac]
                           SET [ten_mau] = ?
                         WHERE ID = ?
                        """;

        DBContext.update(sql,
                entity.getTen(),
                entity.getId());
    }

    public void delete(Integer id) {
        String delete_sql = """
                        DELETE FROM [dbo].[MauSac]
                              WHERE ID = ?
                        """;

        DBContext.update(delete_sql, id);
    }

    public MauSac selectById(Integer id) {
        String selectById = """
                        select * from MauSac where ID = ?
                        """;
        List<MauSac> list = this.selectBySql(selectById, id);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    protected List<MauSac> selectBySql(String sql, Object... args) {
        List<MauSac> list = new ArrayList<>();
        try {
            ResultSet rs = DBContext.query(sql, args);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt("ID"));
                ms.setTen(rs.getString("ten_mau"));
                list.add(ms);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MauSac> selectAll() {
        String selectAll = """
                       select * from MauSac
                       """;
        return this.selectBySql(selectAll);
    }

    public List<MauSac> selectByKeyWord(String keyWord) {
        String selectByKeyWord = """
                        SELECT * 
                        FROM MauSac
                        WHERE ten_mau LIKE ?
                          """;
        return this.selectBySql(selectByKeyWord, "%" + keyWord + "%%");
    }

    public List<MauSac> searchKeyWord(String keyWord, int pages, int limit) {
        String sql = """
                     SELECT * 
                     FROM 
                     (
                         SELECT * 
                            FROM MauSac
                            WHERE ten_mau LIKE ?
                     ) AS FilteredResults
                     ORDER BY ID
                     OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;
                     """;
        return this.selectBySql(sql,
                "%" + keyWord + "%%",
                (pages - 1) * limit, limit);
    }
}
