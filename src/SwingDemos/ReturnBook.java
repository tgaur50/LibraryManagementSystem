package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReturnBook extends JFrame {
    Container c;
    public ReturnBook(ArrayList<Books> list, ArrayList<Books> issueBookList){
        c = getContentPane();
        JLabel question = new JLabel("Which book you want to return?");
        question.setBounds(80, 100, 200, 30);
        c.add(question);

        JTextField text = new JTextField();
        text.setBounds(290, 100, 200, 30);
        c.add(text);

        JButton returnBook = new JButton("Return Now");
        returnBook.setBounds(500, 100, 100, 50);
        c.add(returnBook);

        JLabel resultText = new JLabel("");
        resultText.setBounds(80, 140, 400, 30);
        c.add(resultText);

        JRadioButton r1 = new JRadioButton("Yes");
        JRadioButton r2 = new JRadioButton("No");
        r1.setBounds(80, 180, 100, 30);
        r2.setBounds(190, 180, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        r1.setVisible(false);
        r2.setVisible(false);
        c.add(r1);
        c.add(r2);

        returnBook.addActionListener(e -> {
            boolean isFound = false;
            String book = text.getText();
            Books bo = null;
            for (Books b: issueBookList) {
                bo = b;
                if (b.getBookName().equalsIgnoreCase(book)){
                    isFound = true;
                    issueBookList.remove(b);
                    list.add(b);
                    resultText.setText(book + " is returned now");
                    break;
                }
            }
            if (!isFound){
                resultText.setText(book + " is not issued by this library");
            }
        });
        setLayout(null);
        setVisible(true);
        setTitle("Return Books");
        setBounds(0, 0, 700, 600);
    }
}
