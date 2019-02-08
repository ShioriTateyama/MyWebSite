package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDetailBeans;


public class BuyDetailDAO {
/**
 * 購入詳細を登録
 * @param buyId
 * @param itemDetailId
 * @param purchaseQuantity
 */
	public void insertBuyDetailData(int buyId,int itemDetailId,int purchaseQuantity) {
	    Connection conn=null;
		try {
			//connectDB
			conn=DBManager.getConnection();


			//insert文
			String sql ="INSERT INTO buy_detail(buy_Id,item_detail_id,purchase_quantity)VALUES(?,?,?,)";
			//インサート実行
			 // SELECTを実行し、結果表を取得
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1, buyId);
	        pStmt.setInt(2, itemDetailId);
	        pStmt.setInt(3, purchaseQuantity);



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

	public List<BuyDetailBeans> selectBuyDetailData(int buyId) {
        Connection conn = null;
        List<BuyDetailBeans> buyDetailList = new ArrayList<BuyDetailBeans>();
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM buy_detail WHERE buy_id = ?;";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, buyId);


            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {//nextmethodの戻り値は新しい現在の行が有効である場合はtrue、行がそれ以上存在しない場合はfalse
            int buyDetailIdData = rs.getInt("buy_detail_id");
            int buyIdData= rs.getInt("buy_id");
            int itemDetailId= rs.getInt("item_detail_id");
            int purchaseQuantity= rs.getInt("purchase_quantity");

            BuyDetailBeans buyDetail = new  BuyDetailBeans(buyDetailIdData, buyIdData, itemDetailId, purchaseQuantity);

            buyDetailList.add(buyDetail);
            }

            return buyDetailList;


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
