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

public class ColorDAO {

	public List<ColorBeans>  selectAllColorData() {
        Connection conn = null;
        List<ColorBeans> colorList = new ArrayList<ColorBeans>();
        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM color;";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);



            while (rs.next()) {
            	int colorId = rs.getInt("color_id");
                String colorName= rs.getString("color_name");

                ColorBeans color= new ColorBeans(colorId,colorName);

                colorList.add(color);
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
		return colorList;

    }
	public ColorBeans selectColorNamebyColorId(int colorId) {
        Connection conn = null;


        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "select * from color  where color_id=? ";
            PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setInt(1,colorId);
	        ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {



				//①値を取得する


					String colorName=rs.getString("color_name");


					ColorBeans color = new ColorBeans(colorId, colorName);
						return color;

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
		return  null;



    }
}
