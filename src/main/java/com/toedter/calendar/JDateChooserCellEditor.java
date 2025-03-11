package com.toedter.calendar;

import java.awt.Component;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class JDateChooserCellEditor extends AbstractCellEditor implements
		TableCellEditor {

	private static final long serialVersionUID = 917881575221755609L;

	private JDateChooser dateChooser = new JDateChooser();

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {

		Date date = null;
		if (value instanceof Date)
			date = (Date) value;

		dateChooser.setDate(date);

		return dateChooser;
	}

	public Object getCellEditorValue() {
		return dateChooser.getDate();
	}
}