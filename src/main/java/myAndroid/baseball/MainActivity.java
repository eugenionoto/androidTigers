package myAndroid.baseball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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


public class MainActivity extends Activity
{

	Button bCStat,bVStat,bAdd,bRemove;
	List v;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
       //         Toast.makeText(getApplicationContext(), String.valueOf(v.size()), Toast.LENGTH_SHORT).show();
        addListenerOnButton();

    }
    
    public void onResume()
    {
        super.onResume();
        
        v = readList();
       
               // Toast.makeText(getApplicationContext(), String.valueOf(v.size()), Toast.LENGTH_SHORT).show();

    }
    
    
    
    public void writeList(Vector v){
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
    
    
		public void addListenerOnButton() {

		final Context context = this;

		bCStat = (Button) findViewById(R.id.buttonCreateStat);
		bVStat = (Button) findViewById(R.id.buttonViewStat);
		bAdd = (Button) findViewById(R.id.buttonAdd);
		bRemove = (Button) findViewById(R.id.buttonRemove);

		bCStat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			    Intent intent = new Intent(context, ListUserActivity.class);
			    intent.putExtra("activite","creer");
                            startActivity(intent);   

			}

		});
		bVStat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			    Intent intent = new Intent(context, ListUserActivity.class);
			    intent.putExtra("activite","voir");
                            startActivity(intent);   

			}

		});
		
		bAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			    Intent intent = new Intent(context, AddPlayerActivity.class);
                            startActivity(intent);   

			}

		});
		bRemove.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			    Intent intent = new Intent(context, ListUserActivity.class);
			    intent.putExtra("activite","supprimer");
                            startActivity(intent);   

			}

		});

	}
}
