package GYRM;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;

    public Main() {
        setTitle("YY PHARMACY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1350, 900);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        FirstPage firstPage = new FirstPage(this);
        AdminItems adminItems = new AdminItems(this);
        AdminEmployee adminEmployee = new AdminEmployee(this);
        AdminSales adminSales = new AdminSales(this);
        AdminRemovalsTable adminRemovalsTable = new AdminRemovalsTable(this);
        AdminLogin adminLogin = new AdminLogin(this);
        EmployeeLogin employeeLogin = new EmployeeLogin(this);
        AdminMenu adminMenu = new AdminMenu(this);
        EmployeeMenu employeeMenu = new EmployeeMenu(this);
        EmployeeUpdatePassword employeeUpdatePassword = new EmployeeUpdatePassword(this);
        EmployeeUpdateUserName employeeUpdateUserName = new EmployeeUpdateUserName(this);
        EmployeeSellItem employeeSellItem = new EmployeeSellItem(this);

        try {
            cards.add(firstPage.$$$getRootComponent$$$(), "firstPage");
            cards.add(adminLogin.$$$getRootComponent$$$(), "adminLogin");
            cards.add(adminMenu.$$$getRootComponent$$$(), "adminMenu");
            cards.add(adminItems.$$$getRootComponent$$$(), "adminItems");
            cards.add(adminEmployee.$$$getRootComponent$$$(), "adminEmployee");
            cards.add(adminSales.$$$getRootComponent$$$(), "adminSales");
            cards.add(adminRemovalsTable.$$$getRootComponent$$$(), "adminRemovalsTable");
            cards.add(employeeLogin.$$$getRootComponent$$$(), "employeeLogin");
            cards.add(employeeMenu.$$$getRootComponent$$$(), "employeeMenu");
            cards.add(employeeUpdateUserName.$$$getRootComponent$$$(), "employeeUpdateUserName");
            cards.add(employeeUpdatePassword.$$$getRootComponent$$$(), "employeeUpdatePassword");
            cards.add(employeeSellItem.$$$getRootComponent$$$(), "employeeSellItem");
        } catch (Exception e) {
            System.out.println("First exception");
        }
        getContentPane().add(cards);
        try {
            cardLayout.show(cards, "firstPage");
            this.setVisible(true);
        } catch (Exception e) {
            System.out.println("Second exception");
        }
    }

    public void showPanel(String panelName) {
        cardLayout.show(cards, panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
        });
    }
}