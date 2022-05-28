package buy;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Owner.owner;

public class BuyTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int OWNERNAME=1;
	public static final int CUSTOMERNAME=2;
	public static final int PRICE=3;
	public static final int DATE=4;
	public static final int PROPERTYNAME=5;
	public static final int PROPERTYADDRESS=6;

	
	static int j=0;
	
	private String title[]= {"NO","OWNER","CUSTOMER","PRICE","DATE","PROPERTY","ADDRESS"};
	private ArrayList<buy>b=new ArrayList<buy>();
	
	public BuyTableModel(ArrayList<buy>bu) {
		b=bu;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	@Override
	public int getRowCount() {
		
		return b.size();
	}

	@Override
	public int getColumnCount() {
		
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		buy buy=b.get(row);
		switch(column) {
		case INDEX:return ++j;
		case OWNERNAME:return buy.getOwner_name();
		case CUSTOMERNAME:return buy.getCustomer_name();
		case PRICE:return buy.getPrice();
		case DATE:return buy.getDate();
		case PROPERTYNAME:return buy.getProperty_name();
		case PROPERTYADDRESS:return buy.getProperty_address();
		}
		
		return null;
	}

}
