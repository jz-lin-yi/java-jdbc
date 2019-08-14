package utilesTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utils.JDBCUtils;

public class Test {
	public static void main(String[] args) {
		Connection conn = null;

		Statement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConn();
			st = conn.createStatement();
			rs = st.executeQuery("select * from account");
			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.print(id + "\t");
				String name = rs.getString("name");
				System.out.print(name + "\t");
				int balance = rs.getInt("balance");
				System.out.println(balance);
			}
		} catch (Exception e) {
			throw new RuntimeException("Á¬½Ó´íÎó");
		} finally {
			JDBCUtils.close(rs, st, conn);
		}

	}
}
