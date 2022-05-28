package buy;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import rent.rent;

public class buyInClientTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int CUSTOMERNAME=1;
	public static final int CUSTOMERNRC=2;
	int j=0;
	
	private String title[]= {"NO","CLIENTNAME","CLIENTNRC"};
	private ArrayList<buy>c=new ArrayList<buy>();
	
	public buyInClientTableModel(ArrayList<buy>client) {
		c=client;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return c.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		buy client=c.get(row);
		switch(column) {
		case INDEX:return ++j;
		case CUSTOMERNAME:return client.getCustomer_name();
		case CUSTOMERNRC:return client.getCustomer_nrc();
		
		}
	
		
		return null;
	}
}
