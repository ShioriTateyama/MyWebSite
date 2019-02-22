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
            String sql = "SELECT favorite_id FROM favorite WHERE user_id = ? AND item_detail_id = ?";

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
            String sql ="SELECT * FROM favorite where user_id = ? ";


            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, userId);

	        ResultSet rs = pStmt.executeQuery();




            while (rs.next()) {



				//①値を取得する
					int itemDetailId = rs.getInt("item_detail_id");
					int favoriteId = rs.getInt("favorite_id");


					FavoriteBeans item = new FavoriteBeans(favoriteId,userId,itemDetailId);
					favoriteList.add(item);

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
