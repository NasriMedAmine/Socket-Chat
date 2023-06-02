import java.sql.*;

public class Driver {
    private int id;  ;
    private static Driver instance = null;

    private Driver()
    {
        Connection conn = null;
        try {

            System.out.println("step1");
            String url = "jdbc:mysql://localhost:3306/Esprit_Pidev?characterEncoding=utf8";
            String user = "Pidev";
            String pwd = "azertyAZERTY123?";
            conn = DriverManager.getConnection(url,user,pwd);

            System.out.println("saayeee!");

//            Statement statement = conn.createStatement();
//            String query = "SELECT * FROM user";
//            ResultSet result = statement.executeQuery(query);
//            //statement.executeUpdate()
//            //Array list = result.getArray(1);
//            System.out.println("hne");
//            //System.out.println(list);
//            System.out.println(result);
////            System.out.println(result.getInt(1));
//            String sql = "";
//            PreparedStatement pres1 = conn.prepareStatement(sql);
//
//            while (result.next()){
//                System.out.println(result.getString(2));
//
//                /*System.out.println(result.last());*/
//            }


        } catch (SQLException e) {
            throw new Error("Problem", e);
        }

    }

    //    public final static Driver getInstance() {
    //
    //        if (Driver.instance == null) {
    //            // Le mot-clé synchronized sur ce bloc empêche toute instanciation
    //            // multiple même par différents "threads".
    //            // Il est TRES important.
    //            synchronized(Driver.class) {
    //                if (Driver.instance == null) {
    //
    //                    Driver.instance = new Driver();
    //                }
    //            }
    //        }
    //        return Driver.instance;
    //    }


    public static Driver getInstance(){
        if(instance == null ){
            instance = new Driver();
        }
        return instance;
    }






    public void change() {

        this.id++;


    }

    public void affich(){
        System.out.println(this.id);
    }
}
