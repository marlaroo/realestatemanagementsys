package property;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Owner.owner;

public class PropertyTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int PROPERTYNAME=1;
	public static final int AREA=2;
	public static final int PRICE=3;
	public static final int ADDRESS=4;
	public static final int UPDATE_DATE=5;
	public static final int STATUS=6;
	public static final int DESCRIPTION=7;
	public static final int OWNERNAME=8;
	public static final int OWNERNRC=9;
	
	 int j=0;
	
	private String title[]= {"NO","TYPENAME","AREA","PRICE","ADDRESS","UPDATE","STATUS","DESCRIPTION","OWNERNAME","OWNERNRC"};
	private ArrayList<property>pty=new ArrayList<property>();
	
	public PropertyTableModel(ArrayList<property>pt) {
		pty=pt;
	}
	public String getColumnName(int col) {
		return title[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return pty.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		property pt=pty.get(row);
		switch(column) {
		case INDEX:return ++j;
		case PROPERTYNAME:return pt.getProperty_type();
		case AREA:return pt.getArea();
		case PRICE:return pt.getPrice();
		case ADDRESS:return pt.getAddress();
		case UPDATE_DATE:return pt.getUpdate();
		case STATUS:return pt.getStatus();
		case DESCRIPTION:return pt.getDescription();
		case OWNERNAME:return pt.getOwnername();
		case OWNERNRC:return pt.getOwnernrc();
		}
		return null;
	}

}
