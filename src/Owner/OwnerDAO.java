package Owner;

import java.sql.*;
import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

import property.property;



public class OwnerDAO {
	private Connection con;
	public OwnerDAO() {
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
	
	public ArrayList<owner> getAllowner() throws SQLException{
		ArrayList<owner> ow=new ArrayList<owner>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT id,name,nrc,email,phone,address FROM owners");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String nrc=rs.getString(3);
			String email=rs.getString(4);
			String phone=rs.getString(5);
			String address=rs.getString(6);
			
			
			owner o=new owner(id,name,nrc,email,phone,address);
			ow.add(o);
		}
		pstm.close();
		rs.close();
		return ow;		
	}
	
	//INSERT STATEMENT
	
	public String addowner(owner ow) throws SQLException {
		String msg=null;
		PreparedStatement pstm=null;
//		int tid=0;
//		pstm=con.prepareStatement("SELECT * FROM properties WHERE properties.property_id=?");
//		pstm.setInt(1,ow.getPropertyid());
//		ResultSet rs = pstm.executeQuery();
//		while(rs.next()) {
//			tid=rs.getInt("property_id");
//		}
		pstm=con.prepareStatement("INSERT INTO owners(name,nrc,email,phone,address) VALUES (?,?,?,?,?)");
		pstm.setString(1, ow.getOwnername());
		pstm.setString(2, ow.getOwner_nrc());
		pstm.setString(3,ow.getEmail());
		pstm.setString(4, ow.getPhone());
		pstm.setString(5, ow.getAddress());
		
		pstm.executeUpdate();
		msg="Insert Success, Update 1 row effect.";
		return msg;
		
	}
	
	//DELETE department data
		public String deleteowner(int id) throws SQLException {
			String msg=null;
			PreparedStatement pst = null;
			
			pst=con.prepareStatement("DELETE FROM owners WHERE id=?");
			pst.setInt(1,id);
		
			
			pst.executeUpdate();
			
			msg="Delete Successfully! delete 1 row";

			pst.close();
			return msg;
		}
	
		public String updateowner(owner ow) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			
			pstm=con.prepareStatement("UPDATE owners SET name=?,nrc=?,email=?,phone=?,address=? WHERE id=?");
			pstm.setString(1, ow.getOwnername());
			pstm.setString(2, ow.getOwner_nrc());
			pstm.setString(3, ow.getEmail());
			pstm.setString(4,ow.getPhone());
			pstm.setString(5, ow.getAddress());
			pstm.setInt(6, ow.getOwnerid());
			
			pstm.executeUpdate();
			msg="Update Successfully!";
			return msg;
		}

//	public static void main(String[] args) throws SQLException {
//		//***********************Select statement test
//		OwnerDAO ow=new OwnerDAO();
//		ArrayList<owner> temp=new ArrayList<owner>();
//		
//		temp=ow.getAllowner();
//		
//		for(owner owner:temp) {
//			
//		System.out.println(owner.getOwnerid()+" "+owner.getOwnername()+" "+owner.getOwner_nrc()+" "+owner.getPhone()+" "+owner.getEmail()+" "+owner.getAddress());
//			
//		}
		
		//************************ ADD department data
//		
//				owner o= new owner(0,"Hla Hla","12/ DA GA MA (N) 023154","hhla@gmail.com","09-6584589652","5/458,EastDagon");
//				String ans=ow.addowner(o);
//				System.out.println(ans);
		
		//***************************Delete department data test
//		String ans=ow.deleteowner(2);
//		System.out.println(ans);
		
			//********************Update department data test


	//}

}
