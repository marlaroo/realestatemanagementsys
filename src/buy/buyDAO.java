package buy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Owner.owner;
import rent.rent;

public class buyDAO {
	private Connection con;
	public buyDAO() {
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
	
	public ArrayList<buy> getAllbuy() throws SQLException{
		ArrayList<buy> b=new ArrayList<buy>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT buys.id,owners.name,customers.name,buys.price,buys.selling_date,types.name,properties.address FROM buys,customers,owners,types,properties WHERE customers.customer_id=buys.customer_id AND owners.id=properties.owner_id AND properties.property_id=buys.property_id AND types.type_id=properties.type_id");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String owner_name=rs.getString(2);
			String customer_name=rs.getString(3);			
			int price=rs.getInt(4);
			String date=rs.getString(5);
			String property_name=rs.getString(6);
			String property_address=rs.getString(7);
			
			buy bu=new buy(id,owner_name,customer_name,price,date,property_name,property_address);
			b.add(bu);
		}
		pstm.close();
		rs.close();
		return b;		
	}
	public ArrayList<buy> getallcustomerlist() throws SQLException{
		ArrayList<buy> b=new ArrayList<buy>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT customers.customer_id,customers.name,customers.nrc FROM customers");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String customer_name=rs.getString(2);
			String customer_nrc=rs.getString(3);

			
			buy bu=new buy(id,customer_name,customer_nrc);
			b.add(bu);
		}
		pstm.close();
		rs.close();
		return b;		
		
	}
	public ArrayList<buy> getallpropertylist() throws SQLException{
		ArrayList<buy> b=new ArrayList<buy>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT types.name,owners.name,owners.nrc,properties.price,properties.address FROM owners,properties,types WHERE owners.id=properties.owner_id AND types.type_id=properties.type_id AND status='For sale'");
		rs=pstm.executeQuery();
		while(rs.next()) {
			String typename=rs.getString(1);
			String ownername=rs.getString(2);
			String owner_nrc=rs.getString(3);
			int price=rs.getInt(4);
			String address=rs.getString(5);
			buy bu=new buy(typename,ownername,owner_nrc,price,address);
			b.add(bu);
		}
		pstm.close();
		rs.close();
		return b;		
		
	}
	
	//INSERT STATEMENT
	
	public String addbuy(buy b) throws SQLException {
		String msg=null;
		PreparedStatement pstm=null;
		int cid=0;
		pstm=con.prepareStatement("SELECT * FROM customers WHERE customers.name=?");
		pstm.setString(1,b.getCustomer_name());
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			cid=rs.getInt("customer_id");
		}
		int pid=0;
		pstm=con.prepareStatement("SELECT properties.*,types.name FROM properties,types WHERE properties.type_id=types.type_id AND types.name=?");
		
		pstm.setString(1,b.getProperty_name());
		
		rs = pstm.executeQuery();
		while(rs.next()) {
			pid=rs.getInt("property_id");
		}

		pstm=con.prepareStatement("INSERT INTO buys( property_id,customer_id,price,selling_date ) VALUES (?,?,?,?)");
		pstm.setInt(1,pid);
		pstm.setInt(2,cid);
		pstm.setInt(3,b.getPrice());
		pstm.setString(4,b.getDate());
		
		pstm.executeUpdate();
		msg="Insert Success, Insert 1 row effect.";
		return msg;
		
	}
	
	//DELETE department data
		public String deletebuy(int id) throws SQLException {
			String msg=null;
			PreparedStatement pst = null;
			
			pst=con.prepareStatement("DELETE FROM buys WHERE id=?");
			pst.setInt(1,id);
		
			
			pst.executeUpdate();
			
			msg="Delete Successfully! delete 1 row";

			pst.close();
			return msg;
		}
	
		public String updatebuy(buy b) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			
			pstm=con.prepareStatement("UPDATE buys SET buys.price=?,buys.selling_date=? WHERE buys.id=?");
			//pstm.setInt(1,b.getProperty_id());
			//pstm.setInt(2,b.getCustomer_id());
			pstm.setInt(1,b.getPrice());
			pstm.setString(2,b.getDate());
			pstm.setInt(3,b.getBuyid());
			
			pstm.executeUpdate();
			msg="Update Successfully!";
			return msg;
		}

	public static void main(String[] args) {
		// 
		
		
	}

}
