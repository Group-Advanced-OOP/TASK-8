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