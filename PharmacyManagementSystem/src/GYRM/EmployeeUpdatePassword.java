package GYRM;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;
import java.util.Objects;

import static GYRM.EmployeeLogin.employee;

public class EmployeeUpdatePassword extends JPanel {
    //    private JPanel this;
    private JLabel UpdatePassword;
    private JLabel oldPassword;
    private JTextField oldPasswordFiled;
    private JLabel NewPassword;
    private JTextField newPasswordField;
    private JLabel confirmPassword;
    private JTextField confirmPasswordField;
    private JButton confirmPasswordButton;
    private JButton backToMenuButton;

    public EmployeeUpdatePassword(Main mainFrame) {
        $$$setupUI$$$();
        backToMenuButton.addActionListener(e -> {
            mainFrame.showPanel("employeeMenu");
        });

        confirmPasswordButton.addActionListener(e -> {
            String oldPassword = oldPasswordFiled.getText();
            String newPassword = newPasswordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            if (Objects.equals(confirmPassword, newPassword) && Objects.equals(oldPassword, employee.getPassword())) {
                if(newPassword.length()==8){
//                    System.out.println(employee.getUsername());
                    int x = employee.updateEmployeePassword(employee.getUsername(), newPassword);
                    newPasswordField.setText("");
                    oldPasswordFiled.setText("");
                    confirmPasswordField.setText("");
                    System.out.println(oldPassword + " " + newPassword + " " + confirmPassword);
                    if (x == 1) {
                        JOptionPane.showMessageDialog(this, "Successfully updated !!!");
                        mainFrame.showPanel("employeeLogin");
                    } else {
                        JOptionPane.showMessageDialog(this, "Incorrect old password !");
                    }
                }else{
                    JOptionPane.showMessageDialog(this,"Password length must be of length 8 !");
                }
            } else {
                System.out.println(confirmPassword + " " + newPassword);
                JOptionPane.showMessageDialog(this, "Error !");
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
        this.setLayout(new GridLayoutManager(7, 7, new Insets(0, 0, 0, 0), -1, -1));
        this.setBackground(new Color(-9983750));
        oldPassword = new JLabel();
        Font oldPasswordFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, oldPassword.getFont());
        if (oldPasswordFont != null) oldPassword.setFont(oldPasswordFont);
        oldPassword.setForeground(new Color(-272410));
        oldPassword.setText("Old Password");
        this.add(oldPassword, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        confirmPassword = new JLabel();
        Font confirmPasswordFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, confirmPassword.getFont());
        if (confirmPasswordFont != null) confirmPassword.setFont(confirmPasswordFont);
        confirmPassword.setForeground(new Color(-272410));
        confirmPassword.setText("Confirm Password");
        this.add(confirmPassword, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newPasswordField = new JTextField();
        Font newPasswordFieldFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, newPasswordField.getFont());
        if (newPasswordFieldFont != null) newPasswordField.setFont(newPasswordFieldFont);
        newPasswordField.setForeground(new Color(-16777216));
        this.add(newPasswordField, new GridConstraints(3, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        confirmPasswordField = new JTextField();
        confirmPasswordField.setForeground(new Color(-16777216));
        this.add(confirmPasswordField, new GridConstraints(4, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        this.add(spacer1, new GridConstraints(5, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        this.add(spacer2, new GridConstraints(5, 5, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        confirmPasswordButton = new JButton();
        Font confirmPasswordButtonFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, confirmPasswordButton.getFont());
        if (confirmPasswordButtonFont != null) confirmPasswordButton.setFont(confirmPasswordButtonFont);
        confirmPasswordButton.setForeground(new Color(-16777216));
        confirmPasswordButton.setText("Confirm");
        this.add(confirmPasswordButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        oldPasswordFiled = new JTextField();
        Font oldPasswordFiledFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, oldPasswordFiled.getFont());
        if (oldPasswordFiledFont != null) oldPasswordFiled.setFont(oldPasswordFiledFont);
        oldPasswordFiled.setForeground(new Color(-16777216));
        this.add(oldPasswordFiled, new GridConstraints(2, 3, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer3 = new Spacer();
        this.add(spacer3, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        NewPassword = new JLabel();
        Font NewPasswordFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 18, NewPassword.getFont());
        if (NewPasswordFont != null) NewPassword.setFont(NewPasswordFont);
        NewPassword.setForeground(new Color(-272410));
        NewPassword.setText("New Password");
        this.add(NewPassword, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        this.add(spacer4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        UpdatePassword = new JLabel();
        Font UpdatePasswordFont = this.$$$getFont$$$("Serif", Font.BOLD | Font.ITALIC, 48, UpdatePassword.getFont());
        if (UpdatePasswordFont != null) UpdatePassword.setFont(UpdatePasswordFont);
        UpdatePassword.setForeground(new Color(-272410));
        UpdatePassword.setText("Update Password");
        this.add(UpdatePassword, new GridConstraints(1, 0, 1, 7, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        this.add(spacer5, new GridConstraints(0, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        this.add(spacer6, new GridConstraints(6, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        backToMenuButton = new JButton();
        backToMenuButton.setText("back to menu");
        this.add(backToMenuButton, new GridConstraints(5, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
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
