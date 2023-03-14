import javax.swing.*;
import java.awt.event.*;

public class Currency extends JFrame {
    public Currency() {
        JFrame f = new JFrame("Currency Converter");
        f.setSize(531, 318);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        String[] currencies = { "Indian Rupees", "Canadian Dollar", "Australian Dollar", "Japanese Yen", "Euros", "Pound Sterling", "Swiss Franc", "Russian Ruble"};
        JComboBox cb = new JComboBox(currencies);
        cb.setBounds(269, 76, 202, 28);
        f.add(cb);
        JLabel l1 = new JLabel("Currency Type: "), l2 = new JLabel("Enter USD: "), l3 = new JLabel("xxx");
        l1.setBounds(38, 84, 104, 20);
        l2.setBounds(38, 30, 107, 20);
        l3.setBounds(38, 202, 200, 20);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        JTextField tf = new JTextField();
        tf.setBounds(269, 23, 125, 27);
        f.add(tf);
        JButton b = new JButton("Convert");
        b.setBounds(179, 142, 94, 29);
        f.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cType = cb.getSelectedItem().toString();
                try {
                    double amount = Double.parseDouble(tf.getText()), newAmount;
                    if (cType.equals("Indian Rupees"))
                        newAmount = amount * 79.71;
                    else if (cType.equals("Canadian Dollar"))
                        newAmount = amount * 1.31;
                    else if (cType.equals("Euros"))
                        newAmount = amount * 1.01;
                    else if (cType.equals("Japanese Yen"))
                        newAmount = amount * 140.32;
                    else if (cType.equals("Swiss Franc"))
                        newAmount = amount * 0.98;
                    else if (cType.equals("Russian Ruble"))
                        newAmount = amount * 61.5;
                    else
                        newAmount = amount * 1.47;
                    l3.setText("$" + amount + " = " + newAmount + " " + cType);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please input a number.", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new Currency();
    }
}
