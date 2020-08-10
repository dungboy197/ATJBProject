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

import dungda5.entities.Person;
import dungda5.utils.PersonUtils;

@WebServlet(urlPatterns = { "/FindPerson" })
public class PersonFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonFindServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Person> list = null;
		try {
			String fName = (String) request.getParameter("FirstName");
			list = PersonUtils.getByFirstName(fName);
			request.setAttribute("personList", list);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Search.jsp");
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
