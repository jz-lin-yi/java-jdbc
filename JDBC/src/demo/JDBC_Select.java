package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Select {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?&useSSL=false&serverTimezone=UTC","root","mysql");
		Statement st = conn.createStatement();
		
		
		
		ResultSet rs = st.executeQuery("select * from account");
		while (rs.next()) {
			int id = rs.getInt("id");
			System.out.print(id + "\t");
			String name = rs.getString("name");
			System.out.print(name + "\t");
			int balance = rs.getInt("balance");
			System.out.println(balance);
		}
		rs.close();
		st.close();
		conn.close();
	}
}
