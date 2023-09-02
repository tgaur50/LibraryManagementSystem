package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminPage extends JFrame {
    Container c;
    public AdminPage(){
        c = getContentPane();
        JLabel label = new JLabel("Admin Section");
        label.setBounds(200, 100, 200, 50);
        JButton addLibrarian = new JButton("Add Librarian");
        addLibrarian.setBounds(200, 160, 200, 50);
        JButton viewLibrarian = new JButton("View Librarian");
        viewLibrarian.setBounds(200, 220, 200, 50);
        JButton deleteLibrarian = new JButton("Delete Librarian");
        deleteLibrarian.setBounds(200, 280, 200, 50);
        JButton logout = new JButton("Logout");
        logout.setBounds(200, 340, 200, 50);

        c.add(label);
        c.add(addLibrarian);
        c.add(viewLibrarian);
        c.add(deleteLibrarian);
        c.add(logout);

        addLibrarian.addActionListener(e -> {
            new AddLibrarianPage();
        });

        viewLibrarian.addActionListener(e -> {
            new ViewLibrarianPage();
        });

        deleteLibrarian.addActionListener(e -> {
            new DeleteLibrarianPage();
        });

        logout.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logged Out!");
            dispose();
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
