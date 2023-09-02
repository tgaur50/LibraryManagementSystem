package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LibrarianPage extends JFrame {
    Container c;
    public LibrarianPage(){
        LibraryManagement lm = new LibraryManagement();
        c = getContentPane();
        JLabel label = new JLabel("Librarian Section");
        label.setBounds(200, 100, 200, 50);
        JButton addBooks = new JButton("Add Books");
        addBooks.setBounds(200, 160, 200, 50);
        JButton viewBooks = new JButton("View Books");
        viewBooks.setBounds(200, 220, 200, 50);
        JButton issueBook = new JButton("Issue Book");
        issueBook.setBounds(200, 280, 200, 50);
        JButton viewIssuedBooks = new JButton("View Issued Books");
        viewIssuedBooks.setBounds(200, 340, 200, 50);
        JButton returnBook = new JButton("Return Book");
        returnBook.setBounds(200, 400, 200, 50);
        JButton logout = new JButton("Logout");
        logout.setBounds(200, 460, 200, 50);

        c.add(label);
        c.add(addBooks);
        c.add(viewBooks);
        c.add(issueBook);
        c.add(viewIssuedBooks);
        c.add(returnBook);
        c.add(logout);

        addBooks.addActionListener(e -> {
            new AddBooksPage();
        });

        viewBooks.addActionListener(e -> {
            new ViewBooksPage();
        });

        issueBook.addActionListener(e -> {
            new IssueBookPage();
        });

        viewIssuedBooks.addActionListener(e -> {
            new ViewIssuedBooksPage();
        });

        returnBook.addActionListener(e -> {
            new ReturnBookPage();
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
