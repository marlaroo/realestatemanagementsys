package property_type;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Owner.owner;


public class TypeTableModel extends AbstractTableModel {
	public static final int INDEX=0;
	public static final int NAME=1;
	public static final int DESCRIPTION=2;
	
	static int j=0;
	
	private String title[]= {"NO","NAME","DESCRIPTION"};
	private ArrayList<property_type>type=new ArrayList<property_type>();
	
	public TypeTableModel(ArrayList<property_type>ty) {
		type=ty;
	}
	public String getColumnName(int col) {
		return title[col];
	}

	@Override
	public int getRowCount() {
		return type.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		property_type ty=type.get(row);
		switch(column) {
		case INDEX:return ty.getTypeid();
		case NAME:return ty.getName();
		case DESCRIPTION:return ty.getDescription();
		}
		return null;
	}



}
