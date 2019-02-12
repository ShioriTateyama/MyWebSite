package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.FavoriteBeans;

public class FavoriteDAO {

	public FavoriteBeans insertFavorite(int userId,int itemDetailId) {
	    Connection conn=null;
		try {
			//connectDB
			conn=DBManager.getConnection();


			//insert文
			String sql ="INSERT INTO favorite(item_detail_id,user_id)VALUES(?,?)";
			//インサート実行
			 // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, itemDetailId);
	        pStmt.setInt(2, userId);



			pStmt.executeUpdate();


		 } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         // データベース切断
	         if (conn != null) {
	             try {
	                 conn.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
		return null;
	    }

	public boolean findSameFavoriteId(int userId,int itemDetailId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT favorite_id FROM favorite WHERE user_id = ? AND item_detail_id=?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, userId);
            pStmt.setInt(2,itemDetailId);

            ResultSet rs = pStmt.executeQuery();

            return rs.next();//nextmethodの戻り値は新しい現在の行が有効である場合はtrue、行がそれ以上存在しない場合はfalse


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        }
		return true;
    }

	public void deleteFavorite(int userId,int itemDetailId) {
	    Connection conn=null;
		try {
			//connectDB
			conn=DBManager.getConnection();


			//insert文
			String sql ="DELETE FROM favorite where item_detail_id =? AND user_id=?";
			//インサート実行
			 // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, itemDetailId);
	        pStmt.setInt(2, userId);



			pStmt.executeUpdate();


		 } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         // データベース切断
	         if (conn != null) {
	             try {
	                 conn.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	         }
	     }
	    }
/**
 * お気に入りしたものを表示する
 * @param userId
 * @return
 */
	public List<FavoriteBeans> getAllFavoriteData(int userId) {
        Connection conn = null;
        List<FavoriteBeans> favoriteList = new ArrayList<FavoriteBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql ="SELECT * FROM item_detail "+
                    "INNER JOIN item ON item_detail.item_id = item.item_id "+
                    "INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id "+
                    "INNER JOIN size ON size.size_id=item_detail.size_id "+
                    "LEFT OUTER JOIN favorite ON item_detail.item_detail_id = favorite.item_detail_id "+
                    "WHERE user_id =? ORDER BY file.item_detail_id DESC";


            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, userId);

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
            boolean favoriteFlg = false;


			while (rs.next()) {


				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						FavoriteBeans item = new FavoriteBeans(itemDetailId, itemName, price, categoryIdData,
								detail, stock,sizeName,fileNames, favoriteFlg);
						favoriteList.add(item);

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
		return favoriteList;

    }
}
