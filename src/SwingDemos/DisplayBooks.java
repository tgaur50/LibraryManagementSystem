package SwingDemos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class DisplayBooks extends JFrame {
    Container c;
    public DisplayBooks(ArrayList<Books> list){
        c = getContentPane();
        JLabel listLabel = new JLabel("List Of Books");
        listLabel.setBounds(100, 50, 200, 30);
        c.add(listLabel);
        String[] header = {"Book Name", "Author Name"};
        DefaultTableModel dmt = new DefaultTableModel(header, 0);
        JTable jtable = new JTable(dmt);
        JScrollPane sp = new JScrollPane(jtable);
        sp.setBounds(100, 100, 400, 400);
        jtable.setModel(dmt);
        dmt.setRowCount(0);
        for (Books books : list) {
            Object[] row = {books.getBookName(), books.getAuthorName()};
            dmt.addRow(row);
        }
        c.add(sp);
        setLayout(null);
        setVisible(true);
        setTitle("Display Books");
        setBounds(0, 0, 600, 600);
    }
}
