import model.User;
import services.ServiceUser;

import java.sql.SQLException;
import java.util.Scanner;

public class MainBackup {
    public MainBackup() {
    }


    public void logIn() throws SQLException {
        System.out.println("---------------------------------------------------------");

        System.out.println("pseudo : \n");
        Scanner myScanner1 = new Scanner(System.in);

        String pseudo = myScanner1.nextLine();
        System.out.println("mot de passe : ");
        String  pwd = myScanner1.nextLine();
        ServiceUser serviceUser = new ServiceUser();
        User user1 = serviceUser.logIn(pseudo,pwd);
        System.out.println("login mawjoud w ahawa ");
        System.out.println(user1);

    }
}
