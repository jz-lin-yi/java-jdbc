package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBC_PreparedStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?&useSSL=false&serverTimezone=UTC","root","mysql");
		PreparedStatement ps = conn.prepareStatement("update account set balance = ? where id = ?");
		ps.setInt(1, 8000);
		ps.setInt(2, 3);
		
		PreparedStatement ps1 = conn.prepareStatement("select * from account");
		ResultSet rs = ps1.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			System.out.print(id + "\t");
			String name = rs.getString("name");
			System.out.print(name + "\t");
			int balance = rs.getInt("balance");
			System.out.println(balance);
		}
		rs.close();
		ps1.close();
		ps.close();
		conn.close();

	}
}
