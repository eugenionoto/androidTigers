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
import java.lang.String;


public class ViewStatActivity extends Activity
{

	Button bOk,bCancel;
	List v;
	TextView tv;
	TextView tvStrikes, tvFrappe, tvFBase, tvFBaseSS, tvPointsSelfEquipe, tvPointsSelfBat, tvPointsOtherEquipe, tvWalks, tvHomeRun;
	Joueur courant;
	double points;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstat);
        
        double temp;
        
        Bundle extras = getIntent().getExtras();
        String posString = extras.getString("position");
        
        
        v = readList();
        
        points=0;
        for(int i=0; i<v.size();i++){
        	points += ((Joueur)v.get(i)).homeRun + ((Joueur)v.get(i)).point; 
        }
        
        courant = ((Joueur)v.get(Integer.parseInt(posString)));
        tv = (TextView) findViewById(R.id.textViewName);
        tv.setText(courant.name);
        
        //strikes
        tvStrikes = (TextView) findViewById(R.id.strikesValue);
        if(courant.nbb != 0){
		     temp=(double)(((double)courant.bStrike + (double)courant.bOut)/(double)courant.nbb);
		     if(String.valueOf(temp).length() >5){
	        		tvStrikes.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvStrikes.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvStrikes.setText("0.0");
        }
        
        //frappees
        tvFrappe = (TextView) findViewById(R.id.frappeValue);
        if(courant.nbb != 0){
		     temp=(double)(((double)courant.bFly + (double)courant.bOut + (double)courant.runF + (double)courant.homeRun)/(double)courant.nbb);
		     if(String.valueOf(temp).length() >5){
	        		tvFrappe.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvFrappe.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvFrappe.setText("0.0");
        }
        
        //1ere base atteinte
        tvFBase = (TextView) findViewById(R.id.fBaseValue);
        if(((double)courant.nbb+(double)courant.walk) != 0){
		     temp=(double)(((double)courant.runF + (double)courant.homeRun + (double)courant.walk)/((double)courant.nbb+(double)courant.walk));
		     if(String.valueOf(temp).length() >5){
	        		tvFBase.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvFBase.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvFBase.setText("0.0");
        }
        
        //1ere base atteinte sans strikes
        tvFBaseSS = (TextView) findViewById(R.id.fBaseSSValue);
        if(((double)courant.bFly + (double)courant.bOut + (double)courant.runF + (double)courant.homeRun) != 0){
		     temp=(double)(((double)courant.runF + (double)courant.homeRun + (double)courant.walk)/((double)courant.bFly + (double)courant.bOut + (double)courant.runF + (double)courant.homeRun));
		     if(String.valueOf(temp).length() >5){
	        		tvFBaseSS.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvFBaseSS.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvFBaseSS.setText("0.0");
        }
        
        //points marqués par moi / points equipe
        tvPointsSelfEquipe = (TextView) findViewById(R.id.pointsSelfEquipeValue);
        if(points != 0){
		     temp=(double)(((double)courant.point + (double)courant.homeRun)/points);
		     if(String.valueOf(temp).length() >5){
	        		tvPointsSelfEquipe.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvPointsSelfEquipe.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvPointsSelfEquipe.setText("0.0");
        }
        
        //points marqués par moi / arrivees en premiere abse
        tvPointsSelfBat = (TextView) findViewById(R.id.pointsSelfBatValue);
        if(((double)courant.runF + (double)courant.homeRun + (double)courant.walk) != 0){
		     temp=(double)(((double)courant.point + (double)courant.homeRun)/((double)courant.runF + (double)courant.homeRun + (double)courant.walk));
		     if(String.valueOf(temp).length() >5){
	        		tvPointsSelfBat.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvPointsSelfBat.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvPointsSelfBat.setText("0.0");
        }
        
        //points marqués sur mon tour de batte / points equipe
        tvPointsOtherEquipe = (TextView) findViewById(R.id.pointsOtherEquipeValue);
        if(points != 0){
		     temp=(double)(((double)courant.pointOther + (double)courant.homeRun)/points);
		     if(String.valueOf(temp).length() >5){
	        		tvPointsOtherEquipe.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvPointsOtherEquipe.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvPointsOtherEquipe.setText("0.0");
        }
        
         //walks
        tvWalks = (TextView) findViewById(R.id.walkValue);
        temp=courant.walk;
        if(temp != 0){

		     if(String.valueOf(temp).length() >5){
	        		tvWalks.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvWalks.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvWalks.setText("0.0");
        }
        
        //home run / battes
        tvHomeRun = (TextView) findViewById(R.id.homeRunValue);
        if(((double)courant.bFly + (double)courant.bOut + (double)courant.runF + (double)courant.homeRun) != 0){
		     temp=(((double)courant.homeRun/((double)courant.bFly + (double)courant.bOut + (double)courant.runF + (double)courant.homeRun)));
		     if(String.valueOf(temp).length() >5){
	        		tvHomeRun.setText(String.valueOf(temp).substring(0,5));
	        }
	        else{
	        		tvHomeRun.setText(String.valueOf(temp));
	        }
        }
        else{
        		tvHomeRun.setText("0.0");
        }

        addListenerOnButton();

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
		
		bOk = (Button) findViewById(R.id.buttonOk);
		bCancel = (Button) findViewById(R.id.buttonCancel);

		
		bOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
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
