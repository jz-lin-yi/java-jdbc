package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String url;
	private static String user;
	private static String pwd;
	private static String driver;
	private static Connection conn;
	static {

		try {
			readConfig();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("���ݿ�����ʧ��");
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void readConfig() throws IOException {
		Properties pro = new Properties();
		InputStream ist = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		pro.load(ist);
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		pwd = pro.getProperty("pwd");
		driver = pro.getProperty("driver");
	}

	public static Connection getConn() {

		return conn;
	}

	/**
	 * �ͷ�������Դ
	 */
	public static void close(Statement st, Connection conn) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * �ͷ�������Դ
	 */
	public static void close(ResultSet rs, Statement st, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new RuntimeException("rs�ر��쳣");
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new RuntimeException("rs�ر��쳣");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException("conn�ر��쳣");
			}
		}

	}
}
