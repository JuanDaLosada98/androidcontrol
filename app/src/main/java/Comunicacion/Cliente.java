package Comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente extends Thread {

    Socket socket;
    int puerto;
    String ip;

    public Cliente(String ip, int puerto){
        this.ip=ip;
        this.puerto=puerto;

    }

    @Override
    public void run() {
        try {
            socket = new Socket(ip,puerto);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void enviar(final Mensaje m){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream salida = socket.getOutputStream();
                    ObjectOutputStream objSalida = new ObjectOutputStream(salida);
                    objSalida.writeObject(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
