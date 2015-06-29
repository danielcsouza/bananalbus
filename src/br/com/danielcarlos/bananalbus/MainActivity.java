package br.com.danielcarlos.bananalbus;



import br.dmwebdesign.bananalbus.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

	public ListView lista, listabn;
	public TabHost tabhost; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE); 
		  setContentView(R.layout.activity_main);
		
	  
	    
		tabhost =(TabHost)findViewById(R.id.tabGeral);
		tabhost.setup();
		
		
		TabSpec spec1 = tabhost.newTabSpec("Barra Mansa/Bananal");
		spec1.setContent(R.id.tab_bm);
		spec1.setIndicator("Barra Mansa/Bananal",getResources().getDrawable(android.R.drawable.alert_dark_frame));
	
		
		
		TabSpec spec2 = tabhost.newTabSpec("Bananal/Barra Mansa");
		spec2.setContent(R.id.tab_bn);
		spec2.setIndicator("Bananal/Barra Mansa",getResources().getDrawable(android.R.drawable.alert_light_frame));
		
	
		tabhost.addTab(spec1);
		tabhost.addTab(spec2);	

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,horBM);
		
		ArrayAdapter<String> adapterBN = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,horBN);
		
		lista = (ListView)findViewById(R.id.lstBM);
		lista.setAdapter(adapter);
				
		lista.setClickable(true);
		
		lista.setOnItemClickListener(new OnItemClickListener(){ 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{ 		
				
				Object selection = (Object) arg0.getItemAtPosition(arg2);
				
				if (selection.toString().contains("*"))
				{
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this); 
					dialogo.setTitle("Horário selecionado");
					dialogo.setMessage(selection.toString()+ "\n Nos domingos e feriados não tem este horário!"); 
					dialogo.setNeutralButton("OK", null); 
					dialogo.show(); 
				}
				else
				{
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this); 
					dialogo.setTitle("Horário selecionado");
					dialogo.setMessage(selection.toString()); 
					dialogo.setNeutralButton("OK", null); 
					dialogo.show(); 
					
				}

			}
		});
		
		
		listabn = (ListView)findViewById(R.id.lstBN);
		listabn.setAdapter(adapterBN);
				
		listabn.setClickable(true);
		
		listabn.setOnItemClickListener(new OnItemClickListener(){ 
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3)
			{ 		
				
				Object selection = (Object) arg0.getItemAtPosition(arg2);
				if (selection.toString().contains("*"))
				{
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this); 
					dialogo.setTitle("Horário selecionado");
					dialogo.setMessage(selection.toString()+ "\n Nos domingos e feriados não tem este horário!"); 
					dialogo.setNeutralButton("OK", null); 
					dialogo.show(); 
				}
				else
				{
					AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this); 
					dialogo.setTitle("Horário selecionado");
					dialogo.setMessage(selection.toString()); 
					dialogo.setNeutralButton("OK", null); 
					dialogo.show(); 
					
				}


			}
		});
		
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == R.id.action_settings)
		{
	          
	      Intent pagina = new Intent(this,sobre.class);
	      startActivity(pagina);	
	    }
		return false;
	}
	
	static final String[] horBM = new String[] { 
		"06:10 - Cotiara*","07:00 - Rancho Grande","07:10 - Cotiara","08:10 - Cotiara*",
		"09:40 - Cotiara","10:20 - Rancho Grande","11:30 - Cotiara","13:00 - Rancho Grande",
		"13:20 - Cotiara","15:20 - Cotiara","17:10 - Rancho Grande","17:20 Cotiara",
		"18:50 - Cotiara","20:00 - Rancho Grande"
		}; 

	static final String[] horBN = new String[] { 
		"05:40 - Rancho Grande","06:00 - Cotiara","07:00 - Cotiara*","08:00 - Cotiara",
		"08:20 - Rancho Grande","09:00 - Cotiara*","10:40 - Cotiara","11:40 - Rancho Grande",
		"12:20 - Cotiara","14:20 - Cotiara","15:00 - Cotiara","15:00 - Rancho Grande","16:10 - Cotiara","18:10 - Cotiara",
		"18:40 - Rancho Grande"
		}; 

	
}

