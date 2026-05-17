package first_package;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Main class
public class FirstGui extends JFrame {

    // BankAccount class (OOP)
    static class BankAccount {
        private String accountHolderName;
        private int accountNumber;
        private double balance;

        public BankAccount(String name, int accNo) {
            this.accountHolderName = name;
            this.accountNumber = accNo;
            this.balance = 0.0;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            }
            return false;
        }

        public boolean withdraw(double amount) {
            if (amount <= 0 || amount > balance) {
                return false;
            }
            balance -= amount;
            return true;
        }

        public double getBalance() {
            return balance;
        }

        public String getDetails() {
            return "Name: " + accountHolderName +
                   "\nAccount No: " + accountNumber +
                   "\nBalance: " + balance;
        }
    }

    // UI Components
    private JLabel titleLabel, balanceLabel, statusLabel;
    private JButton createBtn, depositBtn, withdrawBtn, detailsBtn, exitBtn;

    private BankAccount account;

    // Constructor (GUI setup)
    public FirstGui() {
        setTitle("💳 EZRA BANK SYSTEM");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Layout
        setLayout(new BorderLayout());

        // Title
        titleLabel = new JLabel("BANK MANAGEMENT SYSTEM", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);
        add(titleLabel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 1, 10, 10));

        createBtn = new JButton("Create Account");
        depositBtn = new JButton("Deposit Money");
        withdrawBtn = new JButton("Withdraw Money");
        detailsBtn = new JButton("Account Details");
        exitBtn = new JButton("Exit");

        centerPanel.add(createBtn);
        centerPanel.add(depositBtn);
        centerPanel.add(withdrawBtn);
        centerPanel.add(detailsBtn);
        centerPanel.add(exitBtn);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel(new GridLayout(2,1));

        balanceLabel = new JLabel("Balance: 0.0", JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        statusLabel = new JLabel("Welcome!", JLabel.CENTER);
        statusLabel.setForeground(Color.DARK_GRAY);

        bottomPanel.add(balanceLabel);
        bottomPanel.add(statusLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        createBtn.addActionListener(e -> createAccount());
        depositBtn.addActionListener(e -> depositMoney());
        withdrawBtn.addActionListener(e -> withdrawMoney());
        detailsBtn.addActionListener(e -> showDetails());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // Methods for actions

    private void createAccount() {
        String name = JOptionPane.showInputDialog("Enter Name:");
        if (name == null || name.trim().isEmpty()) {
            statusLabel.setText("Invalid name!");
            return;
        }

        try {
            int accNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Account Number:"));
            account = new BankAccount(name, accNo);
            statusLabel.setText("Account created successfully!");
            updateBalance();
        } catch (Exception e) {
            statusLabel.setText("Invalid account number!");
        }
    }

    private void depositMoney() {
        if (account == null) {
            statusLabel.setText("Create account first!");
            return;
        }

        try {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount:"));
            if (account.deposit(amount)) {
                statusLabel.setText("Deposit successful!");
            } else {
                statusLabel.setText("Invalid amount!");
            }
            updateBalance();
        } catch (Exception e) {
            statusLabel.setText("Invalid input!");
        }
    }

    private void withdrawMoney() {
        if (account == null) {
            statusLabel.setText("Create account first!");
            return;
        }

        try {
            double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter Amount:"));
            if (account.withdraw(amount)) {
                statusLabel.setText("Withdrawal successful!");
            } else {
                statusLabel.setText("Invalid or insufficient balance!");
            }
            updateBalance();
        } catch (Exception e) {
            statusLabel.setText("Invalid input!");
        }
    }

    private void showDetails() {
        if (account == null) {
            statusLabel.setText("Create account first!");
        } else {
            JOptionPane.showMessageDialog(this, account.getDetails());
        }
    }

    private void updateBalance() {
        if (account != null) {
            balanceLabel.setText("Balance: " + account.getBalance());
        }
    }

    // Main method
    public static void main(String[] args) {
        new FirstGui();
    }
}