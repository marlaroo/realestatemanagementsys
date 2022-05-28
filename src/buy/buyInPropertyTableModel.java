package buy;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rent.rent;

public class buyInPropertyTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int PROPERTYNAME=1;
	public static final int OWNERNAME=2;
	public static final int OWNERNRC=3;
	public static final int PRICE=4;
	public static final int ADDRESS=5;
	int j=0;
	
	private String title[]= {"NO","TYPE","OWNER","NRC","PRICE","ADDRESS"};
	private ArrayList<buy>b=new ArrayList<buy>();
	
	public buyInPropertyTableModel(ArrayList<buy>property) {
		b=property;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return b.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		buy property=b.get(row);
		switch(column) {
		case INDEX:return ++j;
		case PROPERTYNAME:return property.getProperty_name();
		case OWNERNAME:return property.getOwner_name();
		case OWNERNRC:return property.getOwner_nrc();
		case PRICE:return property.getPrice();		
		case ADDRESS:return property.getProperty_address();
		
		
		}
	
		
		return null;
	}
}
