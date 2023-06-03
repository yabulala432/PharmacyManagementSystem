package GYRM;

import DatabaseLogics.DateManipulation;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import static GYRM.AdminLogin.admin;

public class AdminEmployee extends JPanel {
    //    private JPanel this;
    private JPanel addPanel;
    private JLabel addTitle;
    private JLabel usernameLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel hoursLabel;
    //    ////    private JLabel wageLabel;
    private JTextField nameField;
    private JTextField passwordField;
    private JTextField hoursField;
    //    ////    private JTextField wageField;
    private JButton addButton;
    private JPanel updatePanel;
    private JLabel updatTitle;
    private JTextField updateuserameField;
    private JTextField updateAmountField;
    private JButton updateHoursButton;
    //    private JButton confirmNameButton;
    private JPanel viewPanel;
    private JLabel viewTitle;
    private JLabel clickViewLabel;
    private JButton viewButton;
    private JPanel removePanel;
    private JLabel removeTitle;
    private JButton deleteButton;
    private JLabel nameToRemoveLabel;
    private JTextField nameToRemoveField;
    private JTextField usernameField;
    private JLabel employeeShowLabel;
    private JButton backToMenuButton;
    private JLabel reasonLabel;
    private JTextArea reasonTextArea;

    public AdminEmployee(Main mainFrame) {
        $$$setupUI$$$();
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String username = usernameField.getText();
                String password = passwordField.getText();
                int hours = Integer.parseInt(hoursField.getText());
                if (!Objects.equals(username, "") && !Objects.equals(name, "")) {
                    if (password.length() >= 8) {
                        admin.addEmployee(name, username, password, hours);
                        JOptionPane.showMessageDialog(this, "Employee successfully Added !");
                    } else {
                        JOptionPane.showMessageDialog(this, "Password length must be greater than 7 characters");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Null value not allowed !");
                }
            } catch (SQLIntegrityConstraintViolationException exception) {
                JOptionPane.showMessageDialog(this, "This item already exists !");
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Invalid input/s !");
            }
            nameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            hoursField.setText("");
        });

        viewButton.addActionListener(e -> {
            StringBuilder builder = new StringBuilder("<html><table><thead>");
            builder.append("<th>Name</th><th>UserName</th><th>Password</th><th>Hours</th><th>Wage</th></thead><tbody>");
            ArrayList<String[]> list;
            try {
                list = admin.viewEmployee();
                System.out.println("size: " + list.size());
                for (String[] strings : list) {
                    builder.append("<tr>");
                    for (String string : strings) {
                        builder.append("<td>");
                        builder.append(string);
                        builder.append("</td>");
                    }
                    builder.append("</tr>");
                }
                builder.append("</tbody></table></html>");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            employeeShowLabel.setText(builder.toString());
        });

        deleteButton.addActionListener(e -> {
            String nameToRemove = nameToRemoveField.getText();
            String reason = reasonTextArea.getText();
            if (reason.length() >= 15 && !Objects.equals(nameToRemove, "")) {
                try {
                    boolean bool = admin.removeEmployee(nameToRemove, reason);
                    if (bool) {
                        JOptionPane.showMessageDialog(this, "Successfully Deleted");
                    } else {
                        JOptionPane.showMessageDialog(this, "No item with that Name found !");
                    }
                    nameToRemoveField.setText("");
                    reasonTextArea.setText("");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Something unexpected happened.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all the information.");
            }
        });

        updateHoursButton.addActionListener(e -> {
            String username = updateuserameField.getText();
            int hour = Integer.parseInt(updateAmountField.getText());
            admin.setEmpHours(hour);
            admin.setEmpWage(admin.getEmpHours());
            double wage = admin.getEmpWage();
            if (admin.updateEmpHoursAndWage(username, hour, wage)) {
                JOptionPane.showMessageDialog(this, "updated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "something went wrong");
            }
        });

        backToMenuButton.addActionListener(e -> {
            mainFrame.showPanel("adminMenu");
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
//        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
//        this = new JPanel();
        this.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        addPanel = new JPanel();
        addPanel.setLayout(new GridLayoutManager(11, 3, new Insets(0, 0, 0, 0), -1, -1));
        addPanel.setBackground(new Color(-4850955));
        this.add(addPanel, new GridConstraints(0, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addTitle = new JLabel();
        Font addTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, addTitle.getFont());
        if (addTitleFont != null) addTitle.setFont(addTitleFont);
        addTitle.setText("ADD");
        addPanel.add(addTitle, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        addPanel.add(spacer1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        addPanel.add(spacer2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        addPanel.add(spacer3, new GridConstraints(10, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        addPanel.add(spacer4, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        addPanel.add(spacer5, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        addPanel.add(spacer6, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer7 = new Spacer();
        addPanel.add(spacer7, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        usernameLabel = new JLabel();
        Font usernameLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, usernameLabel.getFont());
        if (usernameLabelFont != null) usernameLabel.setFont(usernameLabelFont);
        usernameLabel.setText("Username");
        addPanel.add(usernameLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        Font nameLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, nameLabel.getFont());
        if (nameLabelFont != null) nameLabel.setFont(nameLabelFont);
        nameLabel.setText("Name");
        addPanel.add(nameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordLabel = new JLabel();
        Font passwordLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, passwordLabel.getFont());
        if (passwordLabelFont != null) passwordLabel.setFont(passwordLabelFont);
        passwordLabel.setText("Password");
        addPanel.add(passwordLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        hoursLabel = new JLabel();
        Font hoursLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, hoursLabel.getFont());
        if (hoursLabelFont != null) hoursLabel.setFont(hoursLabelFont);
        hoursLabel.setText("Hours");
        addPanel.add(hoursLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        addPanel.add(spacer8, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        addPanel.add(nameField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer9 = new Spacer();
        addPanel.add(spacer9, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        addPanel.add(spacer10, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        passwordField = new JTextField();
        addPanel.add(passwordField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        hoursField = new JTextField();
        addPanel.add(hoursField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        addPanel.add(addButton, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        usernameField = new JTextField();
        addPanel.add(usernameField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        removePanel = new JPanel();
        removePanel.setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1));
        removePanel.setBackground(new Color(-343100));
        this.add(removePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        removeTitle = new JLabel();
        Font removeTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, removeTitle.getFont());
        if (removeTitleFont != null) removeTitle.setFont(removeTitleFont);
        removeTitle.setText("REMOVE");
        removePanel.add(removeTitle, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setBackground(new Color(-387040));
        deleteButton.setText("DELETE");
        removePanel.add(deleteButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameToRemoveLabel = new JLabel();
        Font nameToRemoveLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, nameToRemoveLabel.getFont());
        if (nameToRemoveLabelFont != null) nameToRemoveLabel.setFont(nameToRemoveLabelFont);
        nameToRemoveLabel.setText("Name:");
        removePanel.add(nameToRemoveLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameToRemoveField = new JTextField();
        removePanel.add(nameToRemoveField, new GridConstraints(1, 1, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer11 = new Spacer();
        removePanel.add(spacer11, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer12 = new Spacer();
        removePanel.add(spacer12, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        reasonLabel = new JLabel();
        Font reasonLabelFont = this.$$$getFont$$$("DialogInput", Font.BOLD | Font.ITALIC, 18, reasonLabel.getFont());
        if (reasonLabelFont != null) reasonLabel.setFont(reasonLabelFont);
        reasonLabel.setText("Reason");
        removePanel.add(reasonLabel, new GridConstraints(2, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        reasonTextArea = new JTextArea();
        removePanel.add(reasonTextArea, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        viewPanel.setBackground(new Color(-12322109));
        this.add(viewPanel, new GridConstraints(0, 1, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        viewTitle = new JLabel();
        Font viewTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, viewTitle.getFont());
        if (viewTitleFont != null) viewTitle.setFont(viewTitleFont);
        viewTitle.setText("VIEW");
        viewPanel.add(viewTitle, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clickViewLabel = new JLabel();
        Font clickViewLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, clickViewLabel.getFont());
        if (clickViewLabelFont != null) clickViewLabel.setFont(clickViewLabelFont);
        clickViewLabel.setText("click view");
        viewPanel.add(clickViewLabel, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewButton = new JButton();
        viewButton.setBackground(new Color(-16713208));
        viewButton.setText("view");
        viewPanel.add(viewButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        employeeShowLabel = new JLabel();
        Font employeeShowLabelFont = this.$$$getFont$$$("SansSerif", Font.PLAIN, 18, employeeShowLabel.getFont());
        if (employeeShowLabelFont != null) employeeShowLabel.setFont(employeeShowLabelFont);
        employeeShowLabel.setText("Employee Will be shown below");
        viewPanel.add(employeeShowLabel, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer13 = new Spacer();
        viewPanel.add(spacer13, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer14 = new Spacer();
        viewPanel.add(spacer14, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer15 = new Spacer();
        viewPanel.add(spacer15, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer16 = new Spacer();
        viewPanel.add(spacer16, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer17 = new Spacer();
        viewPanel.add(spacer17, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer18 = new Spacer();
        viewPanel.add(spacer18, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer19 = new Spacer();
        viewPanel.add(spacer19, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer20 = new Spacer();
        viewPanel.add(spacer20, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer21 = new Spacer();
        viewPanel.add(spacer21, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer22 = new Spacer();
        viewPanel.add(spacer22, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayoutManager(4, 3, new Insets(0, 0, 0, 0), -1, -1));
        updatePanel.setBackground(new Color(-4402694));
        this.add(updatePanel, new GridConstraints(1, 2, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        updatTitle = new JLabel();
        Font updatTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, updatTitle.getFont());
        if (updatTitleFont != null) updatTitle.setFont(updatTitleFont);
        updatTitle.setText("UPDATE");
        updatePanel.add(updatTitle, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Username");
        updatePanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateuserameField = new JTextField();
        updatePanel.add(updateuserameField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        updateAmountField = new JTextField();
        updateAmountField.setText("");
        updatePanel.add(updateAmountField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer23 = new Spacer();
        updatePanel.add(spacer23, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        updateHoursButton = new JButton();
        updateHoursButton.setText("UpdateHours");
        updatePanel.add(updateHoursButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("hours");
        updatePanel.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        backToMenuButton = new JButton();
        backToMenuButton.setText("<- back to menu");
        this.add(backToMenuButton, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return this;
    }


}