import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;

public class LMS {

    JTextField nametextfield;
    JTextField emailField;
    JButton saveButton;
    JTable MemberTable;
    DefaultTableModel tableModel;
    JFrame Mainframe;
    JPanel Formpanel;
    JLabel namelabel, emaillabel;

    public LMS() {
        this.prepareJFrame();
    }

    public JFrame prepareJFrame() {
        Mainframe = new JFrame("STUDENTS FORM");
        Mainframe.setSize(600, 450);
        Mainframe.setLayout(new BorderLayout(10, 10));
        Mainframe.getContentPane().setBackground(new Color(255, 245, 235)); // light beige background
        Mainframe.add(this.prepareFormPanel(), BorderLayout.NORTH);
        Mainframe.add(new JScrollPane(this.prepareMemberTable()), BorderLayout.CENTER);
        Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mainframe.setVisible(true);
        return Mainframe;
    }

    public JPanel prepareFormPanel() {
        Formpanel = new JPanel(new GridLayout(3, 2, 10, 10));
        Formpanel.setBackground(new Color(255, 245, 235));
        Formpanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        Formpanel.add(this.prepareJLabelNamelabel());
        Formpanel.add(this.prepareJTextFieldNametextfield());
        Formpanel.add(this.prepareJLabelEmailLabel());
        Formpanel.add(this.prepareJTextFieldEmailTextField());
        Formpanel.add(new JLabel(""));
        Formpanel.add(this.prepareJButtonSaveButton());

        return Formpanel;
    }

    // Name label and field
    public JLabel prepareJLabelNamelabel() {
        namelabel = new JLabel("NAME:");
        namelabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        namelabel.setForeground(new Color(200, 0, 0));
        return namelabel;
    }

    public JTextField prepareJTextFieldNametextfield() {
        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        return nametextfield;
    }

    // Email label and field
    public JLabel prepareJLabelEmailLabel() {
        emaillabel = new JLabel("EMAIL:");
        emaillabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        emaillabel.setForeground(new Color(200, 0, 0));
        return emaillabel;
    }

    public JTextField prepareJTextFieldEmailTextField() {
        emailField = new JTextField();
        emailField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        return emailField;
    }

    public JButton prepareJButtonSaveButton() {
        saveButton = new JButton("SUBMIT");
        saveButton.setBackground(new Color(200, 0, 0)); // red background
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        saveButton.addActionListener(e -> {
            String name = nametextfield.getText().trim();
            String email = emailField.getText().trim();

            if (name.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
                return;
            }

            if (saveUser(name, email)) {
                JOptionPane.showMessageDialog(null, "User saved successfully!");
                loadUsers();
                nametextfield.setText("");
                emailField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error saving user!");
            }
        });

        return saveButton;
    }

    public JTable prepareMemberTable() {
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email"}, 0);
        loadUsers();
        MemberTable = new JTable(tableModel);
        MemberTable.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        MemberTable.setRowHeight(25);
        MemberTable.setGridColor(new Color(200, 0, 0));
        MemberTable.setSelectionBackground(new Color(255, 220, 220));
        
        JTableHeader header = MemberTable.getTableHeader();
        header.setBackground(new Color(200, 0, 0)); // red
        header.setForeground(Color.WHITE); // white text
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < MemberTable.getColumnCount(); i++) {
            MemberTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        return MemberTable;
    }