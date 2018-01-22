import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Form extends JFrame implements ActionListener {
    JLabel uname, pwd, email;
    JTextField uname_txt, email_txt;
    JPasswordField pwd_txt;
    JButton register, login;
    static String registerLabel = "Register",
            loginLabel = "Login",
            registerLabelAlt = "Take me to sign up",
            loginLabelAlt = "Take me to sign in",
            usernameLabel = "Username",
            passwordLabel = "Password",
            emailLabel = "Email";

    public Form(String title){
        super(title);
        setLayout(new FlowLayout());

        if(title.equals(registerLabel))
            initiateRegisterForm(
                    new JPanel(
                            new GridLayout(4, 2, 10, 20)
                    )
            );

        else initiateLoginForm(
                new JPanel(
                        new GridLayout(3, 2, 10, 20)
                )
        );

        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void initiateRegisterForm(JPanel panel) {
        uname = new JLabel(usernameLabel);
        pwd = new JLabel(passwordLabel);
        email = new JLabel(emailLabel);

        uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(registerLabel);
        login = new JButton(loginLabelAlt);

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

        this.setVisible(true);
        this.setSize(800,400);
    }

    public void initiateLoginForm(JPanel panel) {
        // currently accepting only email and pass
        // uname = new JLabel("User Name");
        pwd = new JLabel(passwordLabel);
        email = new JLabel(emailLabel);

        //uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(registerLabelAlt);
        login = new JButton(loginLabel);

        //panel.add(uname);
        //panel.add(uname_txt);
        panel.add(email);
        panel.add(email_txt);
        panel.add(pwd);
        panel.add(pwd_txt);
        panel.add(register);
        panel.add(login);

        add(panel);
        register.addActionListener(this);
        login.addActionListener(this);
    }

    public void showSuccess() {
        JOptionPane.showMessageDialog(
                this,
                "Successful",
                "Smile...",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void showError() {
        JOptionPane.showMessageDialog(
                this,
                Validator.Errors,
                "Sorry...",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();

        String pwd = pwd_txt.getText();
        String email = email_txt.getText();

        if(action.equals(registerLabel)) {
            String name = uname_txt.getText();
            if(Validator.validateEmail(email)
                    && !Validator.userExists(name)
                    && !Validator.emailExists(email)
                    && Validator.validatePassword(pwd)
                    )
                showSuccess();
            else showError();

        } else {
            if (action.equals(loginLabel)) {
                if (Validator.verifyUserCred(email, pwd))
                    showSuccess();
                else showError();
            } else {
                Form form = new Form(
                        action.equals(registerLabelAlt) ? registerLabel : loginLabel
                );
                form.setVisible(true);
                form.setSize(800,400);
                this.dispose();
            }
        }
    }
}