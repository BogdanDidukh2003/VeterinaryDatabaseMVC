package ua.iot.lviv;

import ua.iot.lviv.persistence.ConnectionManager;
import ua.iot.lviv.view.MyView;

public class Main {

    public static void main(final String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            new MyView().show();
        } catch (ClassNotFoundException ex) {
            System.out.println("MySql Driver is not loaded");
        } finally {
            ConnectionManager.closeSession();
            ConnectionManager.closeSessionFactory();
            System.out.println("Good Bye!");
        }
    }
}
