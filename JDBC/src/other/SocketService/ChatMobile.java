package other.SocketService;

public class ChatMobile {

    private int id ;
    private String message;

    public ChatMobile(int id, String message, int idUser) {
        this.id = id;
        this.message = message;
        this.idUser = idUser;
    }

    public ChatMobile(String message, int idUser) {
        this.message = message;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public ChatMobile() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    private int idUser;
}
