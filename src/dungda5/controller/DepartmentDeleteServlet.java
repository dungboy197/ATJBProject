package dungda5.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dungda5.utils.DepartmentUtils;

@WebServlet(urlPatterns = { "/DeleteDept" })
public class DepartmentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptID = request.getParameter("DeptID");
		try {
			DepartmentUtils.deleteDept(deptID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListDept");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
