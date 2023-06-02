package other.mobile;

public class ClientWebSocket {


    private static ClientWebSocket clientWebSocket;


    private ClientWebSocket(){

    }

    public static ClientWebSocket getInstance(){
        if(clientWebSocket == null){
            return new ClientWebSocket();
        }
        return clientWebSocket;
    }
}
