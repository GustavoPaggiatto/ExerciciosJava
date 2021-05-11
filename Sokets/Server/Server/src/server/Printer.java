/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Gustavo
 */
public class Printer {

    private String _ip;
    private String _name;
    private boolean _printing;

    public Printer(String ip, String name) {
        this._ip = ip;
        this._name = name;
        this._printing = false;
    }

    public String getIp() {
        return _ip;
    }

    public void setIp(String _ip) {
        this._ip = _ip;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public boolean isPrinting() {
        return _printing;
    }

    public void setPrinting(boolean _printting) {
        this._printing = _printting;
    }
}
