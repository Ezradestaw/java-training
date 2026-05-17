package first_package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwingTaskManagerPro extends JFrame {

    // ===== MODEL =====
    static class Task {
        String title;
        String description;
        int progress; // 0 - 100
        boolean completed;

        Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.progress = 0;
            this.completed = false;
        }

        String serialize() {
            return title + "|" + description + "|" + progress + "|" + completed;
        }

        static Task deserialize(String line) {
            String[] p = line.split("\\|");
            Task t = new Task(p[0], p[1]);
            t.progress = Integer.parseInt(p[2]);
            t.completed = Boolean.parseBoolean(p[3]);
            return t;
        }
    }

    private final List<Task> tasks = new CopyOnWriteArrayList<>();

    // ===== UI COMPONENTS =====
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);

    private final DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Title", "Description", "Progress", "Completed"}, 0
    );

    private final JTable table = new JTable(tableModel);
    private final JTextField searchField = new JTextField();

    private final JLabel statusLabel = new JLabel("System Ready");

    // ===== CONSTRUCTOR =====
    public SwingTaskManagerPro() {
        setTitle("Swing Task Manager Pro");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        startBackgroundUpdater();
    }

    // ===== UI SETUP =====
    private void initUI() {

        // LEFT NAVIGATION
        JPanel nav = new JPanel();
        nav.setLayout(new GridLayout(6, 1, 5, 5));

        JButton dashboardBtn = new JButton("Dashboard");
        JButton tableBtn = new JButton("Task Table");
        JButton addBtn = new JButton("Add Task");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");
        JButton exitBtn = new JButton("Exit");

        nav.add(dashboardBtn);
        nav.add(tableBtn);
        nav.add(addBtn);
        nav.add(saveBtn);
        nav.add(loadBtn);
        nav.add(exitBtn);

        // DASHBOARD PANEL
        JPanel dashboard = new JPanel();
        dashboard.setLayout(new BorderLayout());
        dashboard.add(new JLabel("📊 Task Dashboard (Live System)", SwingConstants.CENTER), BorderLayout.CENTER);

        // TABLE PANEL
        JPanel tablePanel = new JPanel(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.add(new JLabel("Search: "), BorderLayout.WEST);
        top.add(searchField, BorderLayout.CENTER);

        tablePanel.add(top, BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // MAIN CARD VIEW
        mainPanel.add(dashboard, "dashboard");
        mainPanel.add(tablePanel, "table");

        // SPLIT LAYOUT
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, nav, mainPanel);
        splitPane.setDividerLocation(150);

        add(splitPane, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        // ===== EVENTS =====
        dashboardBtn.addActionListener(e -> cardLayout.show(mainPanel, "dashboard"));
        tableBtn.addActionListener(e -> cardLayout.show(mainPanel, "table"));

        addBtn.addActionListener(e -> addTaskDialog());

        saveBtn.addActionListener(e -> saveToFile());
        loadBtn.addActionListener(e -> loadFromFile());

        exitBtn.addActionListener(e -> System.exit(0));

        searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                filterTable(searchField.getText());
            }
        });

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    if (row != -1) editTask(row);
                }
            }
        });
    }

    // ===== ADD TASK =====
    private void addTaskDialog() {
        JTextField title = new JTextField();
        JTextField desc = new JTextField();

        Object[] fields = {
                "Title:", title,
                "Description:", desc
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Add Task", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            Task t = new Task(title.getText(), desc.getText());
            tasks.add(t);
            refreshTable();
            status("Task Added");
        }
    }

    // ===== EDIT TASK =====
    private void editTask(int row) {
        Task t = tasks.get(row);

        JTextField title = new JTextField(t.title);
        JTextField desc = new JTextField(t.description);

        Object[] fields = {
                "Title:", title,
                "Description:", desc
        };

        int result = JOptionPane.showConfirmDialog(this, fields, "Edit Task", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            t.title = title.getText();
            t.description = desc.getText();
            refreshTable();
            status("Task Updated");
        }
    }

    // ===== TABLE REFRESH =====
    private void refreshTable() {
        tableModel.setRowCount(0);

        for (Task t : tasks) {
            tableModel.addRow(new Object[]{
                    t.title,
                    t.description,
                    t.progress + "%",
                    t.completed
            });
        }
    }

    // ===== FILTER =====
    private void filterTable(String query) {
        tableModel.setRowCount(0);

        for (Task t : tasks) {
            if (t.title.toLowerCase().contains(query.toLowerCase())) {
                tableModel.addRow(new Object[]{
                        t.title,
                        t.description,
                        t.progress + "%",
                        t.completed
                });
            }
        }
    }

    // ===== SAVE =====
    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter("tasks.db")) {
            for (Task t : tasks) {
                pw.println(t.serialize());
            }
            status("Saved successfully");
        } catch (Exception e) {
            status("Save failed");
        }
    }

    // ===== LOAD =====
    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.db"))) {
            tasks.clear();
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(Task.deserialize(line));
            }
            refreshTable();
            status("Loaded successfully");
        } catch (Exception e) {
            status("Load failed");
        }
    }

    // ===== BACKGROUND THREAD =====
    private void startBackgroundUpdater() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);

                    for (Task t : tasks) {
                        if (!t.completed) {
                            t.progress += new Random().nextInt(10);

                            if (t.progress >= 100) {
                                t.progress = 100;
                                t.completed = true;
                            }
                        }
                    }

                    SwingUtilities.invokeLater(this::refreshTable);

                } catch (Exception ignored) {}
            }
        }).start();
    }

    // ===== STATUS =====
    private void status(String msg) {
        statusLabel.setText("Status: " + msg);
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingTaskManagerPro().setVisible(true));
    }
}
