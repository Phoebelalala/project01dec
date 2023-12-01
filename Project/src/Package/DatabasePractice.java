package Package;

import java.sql.*;

public class DatabasePractice {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("problemt in loading the driver");
			ex.printStackTrace();
		}
		
		try {
			String dbName = "Employee.accdb";
			String dbURL = "jdbc:ucanaccess://" + dbName;
			conn = DriverManager.getConnection(dbURL); // establish the connection
			String n = "Emily"; // this could be user input
			stat = conn.createStatement();
//			String query = "INSERT INTO EMP (EName, Salary) " + "values ('ABC', 65000)";
			String query = "INSERT INTO EMP (EName, Salary) " + "values ('"+n+"', 65000)";
			
//			stat.executeUpdate(query);  // update way 1
			query = "UPDATE EMP SET Salary = 120000 " + "where EName ='ABC' ";    //update query
			
			
			query = "DELETE FROM EMP where EName ='Yon' ";  
			stat.executeUpdate(query);
			
			rs = stat.executeQuery("SELECT * FROM Emp");
			
			int id;
			String name;
			double sal;
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				sal = rs.getDouble(3);
				System.out.println("id " + id + " name "+ name + " salary " + sal);
				
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();			
		}
		finally {
			try {
				if(conn!=null)
				{
					rs.close();
					stat.close();
					conn.close();
				}
				
			} catch (SQLException ex) {
				ex.printStackTrace();			
			}
		}
	}
}
