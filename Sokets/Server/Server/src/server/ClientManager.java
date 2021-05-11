/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class ClientManager extends Thread {

    private final Socket _socket;
    private final SocketListener _listener;

    public ClientManager(SocketListener listener, Socket socket) {
        this._listener = listener;
        this._socket = socket;
    }

    @Override
    public void run() {
        try {
            Printer printer = null;
            while (printer == null) {
                synchronized (this._listener._sync) {
                    for (Printer p : this._listener.getPrinters()) {
                        if (!p.isPrinting()) {
                            p.setPrinting(true);
                            printer = p;
                            break;
                        }
                    }
                }
            }

            DataInputStream inputStream = new DataInputStream(this._socket.getInputStream());

            System.out.println("Impressora em uso -> IP: " + printer.getIp() + "; Nome: " + printer.getName());
            System.out.println("Tag recebida: ");

            String content = inputStream.readUTF();
            System.out.println(content);

            //reset...
            synchronized (this._listener._sync) {
                this._listener.subtractClients();
                printer.setPrinting(false);
            }

            this._socket.close();
        } catch (Exception ex) {
            Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
