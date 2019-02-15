package dao;

import java.sql.Connection;
import java.sql.Date;
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
			String sql ="INSERT INTO buy_detail(buy_Id,item_detail_id,purchase_quantity)VALUES(?,?,?)";
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
	public List<BuyDetailBeans> selectBuylDatabyBuyId(int buyId) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM buy INNER JOIN buy_detail ON buy.buy_id = buy_detail.buy_id " +
            		"                    INNER JOIN item_detail on buy_detail.item_detail_id=item_detail.item_detail_id " +
            		"                    INNER JOIN item ON item_detail.item_id = item.item_id " +
            		"                    INNER JOIN file ON item_detail.item_detail_id =file.item_detail_id " +
            		"                    INNER JOIN size ON size.size_id=item_detail.size_id " +
            		"                    WHERE buy.buy_id = ? ORDER BY file.item_detail_id DESC;";


             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, buyId);


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


            int purchaceQuantity=0;
            Date createDate=null;
            int totalPrice=0;

            int allItemQuantity=0;

            while (rs.next()) {
				//②item_detail_idが次の数に切り替わったら、インスタンスを作成する
				if (itemDetailIdData != rs.getInt("item_detailId")) {
				//①値を取得する
					itemDetailIdData = rs.getInt("item_detailId");
					itemName = rs.getString("item_name");
					price = rs.getInt("price");
					categoryIdData = rs.getInt("categoryId");
					detail = rs.getString("detail");
					sizeName = rs.getString("sizeName");
					sizeId=rs.getInt("sizeId");
					stock = rs.getInt("stock");
					purchaceQuantity=rs.getInt("purchaceQuantity");
					createDate=rs.getDate("createDate");
					totalPrice=rs.getInt("totalPrice");

					allItemQuantity=rs.getInt("allItemQuantity");


					allItemQuantity+=purchaceQuantity;

					fileNames = new ArrayList<>();
				}
				fileNames.add(rs.getString("file_name"));
			}
			BuyDetailBeans item = new BuyDetailBeans(itemDetailIdData, itemName, price, categoryIdData,
					detail, stock,sizeName,sizeId,fileNames,purchaceQuantity,createDate,totalPrice,allItemQuantity);
			ArrayList<BuyDetailBeans>itemList=new ArrayList<BuyDetailBeans>();
			itemList.add(item);
			return itemList;

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
