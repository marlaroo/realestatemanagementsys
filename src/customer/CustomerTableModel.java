package customer;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Owner.owner;

public class CustomerTableModel extends AbstractTableModel{
	public static final int INDEX=0;
	public static final int NAME=1;
	public static final int NRC=2;
	public static final int EMAIL=3;
	public static final int PHONE=4;
	public static final int ADDRESS=5;
	
	static int j=0;
	
	private String title[]= {"NO","NAME","NRC","EMAIL","PHONE","ADDRESS"};
	private ArrayList<customer>ctrem=new ArrayList<customer>();
	
	public CustomerTableModel(ArrayList<customer>ct) {
		ctrem=ct;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	@Override
	public int getRowCount() {
		
		return ctrem.size();
	}

	@Override
	public int getColumnCount() {
		
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		customer ct=ctrem.get(row);
		switch(column) {
		case INDEX:return ct.getCustomerid();
		case NAME:return ct.getCustomername();
		case NRC:return ct.getCustomer_nrc();
		case EMAIL:return ct.getEmail();
		case PHONE:return ct.getPhone();
		case ADDRESS:return ct.getAddress();
		}
		
		return null;
	}

}
