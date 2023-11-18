package responsitory;

import java.beans.Statement;
import java.sql.*;
import java.util.ArrayList;
import model.ChatLieu;

public class ChatLieuResponsitory extends DBContext {

    private ArrayList<ChatLieu> list;
    private Connection con = new DBContext().getConnection();
    private PreparedStatement pstm = null;

    public ChatLieuResponsitory() {
        this.list = new ArrayList<>();
    }

    public ArrayList<ChatLieu> getList() {
        this.list.clear();
        try {
            ResultSet rs = con.createStatement().executeQuery("select *from ChatLieu");
            while (rs.next()) {
                this.list.add(new ChatLieu(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    ArrayList<ChatLieu> data = new ArrayList<>();

    public ArrayList<ChatLieu> findById(Integer id) {
        this.data.clear();
        try {
            pstm = con.prepareStatement("SELECT * FROM ChatLieu WHERE ID = ?");
            pstm.setObject(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                this.data.add(new ChatLieu(rs.getInt(1), rs.getString(2)));
            }

            return data;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean del(String id) {
        try {
            pstm = con.prepareStatement("DELETE FROM ChatLieu WHERE ID = ?");
            pstm.setObject(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean insert(ChatLieu nv) {
        try {
          pstm = con.prepareStatement("UPDATE [dbo].[ThuongHieu] SET [ten_thuong_hieu] = ? WHERE ID = ? ");

            pstm.setObject(1, nv.getChatLieu());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    public Boolean chaneg(ChatLieu nv) {
        try {
            pstm = con.prepareStatement(" UPDATE [dbo].[ChatLieu] SET [chat_lieu] = ?WHERE ID = ?");
                                        
                                           
                                         
                                        
            pstm.setObject(1, nv.getChatLieu());
            pstm.setObject(2, nv.getIdInteger());

            return pstm.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }
}
