package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IssueBookPage extends JFrame {
    Container c;
    public IssueBookPage(ArrayList<Books> list, ArrayList<IssuedBook> issuedBooksList){
        c = getContentPane();
        JLabel label = new JLabel("Issue Book");
        label.setBounds(200, 50, 200, 50);
        JLabel bookCallNo = new JLabel("Book Callno:");
        bookCallNo.setBounds(50, 100, 100, 50);
        JTextField bookCallNoField = new JTextField();
        bookCallNoField.setBounds(200, 100, 200, 30);
        JLabel studentId = new JLabel("Student Id:");
        studentId.setBounds(50, 150, 100, 50);
        JTextField studentIdField = new JTextField();
        studentIdField.setBounds(200, 150, 200, 30);
        JLabel studentName = new JLabel("Student Name:");
        studentName.setBounds(50, 200, 100, 50);
        JTextField stuNameField = new JTextField();
        stuNameField.setBounds(200, 200, 200, 30);
        JLabel studentContact = new JLabel("Student Contact:");
        studentContact.setBounds(50, 250, 140, 50);
        JTextField stuContactField = new JTextField();
        stuContactField.setBounds(200, 250, 200, 30);
        JButton issue = new JButton("Issue Book");
        issue.setBounds(280, 320, 100, 50);
        JButton back = new JButton("Back");
        back.setBounds(450, 400, 100, 50);
        JLabel warning = new JLabel();
        warning.setText("Note: Please check Student Id carefully before issuing book!");
        warning.setForeground(Color.RED);
        warning.setBounds(60, 480, 400, 50);
        c.add(label);
        c.add(bookCallNo);
        c.add(bookCallNoField);
        c.add(studentId);
        c.add(studentIdField);
        c.add(studentName);
        c.add(stuNameField);
        c.add(studentContact);
        c.add(stuContactField);
        c.add(issue);
        c.add(back);
        c.add(warning);

        issue.addActionListener(e -> {
            String callNo = bookCallNoField.getText();
            String stuId = studentIdField.getText();
            String stuName = stuNameField.getText();
            String stuContact = stuContactField.getText();
            String date;
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.format(new Date());

            String callNoRegex = "[A-Za-z]{1}@[0-9]+";
            String stuIdRegex = "[0-9]+";
            String stuNameRegex = "[A-Za-z\s\\.]+";
            String stuContactRegex = "(\\+[0-9]{2})*[0-9]{10}";

            Pattern callNoPattern = Pattern.compile(callNoRegex);
            Matcher callNoMatcher = callNoPattern.matcher(callNo);

            Pattern stuIdPattern = Pattern.compile(stuIdRegex);
            Matcher stuIdMatcher = stuIdPattern.matcher(stuId);

            Pattern stuNamePattern = Pattern.compile(stuNameRegex);
            Matcher stuNameMatcher = stuNamePattern.matcher(stuName);

            Pattern stuContactPattern = Pattern.compile(stuContactRegex);
            Matcher stuContactMatcher = stuContactPattern.matcher(stuContact);

            String error = "";

            if (!callNoMatcher.matches()){
                error += "Invalid Call No.!\n";
            }

            if (!stuIdMatcher.matches()){
                error += "Invalid Student Id!\n";
            }
            if (!stuNameMatcher.matches()){
                error += "Invalid Student Name!\n";
            }
            if (!stuContactMatcher.matches()){
                error += "Invalid Student Contact No.!\n";
            }

            if (!error.equals("")){
                JOptionPane.showMessageDialog(this, error);
            }
            else {
                int id;
                boolean isFound = false;
                for (int i = 0; i < list.size(); i++) {
                    Books book = list.get(i);
                    if (book.getQuantity() == 0) {
                        break;
                    } else if (book.getCallNo().equalsIgnoreCase(callNo)) {
                        isFound = true;
                        id = book.getId();
                        list.get(i).setQuantity(book.getQuantity() - 1);
                        list.get(i).setIssuedQuantity(book.getIssuedQuantity() + 1);
                        IssuedBook b = new IssuedBook(id, callNo, stuId, stuName, stuContact, date);
                        issuedBooksList.add(b);
                        break;
                    }
                }
                if (isFound) {
                    JOptionPane.showMessageDialog(this, "Book is issued successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Book is not found in the library!");
                }
            }
        });

        back.addActionListener(e -> {
            dispose();
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
