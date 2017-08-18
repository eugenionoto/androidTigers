package myAndroid.baseball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Vector;
import java.util.List;
import java.util.Collections;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import android.widget.Toast;

public class AddPlayerActivity extends Activity {

	Button buttonC, buttonO;
	EditText e;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addplayer);
		addListenerOnButton();
	}
	
	
	public void addListenerOnButton() {

		final Context context = this;

		buttonC = (Button) findViewById(R.id.buttonCancel);
		buttonO = (Button) findViewById(R.id.buttonOk);
		e = (EditText) findViewById(R.id.name);

		buttonC.setOnClickListener(new OnClickListener() {//bouton cancel

			@Override
			public void onClick(View arg0) {
				finish();
			}

		});
		
		buttonO.setOnClickListener(new OnClickListener() {//bouton ok

			@Override
			public void onClick(View arg0) {
				String nom = e.getText().toString();
				if(nom.isEmpty()){
					Toast.makeText(getApplicationContext(), "pas de nom entré", Toast.LENGTH_SHORT).show();
				}
				else{
					List v = readList();
					Joueur j = new Joueur(nom);
					if(j.inList(v)){
						Toast.makeText(getApplicationContext(), "Joueur deja existant", Toast.LENGTH_SHORT).show();
					}
					else{
						v.add(j);
						Collections.sort(v, new CompareJoueurs());
		     			writeList(v);

						finish();
					}
				}
			}

		});
	}
	
	public void writeList(List v){
    				 FileOutputStream fos;
                ObjectOutputStream oos=null;
                try{
                    fos = getApplicationContext().openFileOutput("Liste.txt", Context.MODE_PRIVATE);
                    oos = new ObjectOutputStream(fos);   
                    oos.writeObject(v);
                    oos.close();
                }catch(Exception e){            

                }
                finally{
                    if(oos!=null)
                        try{
                            oos.close();
                        }catch(Exception e){
                        }
                }
    }
	
	public List readList(){
    		List v = null;
    		File fichier =  getApplicationContext().getFileStreamPath("Liste.txt");
    		
    		if(fichier.exists()){
            FileInputStream fin;
            ObjectInputStream ois=null;
            try{
                fin = getApplicationContext().openFileInput("Liste.txt");
                ois = new ObjectInputStream(fin);   
                v = (Vector) ois.readObject();
                ois.close();
  
                }catch(Exception e){

                }
            finally{
                if(ois!=null)
                    try{
                        ois.close();
                    }catch(Exception e){
                    }
            }
    		}
    		else{
    		 v= new Vector();
    		}
    		
    		return v;
    	}

}
