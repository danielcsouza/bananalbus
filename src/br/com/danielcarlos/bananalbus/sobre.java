package br.com.danielcarlos.bananalbus;

import br.dmwebdesign.bananalbus.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class sobre  extends Activity{
	/** Evento chamado quando a activity é executada pela primeira vez */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.sobre);
    
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
             finish();
        }
        return true;
    }
    
}
