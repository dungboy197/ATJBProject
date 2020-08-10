package dungda5.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dungda5.utils.PersonUtils;

@WebServlet(urlPatterns = { "/DeletePerson" })
public class PersonDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String personID = request.getParameter("PersonID");
		try {
			PersonUtils.deletePerson(personID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListPerson");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
