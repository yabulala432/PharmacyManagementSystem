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

import static GYRM.AdminLogin.admin;

public class AdminSales extends JPanel {
    //    private JPanel this;
    private JLabel viewSalesLabel;
    private JButton deleteAllButton;
    private JLabel totalLabel;
    private JLabel titleLabel;
    private JButton backButton;
    private JButton viewButton;

    public AdminSales(Main mainFrame) {
        $$$setupUI$$$();
        viewButton.addActionListener(e -> {
            try {
                StringBuilder builder = new StringBuilder("<html><table><thead>");
                builder.append("<th>RollNo</th><th>Date</th><th>Name</th><th>Quantity</th><th>Price</th></thead><tbody>");
                ArrayList<String[]> list;
                list = admin.viewTotalSales();
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
                viewSalesLabel.setText(builder.toString());
            } catch (SQLException ignored) {
            }
        });

        deleteAllButton.addActionListener(e -> {
            admin.deleteAllTotalSales();
        });

        backButton.addActionListener(e -> {
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
        this.setLayout(new GridLayoutManager(5, 5, new Insets(0, 0, 0, 0), -1, -1));
        this.setBackground(new Color(-4850955));
        titleLabel = new JLabel();
        Font titleLabelFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setText("Sales");
        this.add(titleLabel, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewSalesLabel = new JLabel();
        Font viewSalesLabelFont = this.$$$getFont$$$(null, -1, 24, viewSalesLabel.getFont());
        if (viewSalesLabelFont != null) viewSalesLabel.setFont(viewSalesLabelFont);
        viewSalesLabel.setText("Sales will be show here");
        this.add(viewSalesLabel, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        totalLabel = new JLabel();
        Font totalLabelFont = this.$$$getFont$$$(null, Font.BOLD, 22, totalLabel.getFont());
        if (totalLabelFont != null) totalLabel.setFont(totalLabelFont);
        totalLabel.setText("TOTAL:");
        this.add(totalLabel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteAllButton = new JButton();
        deleteAllButton.setBackground(new Color(-363437));
        Font deleteAllButtonFont = this.$$$getFont$$$(null, Font.BOLD, 22, deleteAllButton.getFont());
        if (deleteAllButtonFont != null) deleteAllButton.setFont(deleteAllButtonFont);
        deleteAllButton.setText("Delete All");
        this.add(deleteAllButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        this.add(spacer1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        this.add(spacer2, new GridConstraints(4, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        this.add(spacer3, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$("Samanata", Font.BOLD, 18, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("BACK");
        this.add(backButton, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        viewButton = new JButton();
        Font viewButtonFont = this.$$$getFont$$$("Chandas", Font.BOLD, 20, viewButton.getFont());
        if (viewButtonFont != null) viewButton.setFont(viewButtonFont);
        viewButton.setText("view");
        this.add(viewButton, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
