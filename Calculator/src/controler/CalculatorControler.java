package controler;

import java.util.ArrayList;

import model.Calculator;

public class CalculatorControler {

	protected Calculator calc;
	protected String operateur = "", nbre = "";
	protected ArrayList<String> listOperateur = new ArrayList<String>();

	public CalculatorControler(Calculator cal){
		this.calc = cal;
		//List of accepted operators
		this.listOperateur.add("+");
		this.listOperateur.add("-");
		this.listOperateur.add("*");
		this.listOperateur.add("/");
		this.listOperateur.add("=");
	}

	public void setOperateur(String ope){
		this.operateur = ope;
		control();
	}

	public void setNombre(String nombre){
		this.nbre = nombre;
		control();
	}

	public void reset(){
		this.calc.reset();
	}
	
	public void control() {
		//if the operator is valid
	    if(this.listOperateur.contains(this.operateur)){
	      if(this.operateur.equals("="))
	        this.calc.getResultat();
	      else
	        this.calc.setOperateur(this.operateur);
	    }

	    //if the value is valid
	    if(this.nbre.matches("^[0-9.]+$"))
	      this.calc.setNombre(this.nbre);

	    this.operateur = "";
	    this.nbre = "";
	  }
}
