package servletDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {
	public void save(int id,String name,int age,long nm,String pass) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		String query = "INSERT INTO user VALUES(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Sarpata@6");
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
			pst.setLong(4, nm);
			pst.setString(5, pass);
			pst.executeUpdate();
			System.out.println("success");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(con!=null) con.close();
			if(pst!=null) pst.close();
		}
	}
}
