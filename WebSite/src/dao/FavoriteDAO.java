package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.FavoriteBeans;

public class FavoriteDAO {

	public void insertFavorite(int userId,int itemDetailId,Date cteateDate) {
	    Connection conn=null;
		try {
			//connectDB
			conn=DBManager.getConnection();


			//insert文
			String sql ="INSERT INTO favorite(item_detail_id,create_date)VALUES(?,,now() WHERE user_id=?)";
			//インサート実行
			 // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, itemDetailId);
	        pStmt.setDate(2, cteateDate);
	        pStmt.setInt(3, userId);



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
            String sql = "SELECT * FROM favorite"+
            "INNER JOIN item_detail ON favorite.item_detail_id = item_detail.item_detail_id"+
            "INNER JOIN file ON favorite.item_detail_id =file.item_detail_id"+
            "INNER JOIN item ON item_detail.item_id = item.item_id"+
            "INNER JOIN size ON item_detail.size_id = size.size_id"+
            "WHERE user_id =? ORDER BY item_detail_id";

            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, userId);

	        ResultSet rs = pStmt.executeQuery();

	        //item_detail_idは絶対に１からはじまるので、item_detail_idが正の時にインスタンスをつくるため
	        int itemDetailId =-1;
            String itemName= "";
            int price = 0;
            String detail ="";
            String sizeName="";
            int stock=0;
            List<String> fileNames=null;

			while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailId != rs.getInt("item_detail_id")) {
					if (itemDetailId >= 0) {
						//item_detail_idごとにインスタンス作成
						FavoriteBeans favorite = new FavoriteBeans(itemDetailId, itemName, price, detail, sizeName,stock,
								fileNames);
						favoriteList.add(favorite);
					}
				//①値を取得する
					itemDetailId = rs.getInt("item_detail_id");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					detail = rs.getString("detail");
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
		return favoriteList;

    }
}
