package dungda5.entities;

public class Department {
	private int deptID;
	private String deptName;
	private String description;
	public Department() {
		super();
	}
	public Department(int deptID, String deptName, String description) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
		this.description = description;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
