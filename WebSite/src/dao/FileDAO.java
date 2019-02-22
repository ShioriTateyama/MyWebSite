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
            String sql = "select t3.* " +
            		"	from item_detail t1 " +
            		"		inner join item_detail t2 " +
            		"			on t2.item_id = t1.item_id " +
            		"			and t2.color_id = t1.color_id " +
            		"			and t2.size_id = 20 " +
            		"		inner join file t3 " +
            		"			on t3.item_detail_id = t2.item_detail_id " +
            		"	where t1.item_detail_id = ? ";




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
