package SwingDemos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewIssuedBooksPage extends JFrame {
    Container c;
    public ViewIssuedBooksPage(ArrayList<IssuedBook> list){
        c = getContentPane();
        String[] headers = {"Id", "Book CallNo", "Student Id", "Student Name", "Student Contact", "Issued Date"};
        DefaultTableModel dmt = new DefaultTableModel(headers, 0);
        JTable table = new JTable(dmt);
        JScrollPane sp = new JScrollPane(table);

        for (IssuedBook book : list) {
            String[] row = {String.valueOf(book.getId()), book.getBookCallNo(), book.getStudentId(), book.getStudentName(),
                    book.getStudentContact(), book.getIssuedDate()};
            dmt.addRow(row);
        }

        sp.setBounds(0, 0, 600, 600);
        c.add(sp);
        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
