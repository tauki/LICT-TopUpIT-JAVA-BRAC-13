import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Form extends JFrame implements ActionListener {
    JLabel uname, pwd, email;
    JTextField uname_txt, email_txt;
    JPasswordField pwd_txt;
    JButton register, login;

    public Form(String title){
        super(title);
        setLayout(new FlowLayout());
        JPanel panel = new JPanel(
                new GridLayout(4, 2, 10, 20)
        );

        uname = new JLabel("User Name");
        pwd = new JLabel("Password");
        email = new JLabel("Email");

        uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton("Register");
        login = new JButton("Take me to login");

        panel.add(uname);
        panel.add(uname_txt);
        panel.add(pwd);
        panel.add(pwd_txt);
        panel.add(email);
        panel.add(email_txt);
        panel.add(register);
        panel.add(login);

        add(panel);
        register.addActionListener(this);
        login.addActionListener(this);

        setDefaultCloseOperation(this.Exit_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals(register.getLabel())) {
            String name = uname_txt.getText();
            String pwd = pwd_txt.getText();
            String email = email_txt.getText();

            if(Validator.checkEmail(email)
                    && !Validator.userExists(name)
                    && !Validator.emailExists(email)
                    && Validator.validatePassword(pwd)
                    )
                JOptionPane.showMessageDialog(
                        this,
                        "Successful",
                        "Smile..."
                        JOptionPane.INFORMATION_MESSAGE
                );
            else JOptionPane.showMessageDialog(
                    this,
                    Validator.Errors,
                    "Sorry...",
                    JOptionPane.ERROR_MESSAGE
            );

        } else {

        }
    }
}