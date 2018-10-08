package com.example.estudiante.control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Comunicacion.Cliente;
import Comunicacion.Mensaje;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    Cliente cliente;
    Mensaje mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText e;
        //String ip = e.getText();


        cliente = new Cliente("192.168.1.68", 5000);
        cliente.start();
        mensaje = new Mensaje();
        Button a = findViewById(R.id.attack);
        Button b = findViewById(R.id.left);
        Button c = findViewById(R.id.right);

        a.setOnTouchListener(this);
        b.setOnTouchListener(this);
        c.setOnTouchListener(this);
    }


    public void accion(View view){
        switch (view.getId()){
            case R.id.right:

                mensaje.RIGHT = true;
                cliente.enviar(mensaje);

                break;

            case R.id.left:

                mensaje.LEFT = true;
                cliente.enviar(mensaje);

                break;

            case R.id.attack:

                mensaje.ATTACK = true;
                cliente.enviar(mensaje);
                break;

        }
    }

    public void accionRealesed(View view){
        switch (view.getId()){
            case R.id.right:

                mensaje.RIGHT = false;
                cliente.enviar(mensaje);

                break;

            case R.id.left:

                mensaje.LEFT = false;
                cliente.enviar(mensaje);

                break;

            case R.id.attack:

                mensaje.ATTACK = false;
                cliente.enviar(mensaje);
                break;


        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            accion(view);

        } else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
            accionRealesed(view);
        }
        return false;
    }
}
