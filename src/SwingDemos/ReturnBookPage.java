package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturnBookPage extends JFrame {
    Container c;
    public ReturnBookPage(ArrayList<Books> list, ArrayList<IssuedBook> issuedBooksList){
        c = getContentPane();
        JLabel label = new JLabel("Return Book");
        label.setBounds(200, 50, 200, 50);
        JLabel bookCallNo = new JLabel("Book CallNo:");
        bookCallNo.setBounds(50, 130, 100, 50);
        JTextField bookCallNoField = new JTextField();
        bookCallNoField.setBounds(200, 130, 200, 30);
        JLabel studentId = new JLabel("Student Id:");
        studentId.setBounds(50, 210, 100, 50);
        JTextField stuIdField = new JTextField();
        stuIdField.setBounds(200, 210, 200, 30);
        JButton returnBook = new JButton("Return Book");
        returnBook.setBounds(300, 290, 100, 50);
        JButton back = new JButton("Back");
        back.setBounds(450, 370, 100, 50);
        JLabel warning = new JLabel();
        warning.setText("Note: check the book properly!");
        warning.setForeground(Color.RED);
        warning.setBounds(60, 450, 200, 50);
        c.add(label);
        c.add(bookCallNo);
        c.add(bookCallNoField);
        c.add(studentId);
        c.add(stuIdField);
        c.add(returnBook);
        c.add(back);
        c.add(warning);

        returnBook.addActionListener(e -> {
            String callNo = bookCallNoField.getText();
            String stuId = stuIdField.getText();

            String callNoRegex = "[A-Za-z]{1}@[0-9]+";
            String stuIdRegex = "[0-9]+";

            Pattern callNoPattern = Pattern.compile(callNoRegex);
            Matcher callNoMatcher = callNoPattern.matcher(callNo);

            Pattern stuIdPattern = Pattern.compile(stuIdRegex);
            Matcher stuIdMatcher = stuIdPattern.matcher(stuId);

            String error = "";
            if (!callNoMatcher.matches()){
                error += "Invalid Call No.!\n";
            }

            if (!stuIdMatcher.matches()){
                error += "Invalid Student Id!\n";
            }

            if (!error.equals("")){
                JOptionPane.showMessageDialog(this, error);
            }
            else {
                boolean isFound = false;
                for (IssuedBook issuedBook : issuedBooksList) {
                    if (issuedBook.getBookCallNo().equalsIgnoreCase(callNo) && issuedBook.getStudentId().equalsIgnoreCase(stuId)) {
                        isFound = true;
                        for (Books book : list) {
                            if (book.getCallNo().equalsIgnoreCase(callNo)) {
                                book.setQuantity(book.getQuantity() + 1);
                                book.setIssuedQuantity(book.getIssuedQuantity() - 1);
                                break;
                            }
                        }
                        issuedBooksList.remove(issuedBook);
                        break;
                    }
                }
                if (isFound) {
                    JOptionPane.showMessageDialog(this, "Book is returned successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Sorry, unable to return book!");
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
