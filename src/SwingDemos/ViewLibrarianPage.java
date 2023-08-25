package SwingDemos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewLibrarianPage extends JFrame {
    Container c;
    public ViewLibrarianPage(ArrayList<Librararian> list){
        c = getContentPane();
        String[] headers = {"id", "Name", "Password", "Email", "Address", "City", "Contact"};
        DefaultTableModel dmt = new DefaultTableModel(headers, 0);
        JTable table = new JTable(dmt);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 600);
        c.add(sp);

        for (int i = 0; i < list.size(); i++){
//            String[] row = {String.valueOf((i + 1)), list.get(i).getName(), list.get(i).getPassword(), list.get(i).getEmail(),
//                    list.get(i).getAddress(), list.get(i).getCity(), list.get(i).getContact()};

            String[] row = {String.valueOf(list.get(i).getId()), list.get(i).getName(), list.get(i).getPassword(), list.get(i).getEmail(),
                    list.get(i).getAddress(), list.get(i).getCity(), list.get(i).getContact()};
            dmt.addRow(row);
        }

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
