/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Gustavo
 */
public class SoketSender {
    
    public void send(String code, int quantity, boolean fragile) throws IOException {
        Socket socket = new Socket("192.168.0.100", 5000);
        DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
        
        stream.writeUTF("## Tag  ");
        stream.writeUTF("**Código:** " + code + "  ");
        stream.writeUTF("**Quantidade:** " + quantity + "  ");
        stream.writeUTF("**Frágil:** " + (fragile ? "Sim" : "Não") + "  ");
        stream.flush();
    }
}
