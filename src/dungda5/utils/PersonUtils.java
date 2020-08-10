package dungda5.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dungda5.connections.PersonDAO;
import dungda5.entities.Department;
import dungda5.entities.Person;

public class PersonUtils {
	public static List<Person> getAll() throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();

		String sql = "SELECT PersonID,FirstName,LastName,Gender,PhoneNumber,Email,Address,Hobbies,Description FROM PERSONAL";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Person> list = new ArrayList<Person>();

		while (rs.next()) {
			int personID = rs.getInt("PersonID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String gender = rs.getString("Gender");
			String phoneNumber = rs.getString("PhoneNumber");
			String email = rs.getString("Email");
			String address = rs.getString("Address");
			String hobbies = rs.getString("Hobbies");
			String description = rs.getString("Description");

			Person person = new Person();
			person.setPersonID(personID);
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setGender(gender);
			person.setPhoneNumber(phoneNumber);
			person.setEmail(email);
			person.setAddress(address);
			person.setHobbies(hobbies);
			person.setDescription(description);

			list.add(person);
		}
		return list;
	}

	public static void insertPerson(Person person) throws ClassNotFoundException, SQLException {
		Connection conn = PersonDAO.getConnection();
		String sql = "INSERT INTO Personal(FirstName, LastName, Gender, PhoneNumber, Email, Address, Hobbies, Description) VALUES (?,?,?,?,?,?,?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, person.getFirstName());
		pstm.setString(2, person.getLastName());
		pstm.setString(3, person.getGender());
		pstm.setString(4, person.getPhoneNumber());
		pstm.setString(5, person.getEmail());
		pstm.setString(6, person.getAddress());
		pstm.setString(7, person.getHobbies());
		pstm.setString(8, person.getDescription());
		pstm.executeUpdate();

	}

	public static List<Person> getByFirstName(String fName) throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "SELECT PersonID,FirstName,LastName,Gender,PhoneNumber,Email,Address,Hobbies,Description FROM PERSONAL WHERE FirstName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, fName);
		ResultSet rs = pstm.executeQuery();
		List<Person> list = new ArrayList<Person>();

		while (rs.next()) {
			int personID = rs.getInt("PersonID");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String gender = rs.getString("Gender");
			String phoneNumber = rs.getString("PhoneNumber");
			String email = rs.getString("Email");
			String address = rs.getString("Address");
			String hobbies = rs.getString("Hobbies");
			String description = rs.getString("Description");

			Person person = new Person();
			person.setPersonID(personID);
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setGender(gender);
			person.setPhoneNumber(phoneNumber);
			person.setEmail(email);
			person.setAddress(address);
			person.setHobbies(hobbies);
			person.setDescription(description);

			list.add(person);
		}
		return list;
	}

	public static Person getByID(String personID) throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "SELECT PersonID,FirstName,LastName,Gender,PhoneNumber,Email,Address,Hobbies,Description FROM PERSONAL WHERE PersonID = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, personID);
		ResultSet rs = pstm.executeQuery();
		Person person = new Person();
		while (rs.next()) {
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String gender = rs.getString("Gender");
			String phoneNumber = rs.getString("PhoneNumber");
			String email = rs.getString("Email");
			String address = rs.getString("Address");
			String hobbies = rs.getString("Hobbies");
			String description = rs.getString("Description");
			person.setPersonID(Integer.parseInt(personID));
			person.setFirstName(firstName);
			person.setLastName(lastName);
			person.setGender(gender);
			person.setPhoneNumber(phoneNumber);
			person.setEmail(email);
			person.setAddress(address);
			person.setHobbies(hobbies);
			person.setDescription(description);
		}
		return person;
	}
    public static void updatePerson(Person person) throws SQLException, ClassNotFoundException {
    	Connection conn = PersonDAO.getConnection();
        String sql = "Update PERSONAL set FirstName =?, LastName=?, Gender=?, PhoneNumber=?, Email=?, Address=?, Hobbies=?, Description=? where PersonID= ? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, person.getFirstName());
		pstm.setString(2, person.getLastName());
		pstm.setString(3, person.getGender());
		pstm.setString(4, person.getPhoneNumber());
		pstm.setString(5, person.getEmail());
		pstm.setString(6, person.getAddress());
		pstm.setString(7, person.getHobbies());
		pstm.setString(8, person.getDescription());
		pstm.setInt(9, person.getPersonID());
		
        pstm.executeUpdate();
    }

	public static void deletePerson(String personID) throws ClassNotFoundException, SQLException {
		Connection conn = PersonDAO.getConnection();
		String sql = "DELETE FROM PERSONAL WHERE PersonID = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, personID);
		pstm.executeUpdate();
	}

}
