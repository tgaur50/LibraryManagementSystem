package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IssueBook extends JFrame {
    Container c;
    public IssueBook(ArrayList<Books> list, ArrayList<Books> issuedBookList){
        c = getContentPane();
        JLabel question = new JLabel("Which book you want to issue?");
        question.setBounds(80, 100, 200, 30);
        c.add(question);

        JTextField text = new JTextField();
        text.setBounds(290, 100, 200, 30);
        c.add(text);

        JButton issueBook = new JButton("Issue Now");
        issueBook.setBounds(500, 100, 100, 50);
        c.add(issueBook);

        JLabel resultText = new JLabel("");
        resultText.setBounds(80, 140, 250, 30);
        c.add(resultText);
        issueBook.addActionListener(e -> {
            boolean isFound = false;
            String book = text.getText();
            for (Books b: list) {
                if (b.getBookName().equalsIgnoreCase(book)){
                    isFound = true;
                    list.remove(b);
                    issuedBookList.add(b);
                    resultText.setText(book + " is issued now");
                    break;
                }
            }
            if (!isFound){
                resultText.setText(book + " is not present in the library");
            }
        });
        setLayout(null);
        setVisible(true);
        setTitle("Issue Books");
        setBounds(0, 0, 700, 600);
    }
}
