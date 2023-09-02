package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddBooksPage extends JFrame {
    Container c;
    public AddBooksPage(){
        c = getContentPane();
        JLabel label = new JLabel("Add Books");
        label.setBounds(200, 50, 200, 50);
        JLabel callno = new JLabel("Call No:");
        callno.setBounds(50, 100, 100, 50);
        JTextField callField = new JTextField();
        callField.setBounds(200, 100, 200, 30);
        JLabel bookName = new JLabel("Name:");
        bookName.setBounds(50, 150, 100, 50);
        JTextField nameField = new JTextField();
        nameField.setBounds(200, 150, 200, 30);
        JLabel author = new JLabel("Author:");
        author.setBounds(50, 200, 100,50);
        JTextField authField = new JTextField();
        authField.setBounds(200, 200, 200, 30);
        JLabel publisher = new JLabel("Publisher:");
        publisher.setBounds(50, 250, 100, 50);
        JTextField pubField = new JTextField();
        pubField.setBounds(200, 250, 200, 30);
        JLabel quantity = new JLabel("Quantity:");
        quantity.setBounds(50, 300, 100, 50);
        JTextField quantField = new JTextField();
        quantField.setBounds(200, 300, 200, 30);
        JButton add = new JButton("Add Books");
        add.setBounds(300, 380, 100, 50);
        JButton back = new JButton("Back");
        back.setBounds(450, 460, 100, 50);
        c.add(label);
        c.add(callno);
        c.add(callField);
        c.add(bookName);
        c.add(nameField);
        c.add(author);
        c.add(authField);
        c.add(publisher);
        c.add(pubField);
        c.add(quantity);
        c.add(quantField);
        c.add(add);
        c.add(back);

        add.addActionListener(e -> {
            String cNo = callField.getText();
            String bName = nameField.getText();
            String bAuth = authField.getText();
            String bPub = pubField.getText();
            String bQuantity = quantField.getText();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());
            int id;

            String callNoRegex = "[A-Za-z]{1}@[0-9]+";
            String nameRegex = "[A-Za-z0-9\s\\.]+";
            String intRegex = "[0-9]+";

            Pattern callNoPattern = Pattern.compile(callNoRegex);
            Matcher callNoMatcher = callNoPattern.matcher(cNo);

            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(bName);
            Matcher authMatcher = namePattern.matcher(bAuth);
            Matcher pubMatcher = namePattern.matcher(bPub);

            Pattern intPattern = Pattern.compile(intRegex);
            Matcher quantityMatcher = intPattern.matcher(bQuantity);

            Books b = new Books();
            String error = "";
//            if (list.isEmpty()){
//                id = 1;
//            }
//            else {
//                id = list.get(list.size() - 1).getId() + 1;
//            }
//            b.setId(id);
            if (callNoMatcher.matches()){
                b.setCallNo(cNo);
            }
            else {
                error += "Invalid CallNo!\n";
            }
            if (nameMatcher.matches()){
                b.setBookName(bName);
            }
            else {
                error += "Invalid Book Name!\n";
            }
            if (authMatcher.matches()){
                b.setAuthorName(bAuth);
            }
            else {
                error += "Invalid Author Name!\n";
            }
            if (pubMatcher.matches()){
                b.setPublisherName(bPub);
            }
            else {
                error += "Invalid Publisher Name!\n";
            }
            if (quantityMatcher.matches()){
                b.setQuantity(Integer.parseInt(bQuantity));
            }
            else {
                error += "Invalid Quantity!\n";
            }
            if (error.equals("")){
                b.setIssuedQuantity(0);
                b.setAddedDate(date);
                if (LibrarianDao.addBooksToDB(b)){
                    JOptionPane.showMessageDialog(this, "Book is added successfully!");
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Error while inserting to DB!");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, error);
            }
        });

        back.addActionListener(e -> {
            dispose();
        });

        setLayout(null);
        setVisible(true);
        setTitle("Add Books");
        setBounds(100, 100, 600, 600);
    }
}
