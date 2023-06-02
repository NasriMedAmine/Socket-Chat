package other.mobile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ConnexionSocket {
    static Socket clientSocket;
    static BufferedReader in;
    static PrintWriter out;
    static Scanner sc = new Scanner(System.in);//pour lire à partir du clavier
    static ConnexionSocket myInstanceMyConnexionSocket;

    private ConnexionSocket(){
        try {
            clientSocket = new Socket("127.0.0.1",5000);
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



        } catch (Exception e) {
            System.out.println("problem niveau instance Connextion Socket");
        }
    }
    public ConnexionSocket getInstanceMyConnexionSocket(){
        if( myInstanceMyConnexionSocket == null ){
            ConnexionSocket myInstanceMyConnexionSocket = new ConnexionSocket();
        }
        return myInstanceMyConnexionSocket;
    }


}
