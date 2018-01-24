import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Form extends JFrame implements ActionListener {
    JLabel uname, pwd, email;
    JTextField uname_txt, email_txt;
    JPasswordField pwd_txt;
    JButton register, login;
    static final String 
        LABEL_REGISTER =        "Register",
        LABEL_REGISTER_ALT =    "Take me to sign up",
        LABEL_LOGIN =           "Login",
        LABEL_LOGIN_ALT =       "Take me to sign in",
        LABEL_USERNAME =        "Username",
        LABEL_PASSWORD =        "Password",
        LABEL_EMAIL =           "Email";

    public Form(String title){
        super(title);
        setLayout(new FlowLayout());

        if(title.equals(LABEL_REGISTER))
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
        uname = new JLabel(LABEL_USERNAME);
        pwd = new JLabel(LABEL_PASSWORD);
        email = new JLabel(LABEL_EMAIL);

        uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(LABEL_REGISTER);
        login = new JButton(LABEL_LOGIN_ALT);

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
        pwd = new JLabel(LABEL_PASSWORD);
        email = new JLabel(LABEL_EMAIL);

        //uname_txt = new JTextField(10);
        pwd_txt = new JPasswordField(20);
        email_txt = new JTextField(30);

        register = new JButton(LABEL_REGISTER_ALT);
        login = new JButton(LABEL_LOGIN);

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

        if(action.equals(LABEL_REGISTER)) {
            String name = uname_txt.getText();
            if(Validator.validateEmail(email)
                    && !Validator.userExists(name)
                    && !Validator.emailExists(email)
                    && Validator.validatePassword(pwd)
                    )
                showSuccess();
            else showError();

        } else {
            if (action.equals(LABEL_LOGIN)) {
                if (Validator.verifyUserCred(email, pwd))
                    showSuccess();
                else showError();
            } else {
                Form form = new Form(
                        action.equals(LABEL_REGISTER_ALT) ? LABEL_REGISTER : LABEL_LOGIN
                );
                form.setVisible(true);
                form.setSize(800,400);
                this.dispose();
            }
        }
    }
}