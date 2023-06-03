package DatabaseLogics;

import GYRM.AdminItems;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
public class play {
//    ##########################f**********
//    ##########################*
//    ________________________________
//    for testing purposes only
//    _________________________________
//    ****************################
//    #****************##################
    public static void main(String[] args) throws SQLException {
        Admin admin = new Admin("YeabsiraYonas", "12345678");
//        ArrayList<String[]> list = admin.viewItems();
//        System.out.println("size: " + list.size());
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(i).length; j++)
//                System.out.print((list.get(i)[j]) + " ");
//            System.out.println();
//        }


        StringBuilder builder = new StringBuilder("<html><table><thead><th>");
        builder.append("<th>Name</th><th>Type</th><th>ExpDate</th><th>Price</th><th>Amount</th></thead><tbody>");


        ArrayList<String[]> list;
        try {
            list = admin.viewItems();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("size: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                builder.append("<tr>");
                builder.append(list.get(i)[j]);
                builder.append("</tr>");
            }
        }
        builder.append("</tbody></tr></tbody></table></html>");
        System.out.println(builder);
    }
}
