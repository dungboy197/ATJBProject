package dungda5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dungda5.entities.Department;
import dungda5.entities.Person;
import dungda5.utils.DepartmentUtils;
import dungda5.utils.PersonUtils;

@WebServlet(urlPatterns = { "/ListDept" })
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DepartmentListServlet() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Department> list = null;
		try {
			list = DepartmentUtils.getAll();
			request.setAttribute("deptList", list);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/ListDept.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
