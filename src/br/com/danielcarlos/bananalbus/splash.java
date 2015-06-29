package br.com.danielcarlos.bananalbus;

import br.dmwebdesign.bananalbus.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

public class splash extends Activity {
	private Thread msplashThread;
	private boolean clicou = false;
	
	
	/** Evento chamado quando a activity é executada pela primeira vez */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.splash);
    
        //thread para mostrar uma tela de Splash
        msplashThread = new Thread() {
            @Override
            public void run() {
             try {
                    synchronized(this){
                        //Espera por 5 segundos or sai quando
                     //o usuário tocar na tela
                        wait(5000);
                        clicou = true;
                    }
                }
                catch(InterruptedException ex){                    
                }
                 
                if (clicou){
                 //fechar a tela de Splash
                    finish();
                     
                 //Carrega a Activity Principal
                 Intent i = new Intent();
                 i.setClass(splash.this, MainActivity.class);
                 startActivity(i);
                }
            }
        };
         
        msplashThread.start();
    }
     
    @Override
    public void onPause()
    {
        super.onPause();
         
        //garante que quando o usuário clicar no botão
        //"Voltar" o sistema deve finalizar a thread
        msplashThread.interrupt();
    }
     
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //o método abaixo está relacionado a thread de splash
         synchronized(msplashThread){
          clicou = true;
           
             //o método abaixo finaliza o comando wait
             //mesmo que ele não tenha terminado sua espera
                msplashThread.notifyAll();
            }            
        }
        return true;
    }
 
	
}
