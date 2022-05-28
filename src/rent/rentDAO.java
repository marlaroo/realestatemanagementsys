package rent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import buy.buy;

public class rentDAO {
	private Connection con;
	public rentDAO() {
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
	
	public ArrayList<rent> getAllrent() throws SQLException{
		ArrayList<rent> rent=new ArrayList<rent>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT rents.id,owners.name,customers.name,rents.price,rents.deposite,rents.from_date,rents.to_date,types.name,properties.address FROM rents,customers,owners,types,properties WHERE customers.customer_id=rents.customer_id AND owners.id=properties.owner_id AND properties.property_id=rents.property_id AND types.type_id=properties.type_id");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String owner_name=rs.getString(2);
			String customer_name=rs.getString(3);			
			int price=rs.getInt(4);
			int deposite=rs.getInt(5);
			String fromdate=rs.getString(6);
			String todate=rs.getString(7);
			String property_name=rs.getString(8);
			String property_address=rs.getString(9);
			
			rent r=new rent(id,owner_name,customer_name,price,deposite,fromdate,todate,property_name,property_address);
			rent.add(r);
		}
		pstm.close();
		rs.close();
		return rent;		
	}
	public ArrayList<rent> getallcustomerlist() throws SQLException{
		ArrayList<rent> rent=new ArrayList<rent>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT customers.customer_id,customers.name,customers.nrc FROM customers");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id=rs.getInt(1);
			String customer_name=rs.getString(2);
			String customer_nrc=rs.getString(3);

			
			rent r=new rent(id,customer_name,customer_nrc);
			rent.add(r);
		}
		pstm.close();
		rs.close();
		return rent;		
		
	}
	public ArrayList<rent> getallpropertylist() throws SQLException{
		ArrayList<rent> rent=new ArrayList<rent>();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		pstm=con.prepareStatement("SELECT types.name,owners.name,owners.nrc,properties.price,properties.address FROM owners,properties,types WHERE owners.id=properties.owner_id AND types.type_id=properties.type_id AND status='For rent'");
		rs=pstm.executeQuery();
		while(rs.next()) {
			String typename=rs.getString(1);
			String ownername=rs.getString(2);
			String owner_nrc=rs.getString(3);
			int price=rs.getInt(4);
			String address=rs.getString(5);
			rent r=new rent(typename,ownername,owner_nrc,price,address);
			rent.add(r);
		}
		pstm.close();
		rs.close();
		return rent;		
		
	}
	
	//INSERT STATEMENT
	
	public String addrent(rent Re) throws SQLException {
		String msg=null;
		PreparedStatement pstm=null;
		int cid=0;
		pstm=con.prepareStatement("SELECT * FROM customers WHERE customers.name=?");
		pstm.setString(1,Re.getCustomer_name());
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			cid=rs.getInt("customer_id");
		}
		int pid=0;
		pstm=con.prepareStatement("SELECT properties.*,types.name FROM properties,types WHERE properties.type_id=types.type_id AND types.name=?");
		//pstm=con.prepareStatement("SELECT * FROM properties WHERE properties.address=?");
		pstm.setString(1,Re.getName());
		//pstm.setString(1, Re.getProperty_address());
		rs = pstm.executeQuery();
		while(rs.next()) {
			pid=rs.getInt("property_id");
		}
		
	
		pstm=con.prepareStatement("INSERT INTO rents(price,deposite,from_date,to_date,customer_id,property_id) VALUES (?,?,?,?,?,?)");
		pstm.setInt(1,Re.getPrice());
		pstm.setInt(2,Re.getDeposite());
		pstm.setString(3,Re.getFrom_date());
		pstm.setString(4, Re.getTo_date());
		pstm.setInt(5,cid);
		pstm.setInt(6,pid);
		
		
		pstm.executeUpdate();
		msg="Insert Success, insert 1 row effect.";
		return msg;
		
	}
	
	//DELETE department data
		public String deleterent(int id) throws SQLException {
			String msg=null;
			PreparedStatement pst = null;
			
			pst=con.prepareStatement("DELETE FROM rents WHERE id=?");
			pst.setInt(1,id);
		
			
			pst.executeUpdate();
			
			msg="Delete Successfully! delete 1 row";

			pst.close();
			return msg;
		}
	
		public String updaterent(rent rent) throws SQLException {
			String msg=null;
			PreparedStatement pstm=null;
			
			pstm=con.prepareStatement("UPDATE rents SET price=?,deposite=?,from_date=?,to_date=? WHERE id=?");
			//pstm.setInt(1,rent.getProperty_id());
			//pstm.setInt(2,rent.getCustomer_id());
			pstm.setInt(1,rent.getPrice());
			pstm.setInt(2, rent.getDeposite());
			pstm.setString(3,rent.getFrom_date());
			pstm.setString(4, rent.getTo_date());
			pstm.setInt(5, rent.getRentid());
			
			pstm.executeUpdate();
			msg="Update Successfully!";
			return msg;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		// 
		//
	}

}
