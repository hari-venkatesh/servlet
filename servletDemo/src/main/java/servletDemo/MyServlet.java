package servletDemo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		long nm = Long.parseLong(req.getParameter("nm"));
		String pass = req.getParameter("ps");
		
		CRUD h = new CRUD();
		try {
			h.save(id, name, age, nm, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
