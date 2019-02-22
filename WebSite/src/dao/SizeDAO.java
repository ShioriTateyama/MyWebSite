package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.SizeBeans;

public class SizeDAO {

	public SizeBeans selectSizeData(int itemDetailId) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM size inner join item_detail on size.size_id = item_detail.size_id  where item_detail_id =? ;";


            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, itemDetailId);
            ResultSet rs = pStmt.executeQuery();



            while (rs.next()) {
            	int sizeId = rs.getInt("size_id");
                String sizeName= rs.getString("size_name");

                SizeBeans size = new  SizeBeans(sizeId, sizeName);
        		return size;

            }

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
	public SizeBeans selectSizeNamebySizeId(int sizeId) {
        Connection conn = null;


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select * from size  where size_id=? ";
            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1,sizeId);
	        ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {



                String sizeName= rs.getString("size_name");

                SizeBeans size = new  SizeBeans(sizeId, sizeName);
        		return size;
			}

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
		return  null;



    }
}
