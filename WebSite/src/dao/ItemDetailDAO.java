package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemDetailBeans;

public class ItemDetailDAO {
/**
 * カテゴリー別に表示
 * @param categoryId
 * @return
 */
	public List<ItemDetailBeans> getItemByCategory(int categoryId) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM item_detail"+
            "INNER JOIN item ON item_detail.item_id = item_detail.item_id"+
            "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id"+
            "INNER JOIN size ON size.size_id=item_detail.size_id"+
            "WHERE category_id =? ORDER BY item_detail_id";

            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, categoryId);

	        ResultSet rs = pStmt.executeQuery();

	        //item_detail_idは絶対に１からはじまるので、item_detail_idが正の時にインスタンスをつくるため
	        int itemDetailId =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int stock=0;
            List<String> fileNames=null;

			while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,fileNames);
						ItemDetailList.add(item);
					}
				//①値を取得する
					itemDetailId = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					stock = rs.getInt("stock");
					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
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
		return ItemDetailList;

    }
/**
 * カラーで
 * @param colorId
 * @return
 */
	public List<ItemDetailBeans> getItemBySizeId(int categoryId,int colorId) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM item_detail"+
            "INNER JOIN item ON item_detail.item_id = item_detail.item_id"+
            "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id"+
            "INNER JOIN size ON size.size_id=item_detail.size_id"+
            "WHERE color_id =? AND category_id=? ORDER BY item_detail_id";

            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, colorId);
	        pStmt.setInt(1, categoryId);

	        ResultSet rs = pStmt.executeQuery();

	        //item_detail_idは絶対に１からはじまるので、item_detail_idが正の時にインスタンスをつくるため
	        int itemDetailId =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int stock=0;
            List<String> fileNames=null;

			while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,fileNames);
						ItemDetailList.add(item);
					}
				//①値を取得する
					itemDetailId = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					stock = rs.getInt("stock");
					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
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
		return ItemDetailList;

    }

	public List<ItemDetailBeans> getItemBySearch(String name) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM item_detail"+
            "INNER JOIN item ON item_detail.item_id = item_detail.item_id"+
            "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id"+
            "INNER JOIN size ON size.size_id=item_detail.size_id"+
            "WHERE name LIKE '%"+name+"%' ORDER BY item_detail_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

	        //item_detail_idは絶対に１からはじまるので、item_detail_idが正の時にインスタンスをつくるため
	        int itemDetailId =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int stock=0;
            List<String> fileNames=null;

			while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,fileNames);
						ItemDetailList.add(item);
					}
				//①値を取得する
					itemDetailId = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					stock = rs.getInt("stock");
					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
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
		return ItemDetailList;

    }

}
