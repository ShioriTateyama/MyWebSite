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
            String sql = "select * from item_detail inner join item ON item_detail.item_id=item.item_id where category_id=? ";
            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, categoryId);
	        ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {



				//①値を取得する
					int itemDetailId = rs.getInt("item_detail_id");
					String itemName = rs.getString("item_name");
					int price = rs.getInt("price");
					String detail = rs.getString("detail");

					int stock = rs.getInt("stock");
					int sizeId= rs.getInt("size_id");
					int colorId=rs.getInt("color_id");

					ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryId,
							detail, stock,sizeId,colorId);
					ItemDetailList.add(item);

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
	public List<ItemDetailBeans> getItemByColorId(int categoryId,int colorId) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM item_detail "+
            "INNER JOIN item ON item_detail.item_id = item.item_id "+
            "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id "+
            "INNER JOIN size ON size.size_id=item_detail.size_id "+
            "WHERE color_id =? AND category_id=? ORDER BY file.item_detail_id ";

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
            int sizeId=0;
            int stock=0;
            List<String> fileNames=null;

			while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,sizeId,fileNames);
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
 * 検索する
 * @param name
 * @return
 */
	public List<ItemDetailBeans> getItemBySearch(String name) {
        Connection conn = null;
        List<ItemDetailBeans> ItemDetailList = new ArrayList<ItemDetailBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM item_detail "+
                    "INNER JOIN item ON item_detail.item_id = item.item_id "+
                    "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id "+
                    "INNER JOIN size ON size.size_id=item_detail.size_id "+
                    "LEFT OUTER JOIN favorite ON item_detail.item_detail_id = favorite.item_detail_id "+
                    "WHERE item_name LIKE '%"+name+"%' ORDER BY file.item_detail_id DESC";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            int itemDetailId =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int stock=0;
            List<String> fileNames=null;
            boolean favoriteFlg = false;


			while (rs.next()) {


				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,fileNames, favoriteFlg);
						ItemDetailList.add(item);

						favoriteFlg = false;
					}
				//①値を取得する
					itemDetailId = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					stock = rs.getInt("stock");

					if(rs.getInt("favorite_id") != 0) {
						favoriteFlg = true;
					}


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
	public ItemDetailBeans selectItemDetailDatabyItemDetailId(int itemDetailId) {
        Connection conn = null;


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select * from item_detail inner join item ON item_detail.item_id=item.item_id where category_id=? ";
            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1,itemDetailId);
	        ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {



				//①値を取得する

					String itemName = rs.getString("item_name");
					int price = rs.getInt("price");
					String detail = rs.getString("detail");
					int categoryId= rs.getInt("category_id");
					int stock = rs.getInt("stock");
					int sizeId= rs.getInt("size_id");
					int colorId=rs.getInt("color_id");


					ItemDetailBeans item = new ItemDetailBeans(itemDetailId, itemName, price, categoryId,
							detail, stock,sizeId,colorId);

					return item;
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

	public ItemDetailBeans selectItemDetailIdbyItemDetailIdAndSizeId(int itemDetailId,int sizeId,int quantity) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select t1. * , item. *,size_name, favorite. * , file.* from item_detail t1 " +
            		"            		            		inner join item_detail t2 on " +
            		"            		            			t1.item_id = t2.item_id " +
            		"            		            			and t1.color_id = t2.color_id " +
            		"            		            		INNER JOIN item ON t1.item_id = item.item_id " +
            		"            		INNER JOIN size ON size.size_id = t1.size_id " +

            		"            		  JOIN file ON t2.item_detail_id = file.item_detail_id " +
            		"            		LEFT OUTER JOIN favorite ON t1.item_detail_id = favorite.item_detail_id " +
            		"            		            	where t2.item_detail_id = ?  " +
            		"            		            		and t1.size_id = ? ";


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, itemDetailId);
            pStmt.setInt(2, sizeId);


            ResultSet rs = pStmt.executeQuery();

            int itemDetailIdData =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int sizeIdData=0;
            int stock=0;
            List<String> fileNames=null;
            boolean favoriteFlg = false;
            while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailIdData != rs.getInt("item_detail_id")) {
				//①値を取得する
					itemDetailIdData = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					sizeIdData=rs.getInt("size_id");
					stock = rs.getInt("stock");

					if(rs.getInt("favorite_id") != 0) {
						favoriteFlg = true;
					}


					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
			}
			ItemDetailBeans item = new ItemDetailBeans(itemDetailIdData, itemName, price, categoryIdData,
					detail, stock,sizeName,sizeIdData,fileNames, favoriteFlg,quantity);
			return item;

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
	public ItemDetailBeans selectItemDetailDatabyItemDetailId(int itemDetailId,int quantity) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM item_detail "+
                    "INNER JOIN item ON item_detail.item_id = item.item_id "+
                    "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id "+
                    "INNER JOIN size ON size.size_id=item_detail.size_id "+

                    "LEFT OUTER JOIN favorite ON item_detail.item_detail_id = favorite.item_detail_id "+
                    "WHERE item_detail.item_detail_id =? ORDER BY file.item_detail_id DESC";


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, itemDetailId);


            ResultSet rs = pStmt.executeQuery();

            int itemDetailIdData =-1;
            String itemName= "";
            int price = 0;
            int categoryIdData=0;
            String detail ="";
            String sizeName="";
            int sizeId=0;
            int stock=0;
            List<String> fileNames=null;
            boolean favoriteFlg = false;

            while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailIdData != rs.getInt("item_detail_id")) {
				//①値を取得する
					itemDetailIdData = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("category_id");
					detail = rs.getString("detail");
					sizeName = rs.getString("size_name");
					sizeId=rs.getInt("size_id");
					stock = rs.getInt("stock");

					if(rs.getInt("favorite_id") != 0) {
						favoriteFlg = true;
					}


					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
			}
			ItemDetailBeans item = new ItemDetailBeans(itemDetailIdData, itemName, price, categoryIdData,
					detail, stock,sizeName,sizeId,fileNames, favoriteFlg,quantity);
			return item;

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
