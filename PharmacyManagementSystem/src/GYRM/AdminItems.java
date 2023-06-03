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

public class AdminItems extends JPanel {
    private JPanel addPanel;
    private JPanel viewPanel;
    private JPanel removePanel;
    private JPanel updatePanel;
    private JLabel addTitleLabel;
    private JLabel viewTitleLabel;
    private JLabel removeTitleLabel;
    private JLabel updateTitleLabel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel typeLabel;
    private JComboBox typeComboBox;
    private JLabel yearsLabel;
    private JLabel priceLabel;
    private JLabel amountLabel;
    private JLabel clickViewLabel;
    private JTextField yearsField;
    private JTextField priceField;
    private JTextField amountField;
    private JButton viewButton;
    private JLabel nameToRemoveLabel;
    private JTextField nameToRemoveField;
    private JTextField updateNameField;
    private JButton updateAmountButton;
    private JTextField updateAmountField;
    private JTextField updatePriceField;
    private JButton updatePriceButton;
//    private JButton confirmNameButton;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel itemsShowLabel;
    private JButton backToMenuButton;
    private JTextArea reasonTextArea;
    private JLabel reasonLabel;

    public AdminItems(Main mainFrame) {
        $$$setupUI$$$();
        addButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String type = Objects.requireNonNull(typeComboBox.getSelectedItem()).toString();
                int years = Integer.parseInt(yearsField.getText());
                Date expDate = DateManipulation.getDateAfterYears(years);
                double price = Double.parseDouble(priceField.getText());
                int amount = Integer.parseInt(amountField.getText());
                System.out.println(name + " " + type + " " + years + " " + expDate + "  " + price + " " + amount);
                if (Objects.equals(type, "SELECT")) {
                    JOptionPane.showMessageDialog(this, "Please select the type correctly");
                } else {
                    try {
                        admin.addItem(name, type, expDate, price, amount);
                        JOptionPane.showMessageDialog(this, "Successfully Added !");
                        nameField.setText("");
                        yearsField.setText("");
                        typeComboBox.setSelectedItem("SELECT");
                        priceField.setText("");
                        amountField.setText("");
                    } catch (IllegalStateException exception) {
                        JOptionPane.showMessageDialog(this, "Expiration Date of the Item is early!!!");
                    }
                }
            } catch (SQLIntegrityConstraintViolationException exception) {
                JOptionPane.showMessageDialog(this, "This item already exists !");
            } catch (SQLException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(this, "Invalid input/s !");
            }
        });
        viewButton.addActionListener(e -> {
            StringBuilder builder = new StringBuilder("<html><table><thead>");
            builder.append("<th>Name</th><th>Type</th><th>ExpDate</th><th>Price</th><th>Amount</th></thead><tbody>");
            ArrayList<String[]> list;
            try {
                list = admin.viewItems();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
//            System.out.println("size: " + list.size());
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
            itemsShowLabel.setText(builder.toString());
        });
        deleteButton.addActionListener(e -> {
            String nameToRemove = nameToRemoveField.getText();
            String reason = reasonTextArea.getText();
            if (reason.length() >= 15 && !Objects.equals(nameToRemove, "")) {
                try {
                    boolean bool = admin.removeItem(nameToRemove, reason);
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
        updateAmountButton.addActionListener(e -> {
            String name = updateNameField.getText();
            if (!Objects.equals(name, "")) {
                try {
                    int updatedAmount = Integer.parseInt(updateAmountField.getText());
                    if (admin.updateItemAmount(name, updatedAmount)) {
                        JOptionPane.showMessageDialog(this, "Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Item name doesn't exist");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Something went wrong");
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Invalid Amount");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid item name");
            }
            updateNameField.setText("");
            updateAmountField.setText("");
        });
        updatePriceButton.addActionListener(e -> {
            String name = updateNameField.getText();
            if (!Objects.equals(name, "")) {
                try {
                    int updatedPrice = Integer.parseInt(updatePriceField.getText());
                    if (admin.updateItemPrice(name, updatedPrice)) {
                        JOptionPane.showMessageDialog(this, "Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Item name doesn't exist");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Something went wrong");
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(this, "Invalid Price");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid item name");
            }
            updateNameField.setText("");
            updatePriceField.setText("");
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
        this.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));
        addPanel = new JPanel();
        addPanel.setLayout(new GridLayoutManager(11, 3, new Insets(0, 0, 0, 0), -1, -1));
        addPanel.setBackground(new Color(-4850955));
        this.add(addPanel, new GridConstraints(0, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addTitleLabel = new JLabel();
        Font addTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, addTitleLabel.getFont());
        if (addTitleFont != null) addTitleLabel.setFont(addTitleFont);
        addTitleLabel.setText("ADD");
        addPanel.add(addTitleLabel, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        typeLabel = new JLabel();
        Font typeLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, typeLabel.getFont());
        if (typeLabelFont != null) typeLabel.setFont(typeLabelFont);
        typeLabel.setText("Type");
        addPanel.add(typeLabel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        Font nameLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, nameLabel.getFont());
        if (nameLabelFont != null) nameLabel.setFont(nameLabelFont);
        nameLabel.setText("Name");
        addPanel.add(nameLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        yearsLabel = new JLabel();
        Font yearsLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, yearsLabel.getFont());
        if (yearsLabelFont != null) yearsLabel.setFont(yearsLabelFont);
        yearsLabel.setText("Years");
        addPanel.add(yearsLabel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        priceLabel = new JLabel();
        Font priceLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, priceLabel.getFont());
        if (priceLabelFont != null) priceLabel.setFont(priceLabelFont);
        priceLabel.setText("Price");
        addPanel.add(priceLabel, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amountLabel = new JLabel();
        Font amountLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, amountLabel.getFont());
        if (amountLabelFont != null) amountLabel.setFont(amountLabelFont);
        amountLabel.setText("Amount");
        addPanel.add(amountLabel, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        addPanel.add(spacer8, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        addPanel.add(nameField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer9 = new Spacer();
        addPanel.add(spacer9, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer10 = new Spacer();
        addPanel.add(spacer10, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        yearsField = new JTextField();
        addPanel.add(yearsField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        priceField = new JTextField();
        addPanel.add(priceField, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        amountField = new JTextField();
        addPanel.add(amountField, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        typeComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("SELECT");
        defaultComboBoxModel1.addElement("Medicine/OTC");
        defaultComboBoxModel1.addElement("Medicine/Prescribed");
        defaultComboBoxModel1.addElement("Others");
        typeComboBox.setModel(defaultComboBoxModel1);
        addPanel.add(typeComboBox, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        addPanel.add(addButton, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), -1, -1));
        updatePanel.setBackground(new Color(-4402694));
        this.add(updatePanel, new GridConstraints(1, 2, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        updateTitleLabel = new JLabel();
        updateTitleLabel.setBackground(new Color(-4402694));
        Font updatTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, updateTitleLabel.getFont());
        if (updatTitleFont != null) updateTitleLabel.setFont(updatTitleFont);
        updateTitleLabel.setText("UPDATE");
        updatePanel.add(updateTitleLabel, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer11 = new Spacer();
        updatePanel.add(spacer11, new GridConstraints(1, 4, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Name:");
        updatePanel.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateNameField = new JTextField();
        updatePanel.add(updateNameField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Price");
        updatePanel.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        updatePriceField = new JTextField();
        updatePanel.add(updatePriceField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        updatePriceButton = new JButton();
        updatePriceButton.setText("UpdatePrice");
        updatePanel.add(updatePriceButton, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
//        confirmNameButton = new JButton();
//        confirmNameButton.setText("Confirm");
//        updatePanel.add(confirmNameButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer12 = new Spacer();
        updatePanel.add(spacer12, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Amount");
        updatePanel.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        updateAmountButton = new JButton();
        updateAmountButton.setText("UpdateAmount");
        updatePanel.add(updateAmountButton, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateAmountField = new JTextField();
        updateAmountField.setText("");
        updatePanel.add(updateAmountField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        viewPanel = new JPanel();
        viewPanel.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        viewPanel.setBackground(new Color(-12322109));
        this.add(viewPanel, new GridConstraints(0, 1, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        viewTitleLabel = new JLabel();
        Font viewTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, viewTitleLabel.getFont());
        if (viewTitleFont != null) viewTitleLabel.setFont(viewTitleFont);
        viewTitleLabel.setText("VIEW");
        viewPanel.add(viewTitleLabel, new GridConstraints(0, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        clickViewLabel = new JLabel();
        Font clickViewLabelFont = this.$$$getFont$$$(null, Font.BOLD, 20, clickViewLabel.getFont());
        if (clickViewLabelFont != null) clickViewLabel.setFont(clickViewLabelFont);
        clickViewLabel.setText("click view");
        viewPanel.add(clickViewLabel, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewButton = new JButton();
        viewButton.setBackground(new Color(-16713208));
        viewButton.setText("view");
        viewPanel.add(viewButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        itemsShowLabel = new JLabel();
        Font itemsShowLabelFont = this.$$$getFont$$$("SansSerif", Font.PLAIN, 18, itemsShowLabel.getFont());
        if (itemsShowLabelFont != null) itemsShowLabel.setFont(itemsShowLabelFont);
        itemsShowLabel.setText("Items Will be shown below");
        viewPanel.add(itemsShowLabel, new GridConstraints(3, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
        removePanel = new JPanel();
        removePanel.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        removePanel.setBackground(new Color(-343100));
        this.add(removePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        removeTitleLabel = new JLabel();
        Font removeTitleFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, removeTitleLabel.getFont());
        if (removeTitleFont != null) removeTitleLabel.setFont(removeTitleFont);
        removeTitleLabel.setText("REMOVE");
        removePanel.add(removeTitleLabel, new GridConstraints(0, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer23 = new Spacer();
        removePanel.add(spacer23, new GridConstraints(1, 3, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
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
        nameToRemoveField.setText("");
        removePanel.add(nameToRemoveField, new GridConstraints(1, 1, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer24 = new Spacer();
        removePanel.add(spacer24, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer25 = new Spacer();
        removePanel.add(spacer25, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        reasonLabel = new JLabel();
        Font reasonLabelFont = this.$$$getFont$$$("Saab", Font.BOLD | Font.ITALIC, 18, reasonLabel.getFont());
        if (reasonLabelFont != null) reasonLabel.setFont(reasonLabelFont);
        reasonLabel.setText("Reason");
        removePanel.add(reasonLabel, new GridConstraints(2, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        reasonTextArea = new JTextArea();
        removePanel.add(reasonTextArea, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        backToMenuButton = new JButton();
        backToMenuButton.setText("back to menu");
        this.add(backToMenuButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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