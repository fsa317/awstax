package taxes;

public class Bracket{

  int limit;
  double rate;
  double baseAmt;

  public Bracket(double rate, int limit, double baseAmt){
    this.rate = rate;
    this.limit = limit;
    this.baseAmt = baseAmt;
  }

  public int getLimit(){ return limit; }
  public double getRate(){ return rate; }
  public double getBaseAmt() { return baseAmt; }
  
}
