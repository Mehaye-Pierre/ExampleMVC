package model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;

public class Calculator implements Observable{

	protected double result = 0;   
	  protected String operateur = "", operande = "";
	  private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	  
	  
	  public void setOperateur(String ope){    
	    calcul();
	    this.operateur = ope;
	    if(!ope.equals("=")){
	      this.operande = "";
	    }    
	  }

	  public void setNombre(String result){
	    this.operande += result;
	    notifyObserver(this.operande);
	  }

	  
	  public void getResultat() {
	    calcul();
	  }

	  public void reset(){
	    this.result = 0;
	    this.operande = "0";
	    this.operateur = "";
	    //update
	    notifyObserver(String.valueOf(this.result));
	  }

	  
	  public void calcul(){
	    //if there is no operator, result is the current value
	    if(this.operateur.equals("")){
	      this.result = Double.parseDouble(this.operande);
	    }
	    else{
	      //if not empty, do the maths
	      if(!this.operande.equals("")){
	        if(this.operateur.equals("+"))
	          this.result += Double.parseDouble(this.operande);
	        if(this.operateur.equals("-"))
	          this.result -= Double.parseDouble(this.operande);
	        if(this.operateur.equals("*"))
	          this.result *= Double.parseDouble(this.operande);          
	        if(this.operateur.equals("/")){
	          try{
	            this.result /= Double.parseDouble(this.operande);
	          }catch(ArithmeticException e){
	            this.result = 0;
	          }
	        }
	      }
	    }
	    this.operande = "";
	    //update
	    notifyObserver(String.valueOf(this.result));
	  }

	  public void addObserver(Observer obs) {
	    this.listObserver.add(obs);
	  }

	  public void notifyObserver(String str) {
	    if(str.matches("^0[0-9]+"))
	      str = str.substring(1, str.length());

	    for(Observer obs : listObserver)
	      obs.update(str);
	  }

	  public void removeObserver() {
	    listObserver = new ArrayList<Observer>();
	  }  
}
