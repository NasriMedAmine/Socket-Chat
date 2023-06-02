//package other.SocketService;
//
//import model.Tournament;
//import model.User;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MessageSocket implements Serializable {
//    public MessageSocket() {
//    }
//
//
//    public Map<String,Object> getMessageHeader(User user , Tournament tournament){
//        Map<String,Object> messageMapHeader = new HashMap<>();
//        messageMapHeader.put("Function","header");
//
//        messageMapHeader.put("IdClient",Integer.toString(user.getId_user()));
//        messageMapHeader.put("IdGroup" ,Integer.toString(tournament.getId_Managers()));
//
//    }
//}
