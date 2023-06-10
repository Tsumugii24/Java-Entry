import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComputerFrame extends JFrame implements ActionListener {
    static JTextField textOne, textTwo, textResult;
    static JButton getProblem, giveAnswer;
    static JLabel operatorLabel, message;
    static Teacher teacher = new Teacher();
    static ComputerFrame mainJFrame = new ComputerFrame();

    public static void main(String[] args) {
        mainJFrame.setTitle("算数测试"); // 设置框架的标题为"算数测试"
        Container container = mainJFrame.getContentPane();
        container.setLayout(new FlowLayout());
        textOne = new JTextField(10); // 创建textOne，其可见字符长是10
        textTwo = new JTextField(10); // 创建textTwo，其可见字符长是10
        textResult = new JTextField(10); // 创建textResult，其可见字符长是10
        operatorLabel = new JLabel("+");
        message = new JLabel("你还没有回答呢");
        getProblem = new JButton("获取题目"); // 创建"获取题目"按钮
        giveAnswer = new JButton("确认答案"); // 创建"确认答案"按钮
        container.add(getProblem); // 添加按钮getProblem到框架中
        container.add(textOne);
        container.add(operatorLabel);
        container.add(textTwo);
        container.add(new JLabel("="));
        container.add(textResult);
        container.add(giveAnswer);
        container.add(message); // 添加标签message到框架中
        textResult.requestFocus();
        textOne.setEditable(false); // 设置textOne文本框为不可编辑
        textTwo.setEditable(false); // 设置textTwo文本框为不可编辑
        // 将当前窗口注册为getProblem的ActionEvent事件监视器
        getProblem.addActionListener(mainJFrame);
        // 将当前窗口注册为giveAnswer的ActionEvent事件监视器
        giveAnswer.addActionListener(mainJFrame);
        // 将当前窗口注册为textResult的ActionEvent事件监视器
        textResult.addActionListener(mainJFrame);
        mainJFrame.setBounds(100, 100, 450, 100);
        mainJFrame.setVisible(true); // 设置框架可见性
        mainJFrame.validate();
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == getProblem) { // 判断事件源是否是getProblem
            int number1 = teacher.giveNumberOne(100); // 获得第一个操作数(100以内)
            int number2 = teacher.giveNumberTwo(100); // 获得第二个操作数(100以内)
            String operator = teacher.giveOperator(); // 获得操作符+、-、*、/
            textOne.setText("" + number1);
            textTwo.setText("" + number2);
            operatorLabel.setText(operator);
            message.setText("请回答");
            textResult.setText(null);
        } else if (source == giveAnswer || source == textResult) { // 判断事件源是否是giveAnswer或者按下Enter键
            String answer = textResult.getText();
            try {
                int result = Integer.parseInt(answer);
                if (teacher.getRight(result) == true) {
                    message.setText("你回答正确");
                } else {
                    message.setText("你回答错误");
                }
            } catch (NumberFormatException ex) {
                message.setText("请输入数字字符");
            }
        }
        textResult.requestFocus();
        mainJFrame.validate();
    }
}
