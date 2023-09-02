package SwingDemos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewLibrarianPage extends JFrame {
    Container c;
    public ViewLibrarianPage(){
        c = getContentPane();
        String[] headers = {"id", "Name", "Password", "Email", "Address", "City", "Contact"};
        DefaultTableModel dmt = new DefaultTableModel(headers, 0);
        JTable table = new JTable(dmt);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 600);
        c.add(sp);

        ArrayList<Librararian> list = AdminDao.getLibrarians();
        for (Librararian l: list) {
            String[] row = {String.valueOf(l.getId()), l.getName(), l.getPassword(), l.getEmail(), l.getAddress(),
                    l.getCity(), l.getContact()};
            dmt.addRow(row);
        }

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
