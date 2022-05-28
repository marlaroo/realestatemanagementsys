package customer;

import java.sql.*;
import java.util.ArrayList;

import Owner.OwnerDAO;
import Owner.owner;

public class customerDAO {
	private Connection con;
	public customerDAO() {
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
	
		public ArrayList<customer> getAllcustomer() throws SQLException{
			ArrayList<customer> ctmer=new ArrayList<customer>();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			pstm=con.prepareStatement("SELECT customer_id, name,nrc,email,phone,address FROM customers");
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String nrc=rs.getString(3);
				String email=rs.getString(4);
				String phone=rs.getString(5);
				String address=rs.getString(6);
				
				customer ct=new customer(id,name,nrc,email,phone,address);
				ctmer.add(ct);
			}
			pstm.close();
			rs.close();
				
			return ctmer;		
		}
		
		//INSERT STATEMENT
		
		public String addcustomer(customer ctmer) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			pstm=con.prepareStatement("INSERT INTO customers(name,nrc,email,phone,address) VALUES (?,?,?,?,?)");
			pstm.setString(1, ctmer.getCustomername());
			pstm.setString(2, ctmer.getCustomer_nrc());
			pstm.setString(3,ctmer.getEmail());
			pstm.setString(4, ctmer.getPhone());
			pstm.setString(5, ctmer.getAddress());
			
			pstm.executeUpdate();
			msg="Insert Success, Update 1 row effect.";
			return msg;
			
		}
		
		//DELETE department data
			public String deletecustomer(int id) throws SQLException {
				String msg=null;
				PreparedStatement pst = null;
				
				pst=con.prepareStatement("DELETE FROM customers WHERE customer_id=?");
				pst.setInt(1,id);
			
				
				pst.executeUpdate();
				
				msg="Delete Successfully! delete 1 row";

				pst.close();
				return msg;
			}
		
			public String updatecustomer(customer ctmer) throws SQLException {
				String msg=null;
				PreparedStatement pstm=null;
				
				pstm=con.prepareStatement("UPDATE customers SET name=?,nrc=?,email=?,phone=?,address=? WHERE customer_id=?");
				pstm.setString(1, ctmer.getCustomername());
				pstm.setString(2, ctmer.getCustomer_nrc());
				pstm.setString(3, ctmer.getEmail());
				pstm.setString(4,ctmer.getPhone());
				pstm.setString(5, ctmer.getAddress());
				pstm.setInt(6, ctmer.getCustomerid());
				
				pstm.executeUpdate();
				msg="Update Successfully!";
				return msg;
			}


	public static void main(String[] args) throws SQLException {
		//***********************Select statement test
				customerDAO ctmer=new customerDAO();
				ArrayList<customer> temp=new ArrayList<customer>();
				
				temp=ctmer.getAllcustomer();
				
				
				for(customer ct:temp) {
					
				System.out.println(ct.getCustomername()+" "+ct.getCustomer_nrc()+" "+ct.getPhone()+" "+ct.getEmail()+" "+ct.getAddress());
					
				}
				
				//************************ ADD department data
//				
//						customer ct= new customer("May Hla","12/ DA GA MA (N) 023154","mhmh@gmail.com","09-6584589652","5/58,EastDagon");
//						String ans=ctmer.addcustomer(ct);
//						System.out.println(ans);
//				
				//***************************Delete department data test
//				String ans=ctmer.deletecustomer(3);
//				System.out.println(ans);
//				
					//********************Update department data test

	}

}
