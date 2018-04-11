import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class testCal {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.setVisible(true);
    }
}

class Calculator extends JFrame implements ActionListener {
    Container container;
    JSplitPane jsp;
    JTextField resultFiled = new JTextField("0");
    JPanel resultPane = new JPanel();
    JPanel btnPane = new JPanel();
    static float op1 = 0;
    static int len = 0;
    static float op2 = 0;
    static String output = "";
    static String opp = "";
    static boolean flag1 = true;
    static boolean flag2 = true;
    String[] btnS = {"1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "0", "=", ".", "/"};
    JButton[] btn = new JButton[16];

    public Calculator() {
        container = getContentPane();
        setBounds(100, 100, 300, 300);
        setTitle("Calculator");
        setResizable(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBackground(new Color(255, 0, 255));

        JButton resetButton = new JButton("reset");
        resetButton.setBounds(0,0,80,20);
        resetButton.setBackground(new Color(65, 105, 225));
        resetButton.setForeground(new Color(0, 0, 0));
        resetButton.addActionListener(this);
        resultFiled.setEditable(false);
        resultFiled.setHorizontalAlignment(JTextField.RIGHT);  //设置自右向左显示
        resultFiled.setColumns(12);
        resultFiled.setFont(new Font("", Font.PLAIN, 14));
        resultFiled.setForeground(new Color(0, 0, 0));

        JButton cancelButton = new JButton("cancel");
        cancelButton.addActionListener(this);
        cancelButton.setBackground(new Color(65, 105, 225));
        cancelButton.setForeground(new Color(0, 0, 0));
        cancelButton.setSize(80,20);
        resultPane.setLayout(new FlowLayout());
        resultPane.add(resetButton);
        resultPane.add(resultFiled);
        resultPane.add(cancelButton);
        btnPane.setLayout(new GridLayout(4, 5, 7, 7));
        for(int i = 0; i < 16; i++) {
            btn[i] = new JButton(btnS[i]);
            btn[i].setBorderPainted(true);
            btn[i].setContentAreaFilled(true);
            btn[i].setFont(new Font("", Font.BOLD, 25));
            btn[i].setBackground(new Color(255,255,0));
            btn[i].setForeground(new Color(0,0,0));
            btn[i].addActionListener(this);
            btnPane.add(btn[i]);
        }
        jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, resultPane, btnPane);
        jsp.setDividerSize(3);
        jsp.setDividerLocation(35);
        container.add(jsp, BorderLayout.CENTER);
    }
    public void actionPerformed(ActionEvent e) {
        if(flag1 && (e.getActionCommand().equals("1") ||
                        e.getActionCommand().equals("2") ||
                        e.getActionCommand().equals("3") ||
                        e.getActionCommand().equals("4") ||
                        e.getActionCommand().equals("5") ||
                        e.getActionCommand().equals("6") ||
                        e.getActionCommand().equals("7") ||
                        e.getActionCommand().equals("8") ||
                        e.getActionCommand().equals("9") ||
                        e.getActionCommand().equals("0") ||
                        e.getActionCommand().equals("."))) {
            output += e.getActionCommand();
            resultFiled.setText(output);
        }
        if(e.getActionCommand().equals("=")) {
            if(flag1){
                op2 = Float.parseFloat(resultFiled.getText().substring(len+1));
                output += e.getActionCommand();
                if(opp.equals("+")) {
                    output += (op1+op2)+"";
                } if(opp.equals("-")) {
                    output += (op1-op2)+"";
                } if(opp.equals("*")) {
                    output += (op1*op2)+"";
                } if(opp.equals("/")){
                    if(op2-0.0 == 0) {
                        output += "error";
                    } else {
                        output += (op1/op2)+"";
                    }
                }
                resultFiled.setText(output);
                flag1 = false;
            }
        }
        if(e.getActionCommand().equals("reset")) {
            op1 = 0;
            op2 = 0;
            opp = "";
            output ="";
            flag1 = true;
            flag2 = true;
            resultFiled.setText("0");
        }
        if(e.getActionCommand().equals("+") || e.getActionCommand().equals("-") || e.getActionCommand().equals("*") || e.getActionCommand().equals("/")){
            if(flag2) {
                op1 = Float.parseFloat(resultFiled.getText());
                len = resultFiled.getText().length();
                opp = e.getActionCommand();
                output += e.getActionCommand();
                resultFiled.setText(output);
                flag2 = false;
            }
        }
    }
}