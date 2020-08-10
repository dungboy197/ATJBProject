package dungda5.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dungda5.entities.Department;
import dungda5.utils.DepartmentUtils;

@WebServlet(urlPatterns = { "/InsertDept" })
public class DepartmentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentInsertServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/InsertDept.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptName =  request.getParameter("DeptName");
		String description = request.getParameter("Description");
		Department department = new Department(0, deptName, description);
		
		request.setAttribute("department", department);
		try {
			DepartmentUtils.insertDepartment(department);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListDept");
	}
	

}
