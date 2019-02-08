package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyBeans;


public class BuyDAO {
/**
 * 購入情報を登録する
 * @param userId
 * @param totalPrice
 * @param cteateDate
 */
	public void insertBuyData(String userId,int totalPrice,String cteateDate) {
	    Connection conn=null;
		try {
			//connectDB
			conn=DBManager.getConnection();


			//insert文
			String sql ="INSERT INTO buy(user_Id,total_price,create_date)VALUES(?,?,now())";
			//インサート実行
			 // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, userId);
	        pStmt.setInt(2, totalPrice);



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
 * 購入データをすべて得る
 * @param userId
 * @return
 */
	public List<BuyBeans> getAllBuyData(int userId) {
        Connection conn = null;
        List<BuyBeans> buyList = new ArrayList<BuyBeans>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文
            String sql = "SELECT * FROM buy WHERE user_id =?";

            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, userId);

	        ResultSet rs = pStmt.executeQuery();
            // 結果表に格納されたレコードの内容を
            // Userインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int buyId = rs.getInt("buy_id");
                int userIdData = rs.getInt("user_Id");
                int totalPrice = rs.getInt("name");
                Date create_date = rs.getDate("create_date");

                BuyBeans buy = new BuyBeans(buyId, userIdData, totalPrice, create_date);

                buyList.add(buy);
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
		return buyList;

    }
	public BuyBeans selectBuyData(int buyId) {
        Connection conn = null;
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM buy WHERE buy_id = ?;";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, buyId);


            ResultSet rs = pStmt.executeQuery();

            rs.next();//nextmethodの戻り値は新しい現在の行が有効である場合はtrue、行がそれ以上存在しない場合はfalse
            int buyIdData = rs.getInt("buy_id");
            int userIdData = rs.getInt("user_Id");
            int totalPrice = rs.getInt("name");
            Date create_date = rs.getDate("create_date");

            BuyBeans buy = new BuyBeans(buyIdData, userIdData, totalPrice, create_date);

            return buy;


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
}
