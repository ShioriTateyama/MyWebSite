package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemBeans;
import beans.ItemDetailBeans;

public class ItemDAO {
	public ItemBeans getItem(int detailId) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "select * from item where item_id = ?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, detailId);
	        ResultSet rs = pStmt.executeQuery();


			if (!rs.next()) {
				return null;
			}

			ItemBeans ib = new ItemBeans(
					rs.getInt("item_id"),
					rs.getString("item_name"),
					rs.getInt("price"),
					rs.getInt("category_id"),
					rs.getString("detail")
				);
			return ib;

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
		return null;

    }

}
