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
			String sql ="INSERT INTO buy_detail(buy_id,item_detail_id,purchase_quantity)VALUES(?,?,?)";
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



	// TODO
	 public List<BuyDetailBeans> selectBuyDetailDatabyBuyId(int buyId) {

	        Connection conn = null;
	        ArrayList<BuyDetailBeans>itemList=new ArrayList<BuyDetailBeans>();

	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "select" +
	            		" *" +
	            		" from" +
	            		" buy_detail" +
	            		" where" +
	            		" buy_id = ?";;


	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1, buyId);
	            ResultSet rs = pStmt.executeQuery();



	            while (rs.next()) {
	            	BuyDetailBeans beans = new BuyDetailBeans(
	            			rs.getInt("buy_detail_id"),
	            			buyId,
	            			rs.getInt("item_detail_id"),
	            			rs.getInt("purchase_quantity")
            			);
	            	itemList.add(beans);
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
			return itemList;





	 }








//	public List<BuyDetailBeans> selectBuyDatabyBuyId(int buyId) {
//        Connection conn = null;
//        ArrayList<BuyDetailBeans>itemList=new ArrayList<BuyDetailBeans>();
//
//        try {
//            // データベースへ接続
//            conn = DBManager.getConnection();
//
//            // SELECT文を準備
//            String sql = "SELECT * FROM buy INNER JOIN buy_detail ON buy.buy_id = buy_detail.buy_id " +
//            		"                    INNER JOIN item_detail on buy_detail.item_detail_id=item_detail.item_detail_id " +
//            		"                    INNER JOIN item ON item_detail.item_id = item.item_id " +
//            		"                    INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id " +
//            		"                    INNER JOIN size ON size.size_id=item_detail.size_id " +
//            		"                    WHERE buy.buy_id = ? ORDER BY file.item_detail_id DESC";
//
//
//             // SELECTを実行し、結果表を取得
//            PreparedStatement pStmt = conn.prepareStatement(sql);
//            pStmt.setInt(1, buyId);
//
//
//            ResultSet rs = pStmt.executeQuery();
//            int buyDetailId=0;
//            int itemDetailId =-1;
//            String itemName= "";
//            int price = 0;
//            int categoryId=0;
//            String detail ="";
//            String sizeName="";
//            int sizeId=0;
//            int stock=0;
//            List<String> fileNames=null;
//
//
//
//            int purchaceQuantity=0;
//            Date createDate=null;
//            int totalPrice=0;
//
//            int allItemQuantity=0;
//
//
//            while (rs.next()) {
//
//
//            	//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
//            	if (itemDetailId != rs.getInt("item_detail_id")) {
//            		if (itemDetailId >= 0) {
//
//            		BuyDetailBeans item = new BuyDetailBeans(itemDetailId, itemName, price, categoryId,
//        					detail, stock,sizeName,sizeId,fileNames,purchaceQuantity,createDate,totalPrice,allItemQuantity,buyId,buyDetailId);
//
//        			itemList.add(item);
//
//
//            		}
//
//				//①値を取得する
//					itemDetailId = rs.getInt("item_id");
//					itemName = rs.getString("item_name");
//					price = rs.getInt("price");
//					categoryId = rs.getInt("category_id");
//					detail = rs.getString("detail");
//					sizeName = rs.getString("size_name");
//					sizeId=rs.getInt("size_id");
//					stock = rs.getInt("stock");
//					purchaceQuantity=rs.getInt("purchase_quantity");
//					createDate=rs.getDate("create_date");
//					totalPrice=rs.getInt("total_price");
//
//
//					allItemQuantity+=purchaceQuantity;
//					buyDetailId=rs.getInt("buy_detail_id");
//
//
//
//					fileNames = new ArrayList<>();
//
//            	}
//            	fileNames.add(rs.getString("file_name"));
//            }
//
//
//
//
//
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        } finally {
//            // データベース切断
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }
//        }
//		return itemList;
//
//
//	}


}
