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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo
 */
public class SocketListener extends Thread {

    private boolean _error;
    private final int _port;
    private final List<Printer> _printers;
    private int _qtdClients = 0;
    public final Object _sync = new Object();

    public SocketListener(int port, List<Printer> printers) {
        this._port = port;
        this._printers = printers;
    }

    public boolean getError() {
        return this._error;
    }

    public List<Printer> getPrinters() {
        return this._printers;
    }

    public void subtractClients() {
        synchronized (this._sync) {
            this._qtdClients--;
        }
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

                synchronized (this._sync) {
                    if (this._qtdClients >= 50) {
                        System.out.println("Nº máximo de conexões atingido...");

                        connected.close();

                        continue;
                    }
                }

                ClientManager cli = new ClientManager(this, connected);
                cli.start();

                this.sleep(5000);
            } catch (Exception ex) {
                Logger.getLogger(SocketListener.class.getName()).log(Level.SEVERE, null, ex);
                this._error = true;
            }
        }
    }
}
