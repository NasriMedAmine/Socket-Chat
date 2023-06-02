import java.sql.*;


public class ConnectionJDBC {

    public ConnectionJDBC(){
        Connection conn = null;
        try {

            System.out.println("step1");
            String url = "jdbc:mysql://localhost:3306/Esprit_Pidev?characterEncoding=utf8";
            String user = "Pidev";
            String pwd = "azertyAZERTY123?";
            conn = DriverManager.getConnection(url,user,pwd);

            System.out.println("saayeee!");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM user";
            ResultSet result = statement.executeQuery(query);
            //statement.executeUpdate()
            //Array list = result.getArray(1);
            System.out.println("hne");
            //System.out.println(list);
            System.out.println(result);
//            System.out.println(result.getInt(1));
            String sql = "";
            PreparedStatement pres1 = conn.prepareStatement(sql);

            while (result.next()){
                System.out.println(result.getString(2));

                /*System.out.println(result.last());*/
            }


        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
        finally {
            try {
                System.out.println("finaly");
                if (conn != null) {
                    System.out.println("besh nsaker saye");
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }




    /** Instance unique non préinitialisée */
    private static ConnectionJDBC INSTANCE = null;

    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized ConnectionJDBC getInstance()
    {
        if (INSTANCE == null)
        {   INSTANCE = new ConnectionJDBC();
        }
        return INSTANCE;
    }


    public void connecct(){
        Connection conn = null;
        try {

            System.out.println("step1");
            String url = "jdbc:mysql://localhost:3306/Esprit_Pidev?characterEncoding=utf8";
            String user = "Pidev";
            String pwd = "azertyAZERTY123?";
            conn = DriverManager.getConnection(url,user,pwd);

            System.out.println("saayeee!");
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM user";
            ResultSet result = statement.executeQuery(query);
            System.out.println(result);
//            System.out.println(result.getInt(1));
            while (result.next()){
                System.out.println(result.getString("nom"));
                /*System.out.println(result.last());*/
            }


        } catch (SQLException e) {
            throw new Error("Problem", e);
        }
        finally {
            try {
                System.out.println("finaly");
                if (conn != null) {
                    System.out.println("besh nsaker saye");
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
