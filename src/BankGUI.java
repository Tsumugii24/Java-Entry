import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame implements ActionListener {
    private JTextField amountField;
    private JPasswordField passwordField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton transferButton;

    public BankGUI() {
        setTitle("银行电子柜台");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel amountLabel = new JLabel("金额：");
        amountField = new JTextField(10);

        JLabel passwordLabel = new JLabel("密码：");
        passwordField = new JPasswordField(10);

        depositButton = new JButton("存钱");
        depositButton.addActionListener(this);

        withdrawButton = new JButton("取钱");
        withdrawButton.addActionListener(this);

        transferButton = new JButton("转账");
        transferButton.addActionListener(this);

        add(amountLabel);
        add(amountField);
        add(passwordLabel);
        add(passwordField);
        add(depositButton);
        add(withdrawButton);
        add(transferButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            double amount = Double.parseDouble(amountField.getText());
            deposit(amount);
        } else if (e.getSource() == withdrawButton) {
            double amount = Double.parseDouble(amountField.getText());
            withdraw(amount);
        } else if (e.getSource() == transferButton) {
            String password = new String(passwordField.getPassword());
            if (validatePassword(password)) {
                double amount = Double.parseDouble(amountField.getText());
                transfer(amount);
            } else {
                JOptionPane.showMessageDialog(this, "密码错误！");
            }
        }
    }

    private void deposit(double amount) {
        // 实现存钱逻辑
        // 可根据需求调用其他方法或类
        JOptionPane.showMessageDialog(this, "成功存入：" + amount + "元");
    }

    private void withdraw(double amount) {
        // 实现取钱逻辑
        // 可根据需求调用其他方法或类
        JOptionPane.showMessageDialog(this, "成功取出：" + amount + "元");
    }

    private void transfer(double amount) {
        // 实现转账逻辑
        // 可根据需求调用其他方法或类
        JOptionPane.showMessageDialog(this, "成功转账：" + amount + "元");
    }

    private boolean validatePassword(String password) {
        // 实现密码验证逻辑
        // 可根据需求调用其他方法或类
        // 返回true表示密码验证通过，返回false表示密码验证失败
        return password.equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankGUI();
            }
        });
    }
}

