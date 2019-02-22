package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.FileBeans;

public class FileDAO {
	public FileBeans getFile(int itemDetailId) {
        Connection conn = null;


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "select * from file where item_detail_id=? ";




            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, itemDetailId);
            ResultSet rs = pStmt.executeQuery();

            List<String> fileNames=null;

            fileNames = new ArrayList<>();



			while (rs.next()) {



			fileNames.add(rs.getString("file_name"));
			}

			FileBeans beans = new FileBeans(itemDetailId,fileNames);
			return beans;



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
	public FileBeans getBathrobeFile(int itemDetailId) {
        Connection conn = null;


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "select file.* from file INNER JOIN item_detail ON file.item_detail_id= item_detail.item_detail_id"+
            			"inner join item on item.item_id= item_detail.item_id"+
            			"where item_detail_id=? and size_id= 20";




            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, itemDetailId);

            ResultSet rs = pStmt.executeQuery();

            List<String> fileNames=null;

            fileNames = new ArrayList<>();



			while (rs.next()) {



			fileNames.add(rs.getString("file_name"));
			}

			FileBeans beans = new FileBeans(itemDetailId,fileNames);
			return beans;



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
