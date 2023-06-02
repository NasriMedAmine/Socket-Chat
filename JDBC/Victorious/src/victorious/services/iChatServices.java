/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package victorious.services;

import java.util.ArrayList;
import victorious.entite.Chat;

/**
 *
 * @author farouk
 */
public interface iChatServices {
    public int ajouterChat(Chat p);
    public int modifierChat(Chat p); 
    public int supprimerChat(Chat p);
    public ArrayList<Chat> afficherChat();
    
}
