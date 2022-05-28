package property;

import java.sql.*;
import java.util.ArrayList;

import Owner.OwnerDAO;
import Owner.owner;


public class propertyDAO {
	private Connection con;
	public propertyDAO() throws SQLException {
		String db="jdbc:mysql://localhost:3306/real_estate_management_sys";
		String user="root";
		String password="";
		
		con=DriverManager.getConnection(db, user, password);
		System.out.println("Connection Success...");
	}
	
	//SLECT STATEMENT
	
		public ArrayList<property> getAllProperty() throws SQLException{
			ArrayList<property> pty=new ArrayList<property>();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			pstm=con.prepareStatement(" SELECT properties.property_id,types.name,properties.area,properties.price,properties.address,properties.update_date,properties.status,properties.description,owners.name,owners.nrc FROM properties,types,owners WHERE types.type_id=properties.type_id AND owners.id=properties.owner_id");
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id=rs.getInt(1);
				//String owner_nrc=rs.getString(2);
				String typename=rs.getString(2);
				//String type_name=rs.getString(3);
				String area=rs.getString(3);
				int price=rs.getInt(4);
				String address=rs.getString(5);
				String update_date=rs.getString(6);
				String status=rs.getString(7);
				String description=rs.getString(8);
				String ownername=rs.getString(9);
				String ownernrc=rs.getString(10);

				property pp=new property(id,typename,area,price,address,update_date,status,description,ownername,ownernrc);
				pty.add(pp);
			}
			pstm.close();
			rs.close();
			return pty;		
		}
//		public ArrayList<property> getownerid() throws SQLException {
//			ArrayList<property> pty=new ArrayList<property>();
//			PreparedStatement pstm=null;
//			ResultSet rs=null;
//			pstm=con.prepareStatement("SELECT owners FROM properties,types,owners WHERE owners.property_id=properties.id AND types.id=properties.type_id" );
//			rs=pstm.executeQuery();
//			while(rs.next()) {
//				String ownername=rs.getString(1);
//				property p= new property(ownername);
//				pty.add(p);
//			}
//			pstm.close();
//			rs.close();
//			return pty;
//			
//		}
		
		//INSERT STATEMENT
		
		public String addproperty(property pty) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			int tid=0;
			pstm=con.prepareStatement("SELECT * FROM types WHERE name=?");
			pstm.setString(1, pty.getName());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				tid=rs.getInt("type_id");
			}
			
			int cid=0;
			pstm=con.prepareStatement("SELECT * FROM owners WHERE name=?");
			pstm.setString(1, pty.getOwnername());
			 rs=pstm.executeQuery();
			while(rs.next()) {
				cid=rs.getInt("owners.id");
				
			}
			pstm=con.prepareStatement("INSERT INTO properties(area,price,address,update_date,status,description,type_id,owner_id) VALUES(?,?,?,?,?,?,?,?)");
			
			pstm.setString(1,pty.getArea());
			pstm.setInt(2,pty.getPrice());
			pstm.setString(3, pty.getAddress());
			pstm.setString(4, pty.getUpdate());
			pstm.setString(5, pty.getStatus());
			pstm.setString(6, pty.getDescription());
			pstm.setInt(7, tid);
			pstm.setInt(8,cid);	
			pstm.executeUpdate();
			msg="Insert Success, Update 1 row effect.";
			return msg;
			
		}
		
		//DELETE department data
				public String deleteproperty(int id) throws SQLException {
					String msg=null;
					PreparedStatement pst = null;
					
					pst=con.prepareStatement("DELETE FROM properties WHERE property_id=?");
					pst.setInt(1,id);
				
					
					pst.executeUpdate();
					
					msg="Delete Successfully! delete 1 row";

					pst.close();
					return msg;
				}
				public String updateproperty(property pty) throws SQLException {
					String msg=null;
					PreparedStatement pstm=null;
//					int cid=0;
//					pstm=con.prepareStatement("SELECT * FROM owners WHERE name=?");
//					pstm.setString(1, pty.getOwnername());
//					ResultSet rs=pstm.executeQuery();
//					while(rs.next()) {
//						cid=rs.getInt("owner_id");
//						
//					}
//					
//					int tid=0;
//					pstm=con.prepareStatement("SELECT * FROM types WHERE name=?");
//					pstm.setString(1, pty.getName());
//					rs = pstm.executeQuery();
//					while(rs.next()) {
//						tid=rs.getInt("type_id");
//					}
					
					pstm=con.prepareStatement("UPDATE properties SET area=?,price=?,address=?,update_date=?,status=?,description=?WHERE properties.property_id=?");;			
					pstm.setString(1,pty.getArea());
					pstm.setInt(2, pty.getPrice());
					pstm.setString(3, pty.getAddress());
					pstm.setString(4, pty.getUpdate());
					pstm.setString(5, pty.getStatus());
					pstm.setString(6, pty.getDescription());
//					pstm.setInt(7, pty.getTypeid());
//					pstm.setInt(8,pty.getOwnerid());
					pstm.setInt(7, pty.getPropertyid());
					
					pstm.executeUpdate();
					msg="Update Successfully!";
					return msg;
				}

		
//		public static void main(String[] args) throws SQLException {
//			//***********************Select statement test
//			propertyDAO pty=new propertyDAO();
//			ArrayList<property> temp=new ArrayList<property>();
//			
//			temp=pty.getAllProperty();
//			
//			for(property pro:temp) {
//				
//			System.out.println(pro.getOwner_id()+" "+pro.getProperty_type()+" "+pro.getArea()+" "+pro.getPrice()+" "+pro.getAddress()+" "+pro.getUpdate()+" "+pro.getStatus()+" "+pro.getDescription());
//			}
			
			//************************ ADD property data
//			
//					property pt= new property(1, "50000sqft", 5000000,"8/23 floor,yyys street,yangon","2021-12-8","for rent","including house and near bank");
//					String ans=pty.addowner(pt);
//					System.out.println(ans);
			
			//***************************Delete property data test
//			String ans=pty.deleteproperty(6);
//			System.out.println(ans);
			
				//********************Update department data test


//		}
	

}
