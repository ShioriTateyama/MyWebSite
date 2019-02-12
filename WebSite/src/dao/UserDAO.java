package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.DatatypeConverter;

import base.DBManager;
import beans.UserBeans;

/**
 * ログインIDとパスワードに紐づくユーザ情報を返す
 * @author shiori
 *
 */
public class UserDAO {

	 public UserBeans findByLoginInfo(String loginId, String password) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setString(1, loginId);
	            pStmt.setString(2, password);
	            ResultSet rs = pStmt.executeQuery();

	             // 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
	            if (!rs.next()) {
	                return null;
	            }
	            int userIdData = rs.getInt("user_id");
	            String loginIdData = rs.getString("login_Id");
	            String nameData = rs.getString("name");
	            String addressData = rs.getString("address");
	            String passwordData = rs.getString("password");
	            Date createDateData = rs.getDate("create_date");
	            Date updateDateData = rs.getDate("update_date");


	            return new UserBeans(userIdData,loginIdData,nameData,addressData,passwordData,createDateData, updateDateData);

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
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
	    }
/**
 * idからユーザー情報を参照する
 * @param id
 * @return
 */
	 public UserBeans referUser(int userId) {
	        Connection conn = null;
	        try {
	            // データベースへ接続
	            conn = DBManager.getConnection();

	            // SELECT文を準備
	            String sql = "SELECT * FROM user WHERE user_id = ?;";

	             // SELECTを実行し、結果表を取得
	            PreparedStatement pStmt = conn.prepareStatement(sql);
	            pStmt.setInt(1, userId);


	            ResultSet rs = pStmt.executeQuery();

	            rs.next();//nextmethodの戻り値は新しい現在の行が有効である場合はtrue、行がそれ以上存在しない場合はfalse
	            int userIdData = rs.getInt("user_id");
	            String loginIdData = rs.getString("login_Id");
	            String nameData = rs.getString("name");
	            String addressData = rs.getString("address");
	            String password = rs.getString("password");
	            Date createDateData = rs.getDate("create_date");
	            Date updateDateData = rs.getDate("update_date");

	            UserBeans user = new UserBeans(userIdData, loginIdData, nameData, addressData, password, createDateData,updateDateData);


	            return user;


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

	 /**
	  * ユーザー新規登録
	  * @param loginId
	  * @param name
	  * @param address
	  * @param password
	  * @param cteateDate
	  * @param updateDate
	  */
	 public void resisterUser(String loginId,String name,String address,  String password) {
		    Connection conn=null;
			try {
				//connectDB
				conn=DBManager.getConnection();


				//insert文
				String sql ="INSERT INTO user(login_Id,name,address,password,create_date,up_date)VALUES(?,?,?,?,now(),now())";
				//インサート実行
				 // SELECTを実行し、結果表を取得
		        PreparedStatement pStmt = conn.prepareStatement(sql);
		        pStmt.setString(1, loginId);
		        pStmt.setString(2, name);
		        pStmt.setString(3, address);
		        pStmt.setString(4, password);


		        //暗号化
		        String sourse="password";
		        Charset charset =StandardCharsets.UTF_8;
		        String algorithm="MD5";
		        byte[] bytes =MessageDigest.getInstance(algorithm).digest(sourse.getBytes(charset));
		        String code=DatatypeConverter.printHexBinary(bytes);
		        System.out.println(code);



				pStmt.executeUpdate();


			 } catch (SQLException | NoSuchAlgorithmException e) {
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
	  * 同じログインIDがないか調べる
	  * @param loginId
	  * @return
	  */
		    public boolean findSameloginId(String loginId) {
		        Connection conn = null;
		        try {
		            // データベースへ接続
		            conn = DBManager.getConnection();

		            // SELECT文を準備
		            String sql = "SELECT login_id FROM user WHERE login_id = ?";

		             // SELECTを実行し、結果表を取得
		            PreparedStatement pStmt = conn.prepareStatement(sql);
		            pStmt.setString(1, loginId);

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


		    public UserBeans updateUser(int userId,String loginId,String name,String address,String password) {
		        Connection conn=null;
		    	try {
		    		//connectDB
		    		conn=DBManager.getConnection();

		    		//update文
		    		String sql ="UPDATE user SET login_id=?,name=?,address=?,password=?, update_date=now() WHERE user_id=?;";
		    		//インサート実行
		    		 // SELECTを実行し、結果表を取得
		            PreparedStatement pStmt = conn.prepareStatement(sql);

		            pStmt.setString(1, loginId);
		            pStmt.setString(2, name);
		            pStmt.setString(3, address);
		            pStmt.setString(3, password);
		            pStmt.setInt(4, userId);

		          //暗号化
		            String sourse="password";
		            Charset charset =StandardCharsets.UTF_8;
		            String algorithm="MD5";
		            byte[] bytes =MessageDigest.getInstance(algorithm).digest(sourse.getBytes(charset));
		            String code=DatatypeConverter.printHexBinary(bytes);
		            System.out.println(code);


		    		pStmt.executeUpdate();



		    	}catch(SQLException | NoSuchAlgorithmException e)	{
		    		e.printStackTrace();
		    	}finally {
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

		    public void updateUserWithoutPassword(int userId,String loginId,String name,String address) {
		        Connection conn=null;
		    	try {
		    		//connectDB
		    		conn=DBManager.getConnection();

		    		//update文
		    		String sql ="UPDATE user SET login_id=?,name=?,address=?,update_date=now() WHERE user_id=?";
		    		//インサート実行
		    		 // SELECTを実行し、結果表を取得
		            PreparedStatement pStmt = conn.prepareStatement(sql);

		            pStmt.setString(1, loginId);
		            pStmt.setString(2, name);
		            pStmt.setString(3, address);
		            pStmt.setInt(4, userId);




		    		pStmt.executeUpdate();


		    	}catch(SQLException e)	{
		    		e.printStackTrace();
		    	}finally {
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
}
