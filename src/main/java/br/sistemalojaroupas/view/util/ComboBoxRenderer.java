package br.sistemalojaroupas.view.util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {

    public ComboBoxRenderer() {
        setOpaque(true);
        setFont(new java.awt.Font("Tahoma", 0, 14));
        setBackground(new java.awt.Color(0, 0, 51));
        setForeground(new java.awt.Color(255,255,255));
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {
        setText(value.toString());
        return this;
    }
    
}
