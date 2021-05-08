/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class SocketListener extends Thread {

    private boolean _error;
    private final int _port;

    public SocketListener(int port) {
        this._port = port;
    }

    public boolean getError() {
        return this._error;
    }

    @Override
    public void run() {
        ServerSocket socket = null;
        DataInputStream inputStream = null;

        try {
            socket = new ServerSocket(this._port);
        } catch (IOException ex) {
            Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
            this._error = true;

            return;
        }

        while (!this._error) {
            try {
                Socket connected = socket.accept();
                inputStream = new DataInputStream(connected.getInputStream());

                System.out.println("Tag recebida: ");

                String content = inputStream.readUTF();

                System.out.println(content);

                this.sleep(5000);
            } catch (Exception ex) {
                Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
                this._error = true;
            }
        }

        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception ex) {
                Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
