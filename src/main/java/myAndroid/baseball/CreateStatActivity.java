package myAndroid.baseball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
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
import java.lang.Integer;


public class CreateStatActivity extends Activity
{

	Button bStrike,bOut,bFly,bRun,bWalk,bPoint,bPointOther,bHomeRun,bOk,bCancel;
	List v;
	TextView tv;
	Joueur courant;
	int bStrikeTemp;
	int bOutTemp;
	int bFlyTemp;
	int runFTemp;
	int walkTemp;
	int pointTemp;
	int pointOtherTemp;
	int homeRunTemp;
	int nbbTemp;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createstat);
        
        Bundle extras = getIntent().getExtras();
        String posString = extras.getString("position");
        
        	bStrikeTemp=0;
			bOutTemp=0;
			bFlyTemp=0;
			runFTemp=0;
			walkTemp=0;
			pointTemp=0;
			pointOtherTemp=0;
			homeRunTemp=0;
			nbbTemp =0;	
        
        v = readList();
        
        courant = ((Joueur)v.get(Integer.parseInt(posString)));
        tv = (TextView) findViewById(R.id.textViewName);
        tv.setText(courant.name);
        
       //         Toast.makeText(getApplicationContext(), String.valueOf(v.size()), Toast.LENGTH_SHORT).show();
        addListenerOnButton();

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
    
    
		public void addListenerOnButton() {

		final Context context = this;


		bStrike = (Button) findViewById(R.id.buttonStrike);
		bOut = (Button) findViewById(R.id.buttonOut);
		bFly = (Button) findViewById(R.id.buttonFly);
		bRun = (Button) findViewById(R.id.buttonRun);
		bWalk = (Button) findViewById(R.id.buttonWalk);
		bPoint = (Button) findViewById(R.id.buttonPoint);
		bPointOther = (Button) findViewById(R.id.buttonPointOther);
		bHomeRun = (Button) findViewById(R.id.buttonHomeRun);
		bOk = (Button) findViewById(R.id.buttonOk);
		bCancel = (Button) findViewById(R.id.buttonCancel);

		bStrike.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			bStrikeTemp++;
			nbbTemp++;   

			}

		});
		bOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			bOutTemp++;
			nbbTemp++;  

			}

		});
		
		bFly.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			bFlyTemp++;  
			nbbTemp++;
			
			}

		});
		bRun.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			runFTemp++;
			nbbTemp++;   

			}

		});
		
		bWalk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			walkTemp++;

			}

		});
		
		bPoint.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			pointTemp++;
			}

		});
		
		bPointOther.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			pointOtherTemp++;
			}

		});
		
		bHomeRun.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			homeRunTemp++;
			nbbTemp++;   

			}

		});
		
		bOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			courant.update(bStrikeTemp,bOutTemp,bFlyTemp,runFTemp,walkTemp, pointTemp, pointOtherTemp,homeRunTemp,nbbTemp);
			writeList(v);
			Toast.makeText(getApplicationContext(), "Données enregistrées", Toast.LENGTH_SHORT).show();
			setResult(1000);
			finish();   

			}

		});
		
		bCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

			finish(); 

			}

		});

	}
}
