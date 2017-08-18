package myAndroid.baseball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;
import android.widget.Toast;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.lang.String;

public class ListUserActivity extends Activity implements JoueurAdapterListener{

	List listP;

	public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.listuser);

	//recuperation du parametre
	Bundle extras = getIntent().getExtras();
	if(extras != null){
		//Toast.makeText(getApplicationContext(), extras.getString("activite"), Toast.LENGTH_SHORT).show();
	}

    //Récupération de la liste des personnes
    listP = readList();
		
	//Création et initialisation de l'Adapter pour les personnes
    JoueurAdapter adapter = new JoueurAdapter(this, listP);
    
    //Ecoute des évènements sur votre liste
    adapter.addListener(this);
        
    //Récupération du composant ListView
    ListView list = (ListView)findViewById(R.id.ListView01);
        
    //Initialisation de la liste avec les données
    list.setAdapter(adapter);
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
    	
    	
	public void onClickNom(Joueur item, int position) {
		//recuperation du parametre
		Bundle extras = getIntent().getExtras();
		final Joueur j = item;
		final Context context = this;
		final int pos = position;
		
		if(extras != null){
			String quoiFaire = extras.getString("activite");
			if(quoiFaire.equals("supprimer")){
				Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Attention");
							
				builder.setMessage("Voulez vous vraiment supprimer : " + item.name);
				builder.setPositiveButton("Oui",
					new DialogInterface.OnClickListener() {
						  public void onClick(DialogInterface dialog, int id) {
								listP.remove(j);
								writeList(listP);
								dialog.cancel();
								finish();
						  }
					 });
				builder.setNegativeButton("Non",
					new DialogInterface.OnClickListener() {
						  public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
								finish();
						  }
					 });
				builder.show();
			}
			else if(quoiFaire.equals("creer")){

				Intent intent = new Intent(context, CreateStatActivity.class);
				intent.putExtra("position", String.valueOf(pos));
                            startActivityForResult(intent,0);   
			}
			
			else if(quoiFaire.equals("voir")){

				Intent intent = new Intent(context, ViewStatActivity.class);
				intent.putExtra("position", String.valueOf(pos));
                            startActivityForResult(intent,0);   
			}
		}	
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(resultCode == 1000){
        //lorsque C se termine en appuyant sur le bouton d'accueil, on envoie le code indiquant à B de se terminer
        finish();
    }
}

}

