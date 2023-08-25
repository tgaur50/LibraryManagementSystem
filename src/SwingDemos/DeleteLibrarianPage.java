package SwingDemos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteLibrarianPage extends JFrame {
    Container c;
    public DeleteLibrarianPage(ArrayList<Librararian> list){
        c = getContentPane();
        JLabel id = new JLabel("Enter Id:");
        id.setBounds(50, 100, 100, 50);
        JTextField idField = new JTextField();
        idField.setBounds(200, 100, 200, 30);
        JButton delete = new JButton("Delete");
        delete.setBounds(300, 180, 100, 50);
        JButton back = new JButton("Back");
        back.setBounds(450, 260, 100, 50);
        c.add(id);
        c.add(idField);
        c.add(delete);
        c.add(back);

        delete.addActionListener(e -> {
            boolean isFound = false;
            int idVal = Integer.parseInt(idField.getText());
            for (int i = 0; i < list.size(); i++){
                if ((i + 1) == idVal){
                    isFound = true;
                    list.remove(i);
                    break;
                }
            }
            if (isFound){
                JOptionPane.showMessageDialog(this, "Librarian deleted successfully!");
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Librarian does not exist!");
            }
        });

        back.addActionListener(e -> {
            dispose();
//            new AdminPage(list);
        });

        setLayout(null);
        setVisible(true);
        setBounds(100, 100, 600, 600);
    }
}
