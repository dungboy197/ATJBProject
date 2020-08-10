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
import dungda5.utils.PersonUtils;

@WebServlet(urlPatterns = { "/EditDept" })
public class DepartmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DepartmentEditServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptID = (String) request.getParameter("DeptID");
		Department department = null;
		try {
			department = DepartmentUtils.getByID(deptID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("department", department);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/EditDept.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int deptID = Integer.parseInt(request.getParameter("DeptID"));
		String deptName = (String) request.getParameter("DeptName");
		String description = (String) request.getParameter("Description");
		Department department = new Department(deptID, deptName, description);
		try {
			DepartmentUtils.updateDept(department);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListDept");
	}
}
