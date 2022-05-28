package rent;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class RentInPropertyTableModel extends AbstractTableModel{
	public static final int INDEX=0;
	public static final int OWNERNAME=1;
	public static final int OWNERNRC=2;
	public static final int PROPERTY=3;	
	public static final int PRICE=4;
	public static final int ADDRESS=5;
	int j=0;
	
	private String title[]= {"NO","OWNER","NRC","PROPERTY","PRICE","ADDRESS"};
	private ArrayList<rent>p=new ArrayList<rent>();
	
	public RentInPropertyTableModel(ArrayList<rent>property) {
		p=property;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return p.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		rent property=p.get(row);
		switch(column) {
		case INDEX:return ++j;
		case OWNERNAME:return property.getOwner_name();
		case OWNERNRC:return property.getOwner_nrc();
		case PROPERTY:return property.getName();
		case PRICE:return property.getPrice();
		case ADDRESS:return property.getProperty_address();
		
		
		}
	
		
		return null;
	}
}
