package GYRM;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import static GYRM.AdminLogin.admin;
import static GYRM.EmployeeLogin.employee;

public class EmployeeSellItem extends JPanel {
    //    private JPanel this;
    private JLabel sellItemLabel;
    private JTextField nameField;
    private JLabel nameLabel;
    private JButton findButton;
    private JLabel quantityLabel;
    private JLabel infoItemLabel;
    private JButton sellButton;
    private JButton backButton;
    private JComboBox quantityComboBox;

    public EmployeeSellItem(Main mainFrame) {
        $$$setupUI$$$();
        backButton.addActionListener(e -> {
            mainFrame.showPanel("employeeMenu");
        });
        findButton.addActionListener(e -> {

            String itemName = nameField.getText();
            ArrayList<String[]> foundItems;
            try {
                foundItems = employee.findMedicine(itemName);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            StringBuilder builder = new StringBuilder("<html><table><thead>");
            builder.append("<th>Name</th><th>Type</th><th>ExpDate</th><th>Price</th><th>Amount</th></thead><tbody>");
//                    System.out.println("size: " + foundItems.size());
            for (String[] strings : foundItems) {
                builder.append("<tr>");
                for (String string : strings) {
                    builder.append("<td>");
                    builder.append(string);
                    builder.append("</td>");
                }
                builder.append("</tr>");
            }
            builder.append("</tbody></table></html>");
            infoItemLabel.setText(builder.toString());
        });
        sellButton.addActionListener(e -> {
            try {
                String itemName = nameField.getText();
                int quantityCombo = Integer.parseInt((String) Objects.requireNonNull(quantityComboBox.getSelectedItem()));
//                System.out.println(quantityCombo);
                boolean sold = employee.sellMedicine(itemName, quantityCombo);
                if(sold){
                    JOptionPane.showMessageDialog(this,"Successfully sold");
                }else {
                    JOptionPane.showMessageDialog(this, "Please Write the exact item " +
                            "name shown in the display");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,"Error");
            }
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
        this.setLayout(new GridLayoutManager(6, 5, new Insets(0, 0, 0, 0), -1, -1));
        this.setBackground(new Color(-9983750));
        Font mainPanelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, this.getFont());
        if (mainPanelFont != null) this.setFont(mainPanelFont);
        sellItemLabel = new JLabel();
        Font sellItemLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, sellItemLabel.getFont());
        if (sellItemLabelFont != null) sellItemLabel.setFont(sellItemLabelFont);
        sellItemLabel.setText("Sell Item");
        this.add(sellItemLabel, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        infoItemLabel = new JLabel();
        Font infoItemLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, infoItemLabel.getFont());
        if (infoItemLabelFont != null) infoItemLabel.setFont(infoItemLabelFont);
        infoItemLabel.setText("Info Items");
        this.add(infoItemLabel, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        Font nameLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, nameLabel.getFont());
        if (nameLabelFont != null) nameLabel.setFont(nameLabelFont);
        nameLabel.setForeground(new Color(-16777216));
        nameLabel.setText("Name");
        this.add(nameLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameField = new JTextField();
        nameField.setText("");
        this.add(nameField, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        quantityLabel = new JLabel();
        Font quantityLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, quantityLabel.getFont());
        if (quantityLabelFont != null) quantityLabel.setFont(quantityLabelFont);
        quantityLabel.setText("Quantity");
        this.add(quantityLabel, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sellButton = new JButton();
        Font sellButtonFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, sellButton.getFont());
        if (sellButtonFont != null) sellButton.setFont(sellButtonFont);
        sellButton.setText("Sell");
        this.add(sellButton, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        this.add(spacer1, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        this.add(spacer2, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        findButton = new JButton();
        Font findButtonFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, findButton.getFont());
        if (findButtonFont != null) findButton.setFont(findButtonFont);
        findButton.setText("Find");
        this.add(findButton, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        this.add(spacer3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        quantityComboBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("1");
        defaultComboBoxModel1.addElement("2");
        defaultComboBoxModel1.addElement("3");
        defaultComboBoxModel1.addElement("4");
        defaultComboBoxModel1.addElement("5");
        quantityComboBox.setModel(defaultComboBoxModel1);
        this.add(quantityComboBox, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        this.add(spacer4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        backButton.setText("Back");
        this.add(backButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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