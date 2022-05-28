package Admin;

import java.sql.*;
import java.util.ArrayList;



public class adminDAO {
	private Connection con;
	
	public adminDAO() {
		String db="jdbc:mysql://localhost:3306/real_estate_management_sys";
		String user="root";
		String password="";
		
		try {
			con=DriverManager.getConnection(db, user, password);
			System.out.println("Connection Success...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of DAOmethod
	
	//for select method
	public ArrayList<admin> getAlladmin() throws SQLException {
		ArrayList<admin> admin=new ArrayList<admin>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			pstm= con.prepareStatement("SELECT name,password FROM admins" );
			rs=pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(rs.next()) {
			String name=rs.getString(1);
			String password=rs.getString(2);
admin ad= new admin(0, name,password);
			
			admin.add(ad);
		}
		pstm.close();
		rs.close();
		return admin;
	
	}
	
	public static void main(String[] args) throws SQLException {
		adminDAO admin=new adminDAO();
//			//***********************Select statement test
			ArrayList<admin> temp=new ArrayList<admin>();
//			
			temp=admin.getAlladmin();
			System.out.println("Name   Age");
			for(admin ad:temp) {
				
				System.out.println(ad.getName()+" "+ad.getPassword());
//				
		}
//			

		}

}
