package rent;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class RentTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int OWNERNAME=1;
	public static final int CUSTOMERNAME=2;	
	public static final int PROPERTYPRICE=3;
	public static final int DEPOSITE=4;
	public static final int FROMDATA=5;
	public static final int TODATE=6;
	public static final int PROPERTYNAME=7;
	public static final int ADDRESS=8;

	
	 int j=0;
	
	private String title[]= {"NO","OWNER","CUSTOMER","PRICE","DEPOSITE","FROMDATE","TODATE","PROPERTY","ADDRESS"};
	private ArrayList<rent>r=new ArrayList<rent>();
	
	public RentTableModel(ArrayList<rent>re) {
		r=re;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return r.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		rent rent=r.get(row);
		switch(column) {
		case INDEX:return ++j;
		case OWNERNAME:return rent.getOwner_name();
		case CUSTOMERNAME:return rent.getCustomer_name();
		case PROPERTYPRICE:return rent.getPrice();
		case DEPOSITE:return rent.getDeposite();
		case FROMDATA:return rent.getFrom_date();
		case TODATE:return rent.getTo_date();
		case PROPERTYNAME:return rent.getName();
		case ADDRESS:return rent.getProperty_address();
		
		
		
		
		
		
		
		}
		
		
		return null;
	}

}
