package dungda5.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dungda5.entities.Person;
import dungda5.utils.PersonUtils;

@WebServlet(urlPatterns = { "/InsertPerson" })
public class PersonInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PersonInsertServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/Person.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = (String) request.getParameter("FirstName");
		String lastName = (String) request.getParameter("LastName");
		String gender = (String) request.getParameter("Gender");
		String phoneNumber = (String) request.getParameter("PhoneNumber");
		String email = (String) request.getParameter("Email");
		String address = (String) request.getParameter("Address");
		String[] temp = request.getParameterValues("Hobbies");
		String hobbies = Arrays.deepToString(temp);
		hobbies = hobbies.substring(1, hobbies.length() - 1);
		String description = (String) request.getParameter("Description");
		Person person = new Person(0, firstName, lastName, gender, phoneNumber, email, address, hobbies, description);

		request.setAttribute("person", person);
		try {
			PersonUtils.insertPerson(person);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/ListPerson");
	}

}
