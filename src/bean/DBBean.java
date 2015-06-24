package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class DBBean {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1/shopping";
				String user = "root";
				String password = "";

				con = DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public ResultSet exectueQuery(String sql, ArrayList params)
			throws Exception {
		if (con == null) {
			throw new Exception("Database not connected!");
		}

		pstmt = con.prepareStatement(sql);

		if (params != null) {
			Iterator i = params.iterator();
			int index = 1;
			while (i.hasNext()) {
				String tp = (String) i.next();
				pstmt.setString(index, tp);
				index++;
			}
		}

		rs = pstmt.executeQuery();

		return rs;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {

				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
