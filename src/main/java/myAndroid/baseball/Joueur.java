package myAndroid.baseball;
import java.io.Serializable;
import java.util.List;

class Joueur implements Serializable{

	String name;
	int bStrike;
	int bOut;
	int bFly;
	int runF;
	int walk;
	int point;
	int pointOther;
	int homeRun;
	int nbb;
	
	public Joueur(String name, int bStrike,  int bOut, int bFly, int runF,int walk, int point, int pointOther,int homeRun,  int nbb){
		this.name=name;
		this.bStrike=bStrike;
		this.bOut=bOut;
		this.bFly=bFly;
		this.runF=runF;
		this.walk=walk;
		this.point=point;
		this.pointOther = pointOther;
		this.homeRun = homeRun;
		this.nbb=nbb;
	}
	
	public Joueur(String name){
		this.name = name;
		this.bStrike=bStrike;
		this.bOut=0;
		this.bFly=0;
		this.runF=0;
		this.walk=0;
		this.point=0;
		this.pointOther = 0;
		this.homeRun=0;
		this.nbb=0;
	}
	
	public boolean inList(List v){
	boolean answer = false;
	Joueur j;
	for(int i=0; i< v.size(); i++){
		if(v.get(i) instanceof Joueur){
			j=(Joueur) v.get(i);
			if(j.name.equals(this.name)){
				answer = true;
			}
		}
	}
	
	return answer;
	}
	
	public void update(int striket, int outt, int flyt, int runt, int walkt, int pointt, int pointOthert, int homeRunt, int nbbt){
		this.bStrike += striket;
		this.bOut += outt;
		this.bFly += flyt;
		this.runF += runt;
		this.walk += walkt;
		this.point += pointt;
		this.pointOther += pointOthert;
		this.homeRun += homeRunt;
		this.nbb += nbbt;
	}
	

}
