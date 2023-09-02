package SwingDemos;

import javax.swing.*;
import java.awt.*;

class LibraryHomePage extends JFrame {
    Container c;
    public LibraryHomePage(){
//        LibraryManagement lm = new LibraryManagement();
//        ArrayList<Librararian> listOfLibrarians = lm.getListOfLibrarians();
//        ArrayList<Books> listOfBooks = lm.getListOfBooks();
//        ArrayList<IssuedBook> listOfIssuedBooks = lm.getListOfIssuedBooks();
        c = getContentPane();
        JLabel label = new JLabel("Library Management");
        label.setBounds(200, 100, 200, 50);
        JButton admin = new JButton("Admin Login");
        admin.setBounds(200, 160, 200, 50);
        JButton librarian = new JButton("Librarian Login");
        librarian.setBounds(200, 220, 200, 50);

        admin.addActionListener(e -> new AdminLogin());

        librarian.addActionListener(e -> new LibrarianLogin());

        c.add(label);
        c.add(admin);
        c.add(librarian);

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class HomePage {
    public static void main(String[] args) {
        new LibraryHomePage();
    }
}
