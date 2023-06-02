package other.SocketService;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * www.codeurjava.com
 */
public class Client {

    public static void main(String[] args) {

        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc = new Scanner(System.in);//pour lire à partir du clavier

        try {
            /*
             * les informations du serveur ( port et adresse IP ou nom d'hote
             * 127.0.0.1 est l'adresse local de la machine
             */
            clientSocket = new Socket("127.0.0.1",5000);

            //flux pour envoyer
            out = new PrintWriter(clientSocket.getOutputStream());


            // get the output stream from the socket.
            OutputStream outputStream = clientSocket.getOutputStream();
            // create an object output stream from the output stream so we can send an object through it
            ObjectOutputStream outObject = new ObjectOutputStream(outputStream);



            //flux pour recevoir
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread envoyer = new Thread(new Runnable() {
                String msg2;
                @Override
                public void run() {
                    while(true){

                        System.out.println("Id_user  :");
                        int id = sc.nextInt();
                        Map<String,String> messageMapHeader = new HashMap<>();
                        messageMapHeader.put("Function","header");

                        messageMapHeader.put("IdClient",Integer.toString(id));
                        System.out.println(messageMapHeader);
                        try {
                            outObject.writeObject(messageMapHeader);
                            System.out.println(messageMapHeader);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            envoyer.start();

            Thread recevoir = new Thread(new Runnable() {
                String msg;
                @Override
                public void run() {
                    try {
                        msg = in.readLine();
                        while(msg!=null){
                            System.out.println("Serveur : "+msg);
                            msg = in.readLine();
                        }
                        System.out.println("Serveur déconecté");
                        out.close();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            recevoir.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}