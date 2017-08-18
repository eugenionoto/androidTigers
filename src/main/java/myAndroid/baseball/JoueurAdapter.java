package myAndroid.baseball;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.BaseAdapter;
import java.util.List;
import java.util.ArrayList;

class JoueurAdapter extends BaseAdapter{

	List list;
	Context mContext;
	LayoutInflater mInflater;


	
	public JoueurAdapter(Context context, List aListP) {
	  mContext = context;
	  list = aListP;
	  mInflater = LayoutInflater.from(mContext);
	}
	
	public int getCount() {
  		return list.size();
	}
	
	
	public Object getItem(int position) {
	  return list.get(position);
	}

	public long getItemId(int position) {
	  return position;
	}

	
	public View getView(int position, View convertView, ViewGroup parent) {
	  LinearLayout layoutItem;

	  if (convertView == null) {
			layoutItem = (LinearLayout) mInflater.inflate(R.layout.joueurlayout, parent, false);
	  } 
	  else {
	  	layoutItem = (LinearLayout) convertView;
	  }
	  

	  TextView tv_Nom = (TextView)layoutItem.findViewById(R.id.TV_Nom);

		     

	  tv_Nom.setText(((Joueur)list.get(position)).name);
	  
	  
		  //On mémorise la position de la "Personne" dans le composant textview
	tv_Nom.setTag(position);
	//On ajoute un listener
	tv_Nom.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(View v) {
			//Lorsque l'on clique sur le nom, on récupère la position de la "Personne"
			Integer position = (Integer)v.getTag();
				
			//On prévient les listeners qu'il y a eu un clic sur le TextView "TV_Nom".
			sendListener(((Joueur)list.get(position)), position);
				
		}
		     	
	});
	  

	  //On retourne l'item créé.
	  return layoutItem;
	}

	private ArrayList<JoueurAdapterListener> mListListener = new ArrayList<JoueurAdapterListener>();
    public void addListener(JoueurAdapterListener aListener) {
    	mListListener.add(aListener);
    }
    private void sendListener(Joueur item, int position) {
    	for(int i = mListListener.size()-1; i >= 0; i--) {
    		mListListener.get(i).onClickNom(item, position);
    	}
    }
    


	
}


