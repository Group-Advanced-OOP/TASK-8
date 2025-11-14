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