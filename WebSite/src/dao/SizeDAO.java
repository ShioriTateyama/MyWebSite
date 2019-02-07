package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ColorBeans;
import beans.SizeBeans;

public class SizeDAO {

	public List<SizeBeans> selectSizeData() {
        Connection conn = null;
        List<SizeBeans> sizeList=new ArrayList<SizeBeans>();
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM size;";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while (rs.next()) {
            	int sizeIdData = rs.getInt("size_id");
                String sizeName= rs.getString("size_name");

                SizeBeans size = new  SizeBeans(sizeIdData, sizeName);

                sizeList.add(size);
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
		return sizeList;

    }
}
