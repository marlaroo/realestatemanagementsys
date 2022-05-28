package property_type;

import java.sql.*;
import java.util.ArrayList;

import Owner.OwnerDAO;
import Owner.owner;

public class typeDAO {
	private Connection con;
	
	public typeDAO() {
		String db="jdbc:mysql://localhost:3306/real_estate_management_sys";
		String user="root";
		String password="";
		
		try {
			con=DriverManager.getConnection(db,user,password);
			System.out.println("Connection Success...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//SLECT STATEMENT
	
		public ArrayList<property_type> getAlltype() throws SQLException{
			ArrayList<property_type> type=new ArrayList<property_type>();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			pstm=con.prepareStatement("SELECT type_id,name,description FROM types");
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String description=rs.getString(3);
				
				property_type ty=new property_type(id,name,description);
				type.add(ty);
			}
			pstm.close();
			rs.close();
			return type;		
		}
		
		//INSERT STATEMENT
		
		public String addtype(property_type type) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			pstm=con.prepareStatement("INSERT INTO types(name,description) VALUES (?,?)");
			pstm.setString(1, type.getName());
			pstm.setString(2, type.getDescription());
			
			pstm.executeUpdate();
			msg="Insert Success, Update 1 row effect.";
			return msg;
			
		}
		
		//DELETE department data
			public  String  deletetype(int id) throws SQLException {
				String msg=null;
				PreparedStatement pst = null;
				
				pst=con.prepareStatement("DELETE FROM types WHERE type_id=?");
				pst.setInt(1,id);
			
				
				pst.executeUpdate();
				
				msg="Delete Successfully! delete 1 row";

				pst.close();
				return msg;
			}
		
			public String updatetype(property_type type) throws SQLException {
				String msg=null;
				PreparedStatement pstm=null;
				
				pstm=con.prepareStatement("UPDATE types SET name=?,description=? WHERE type_id=?");
				pstm.setString(1, type.getName());
				pstm.setString(2, type.getDescription());
				pstm.setInt(3, type.getTypeid());
				
				pstm.executeUpdate();
				msg="Update Successfully!";
				return msg;
			}




//	public static void main(String[] args) throws SQLException {
//		//***********************Select statement test
//				typeDAO type=new typeDAO();
//				ArrayList<property_type> temp=new ArrayList<property_type>();
//				
//				temp=type.getAlltype();
//				
//				for(property_type ty:temp) {
//					
//				System.out.println(ty.getTypeid()+" "+ty.getName()+" "+ty.getDescription());
//					
//				}
//				
//				//************************ ADD department data
////				
////				property_type ty= new property_type(0,"Industrial","Regin of industrial");
////						String ans=type.addtype(ty);
////						System.out.println(ans);
//				
//				//***************************Delete department data test
////				String ans=type.deletetype(3);
////				System.out.println(ans);
////				
//					//********************Update department data test
//
//
//	}

}
