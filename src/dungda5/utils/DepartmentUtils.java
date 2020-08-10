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

public class DepartmentUtils {
	public static void insertDepartment(Department department) throws ClassNotFoundException, SQLException {
		Connection conn = PersonDAO.getConnection();
		String sql = "INSERT INTO Department(DeptName,Description) VALUES (?,?);";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, department.getDeptName());
		pstm.setString(2, department.getDescription());
		pstm.executeUpdate();
	}

	public static List<Department> getAll()  throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "SELECT DeptID,DeptName,Description FROM Department";
		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Department> list = new ArrayList<Department>();
		while (rs.next()) {
			int deptID = rs.getInt("DeptID");
			String deptName = rs.getString("DeptName");
			String description = rs.getString("Description");
			
			Department department = new Department();
			department.setDeptID(deptID);
			department.setDeptName(deptName);
			department.setDescription(description);
			list.add(department);
		}
		return list;
	}

	public static void deleteDept(String deptID) throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "DELETE FROM DEPARTMENT WHERE DeptID = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, deptID);
		pstm.executeUpdate();
	}

	public static Department getByID(String deptID) throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "SELECT DeptName,Description FROM DEPARTMENT WHERE DeptID = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, deptID);
		ResultSet rs = pstm.executeQuery();
		Department department = new Department();
		while(rs.next()) {
			String deptName = rs.getString("DeptName");
			String description = rs.getString("Description");
			department.setDeptID(Integer.parseInt(deptID));
			department.setDeptName(deptName);
			department.setDescription(description);
		}
		return department;
	}

	public static void updateDept(Department department) throws SQLException, ClassNotFoundException {
		Connection conn = PersonDAO.getConnection();
		String sql = "Update DEPARTMENT set DeptName =?, Description=? where DeptID= ? ";
		 
        PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, department.getDeptName());
		pstm.setString(2, department.getDescription());
		pstm.setInt(3, department.getDeptID());
		pstm.executeUpdate();
	}

	public static List<Department> getByDeptName(String deptName) throws ClassNotFoundException, SQLException {
		Connection conn = PersonDAO.getConnection();
		String sql = "SELECT DeptID,Description FROM DEPARTMENT WHERE DeptName = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, deptName);
		ResultSet rs = pstm.executeQuery();
		List<Department> list = new ArrayList<Department>();
		while(rs.next()) {
			String deptID = rs.getString("DeptID");
			String description = rs.getString("Description");
			Department dept = new Department();
			dept.setDeptID(Integer.parseInt(deptID));
			dept.setDeptName(deptName);
			dept.setDescription(description);
			list.add(dept);
		}
		return list;
	}

}
