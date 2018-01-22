import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Form extends JFrame implements ActionListener {
    JLabel uname, pwd, email;
    JTextField uname_txt, email_txt;
    JPasswordField pwd_txt;
    JButton register, login;
    String registerLabel = "Register",
            loginLabel = "Login",
            registerLabelAlt = "Take me to sign up",
            loginLabelAlt = "Take me to sign in",
            usernameLabel = "Username",
            passwordLabel = "Password",
            emailLabel = "Email";

    public Form(String title){
        super(title);
        setLayout(new FlowLayout());

        if(title.equals(reg))
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

        setDefaultCloseOperation(this.Exit_ON_CLOSE);
    }

    public void initiateRegisterForm(JPanel panel) {
        uname = new JLabel(usernameLabel);
        pwd = new JLabel(passwordLabel);
        email = new JLabel(emailLabel);

        uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(registerLabel);
        login = new JButton(loginLabelAltAlt);

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
    }

    public void initiateLoginForm(JPanel panel) {
        // currently accepting only email and pass
        // uname = new JLabel("User Name");
        pwd = new JLabel(passwordLabel);
        email = new JLabel(emailLabel);

        //uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(registerLabelAltAlt);
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
                "Smile..."
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
        if(action.equals(register.getLabel())) {
            String name = uname_txt.getText();
            String pwd = pwd_txt.getText();
            String email = email_txt.getText();

            if(Validator.checkEmail(email)
                    && !Validator.userExists(name)
                    && !Validator.emailExists(email)
                    && Validator.validatePassword(pwd)
                    )
                showSuccess();
            else showError();

        } else if(action.equals(login.getLabel())) {
            if(Validator.verifyUserCred(email, pwd))
                showSuccess();
            else showError();

        } else {
            new Form(
                    action.equals(registerLabelAlt) ? registerLabel : loginLabel
            ).setVisible(true);
            this.dispose();

        }
    }
}