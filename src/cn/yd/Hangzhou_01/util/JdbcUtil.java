/**
 * 
 */
package cn.yd.Hangzhou_01.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xxh
 *
 */
public class JdbcUtil {

	static {
		// System.out.println("-static");
		try {
			// ctrl+2,L 自动生成本地变量
			Class.forName("com.mysql.jdbc.Driver");
			// Connection connection = DriverManager.getConnection(url, "root",
			// "xxh2009");
			// System.out.println(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(Connection cnn, PreparedStatement pre) {
		close(cnn, pre,null);
	}
	
	public static void close(Connection cnn, PreparedStatement pre, ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			try {
				if (pre != null && !pre.isClosed()) {
					pre.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException();
			} finally {
				try {
					if (cnn != null && !cnn.isClosed()) {
						cnn.close();
					}
				} catch (SQLException e) {
					throw new RuntimeException();
				}
			}
		}

	}

	public static Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&characterEncoding=UTF-8";
		try {

			return DriverManager.getConnection(url, "root", "xxh2009");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		// return null;

	}

	public static void main(String[] args) {

	}
}
