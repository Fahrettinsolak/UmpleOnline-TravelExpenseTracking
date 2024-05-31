package com.solak.TravelExpense.main.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import com.solak.TravelExpense.main.lib.database.DatabaseHelper;
import com.solak.TravelExpense.main.lib.database.UserCredentialDAO;
import com.solak.TravelExpense.main.lib.models.UserCredentialWrapper;
import com.solak.TravelExpense.umple.AuthenticationManager;


public class RegisterScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserCredentialDAO userCredentialDAO;
    private AuthenticationManager authManager;

    public RegisterScreen() {
        // Initialize the database
        DatabaseHelper.initializeDatabase();

        authManager = new AuthenticationManager();
        userCredentialDAO = new UserCredentialDAO(authManager);

        setTitle("Login/Register Sayfası");
        setSize(710, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create UI components
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("User Name", SwingConstants.LEFT);
        usernameLabel.setForeground(new Color(255, 255, 255));
        usernameLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        usernameLabel.setBounds(123, 109, 439, 52);
        panel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        usernameField.setBounds(123, 172, 439, 38);
        panel.add(usernameField);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(123, 284, 439, 38);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0, 128, 0));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        loginButton.setBounds(123, 407, 439, 52);
        panel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setBackground(new Color(128, 128, 192));
        registerButton.setForeground(new Color(255, 255, 255));
        registerButton.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        registerButton.setBounds(123, 470, 439, 52);
        panel.add(registerButton);

        getContentPane().add(panel);
        
        JLabel lblPassword = new JLabel("Password", SwingConstants.LEFT);
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        lblPassword.setBounds(123, 221, 439, 52);
        panel.add(lblPassword);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(123, 370, 439, 26);
        panel.add(separator_1);
        
        JLabel lblTravelExpense = new JLabel("Travel Expense", SwingConstants.CENTER);
        lblTravelExpense.setForeground(new Color(255, 255, 255));
        lblTravelExpense.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
        lblTravelExpense.setBounds(123, 17, 439, 52);
        panel.add(lblTravelExpense);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBounds(123, 80, 439, 18);
        panel.add(separator_1_1);
        
		ImageIcon icon2 = new ImageIcon(RegisterScreen.class.getResource("login.jpg"));
		JLabel label_loginbackground = new JLabel("");
		label_loginbackground.setBounds(0, 0, 688, 569);
		Image image2 = icon2.getImage().getScaledInstance(label_loginbackground.getWidth(),
		label_loginbackground.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon iccon = new ImageIcon(image2);
		label_loginbackground.setIcon(iccon);
		panel.add(label_loginbackground);

        // Add action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });
    }

    public void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Perform login logic using UserCredentialDAO
        try {
            boolean success = authenticateUser(username, password);
            if (success) {
                JOptionPane.showMessageDialog(this, "Giriş başarılı!");
                openMainApp();
            } else {
                JOptionPane.showMessageDialog(this, "Kullanıcı adı veya şifre hatalı!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bir hata oluştu.");
        }
    }

    public void handleRegister() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Perform registration logic using UserCredentialDAO
        try {
            UserCredentialWrapper userCredential = new UserCredentialWrapper(authManager, username, password);
            userCredentialDAO.addUserCredential(userCredential);
            JOptionPane.showMessageDialog(this, "Kayıt başarılı!");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Bir hata oluştu.");
        }
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        // Fetch user credentials from the database
        for (UserCredentialWrapper userCredential : userCredentialDAO.getAllUserCredentials()) {
            if (userCredential.getUsername().equals(username) &&
                userCredential.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public void openMainApp() {
        // Code to open TripManagementScreen
        new MainApp().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterScreen().setVisible(true);
            }
        });
    }
}
