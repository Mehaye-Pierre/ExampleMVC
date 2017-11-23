import controler.CalculatorControler;
import model.Calculator;
import view.CalculatorView;

public class Main {

  public static void main(String[] args) {
    Calculator calc = new Calculator();
    CalculatorControler controler = new CalculatorControler(calc);
    CalculatorView calculette = new CalculatorView(controler);
    calc.addObserver(calculette);
  }
}
