package SwingDemos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewBooksPage extends JFrame {
    Container c;
    public ViewBooksPage(){
        c = getContentPane();
        String[] headers = {"Id", "CallNo", "Name", "Author", "Publisher", "Quantity", "Issued", "Added Date"};
        DefaultTableModel dmt = new DefaultTableModel(headers, 0);
        JTable table = new JTable(dmt);

        ArrayList<Books> list = LibrarianDao.getAllBooks();

        for (Books book : list){
            String[] row = {String.valueOf(book.getId()), book.getCallNo(), book.getBookName(), book.getAuthorName(),
                    book.getPublisherName(), String.valueOf(book.getQuantity()),
                    String.valueOf(book.getIssuedQuantity()), book.getAddedDate()};
            dmt.addRow(row);
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 600);
        c.add(sp);
        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
