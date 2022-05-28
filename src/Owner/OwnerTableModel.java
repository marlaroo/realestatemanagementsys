package Owner;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class OwnerTableModel extends AbstractTableModel{
	public static final int INDEX=0;
	public static final int NAME=1;
	public static final int NRC=2;
	public static final int EMAIL=3;
	public static final int PHONE=4;
	public static final int ADDRESS=5;
	
	int j=0;
	
	private String title[]= {"NO","NAME","NRC","EMAIL","PHONE","ADDRESS"};
	private ArrayList<owner>ow=new ArrayList<owner>();
	
	public OwnerTableModel(ArrayList<owner>o) {
		ow=o;
	}
	public String getColumnName(int col) {
		return title[col];
	}
	@Override
	public int getRowCount() {
		
		return ow.size();
	}

	@Override
	public int getColumnCount() {
		
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		owner o=ow.get(row);
		switch(column) {
		case INDEX:return ++j;
		case NAME:return o.getOwnername();
		case NRC:return o.getOwner_nrc();
		case EMAIL:return o.getEmail();
		case PHONE:return o.getPhone();
		case ADDRESS:return o.getAddress();
		}
		
		return null;
	}

}
