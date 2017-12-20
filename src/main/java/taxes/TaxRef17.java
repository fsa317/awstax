package taxes;

public class TaxRef17 implements TaxRef {

  static Bracket[] BRACKETS_MARRIED = { new Bracket(.1,18650,0),
                                 new Bracket(.15,75900,1865),
                                 new Bracket(.25,153100,10452.5),
                                 new Bracket(.28,233350,29752.5),
                                 new Bracket(.33,416700,52222.5),
                                 new Bracket(.35,470700,112728),
                                 new Bracket(.396,99999999,131628)
                               };

  static Bracket[] BRACKETS_SINGLE = { new Bracket(.1,9325,0),
                                  new Bracket(.15,37950,932.5),
                                  new Bracket(.25,91900,5226.25),
                                  new Bracket(.28,191650,18713.75),
                                  new Bracket(.33,416700,46643.75),
                                  new Bracket(.35,418400,120910.25),
                                  new Bracket(.396,99999999,121505.25)
                               };

   double deduction;

   public double getTaxableIncome(boolean married, int wages, int homeInterest, int propertyTaxes, int stateTaxes, int otherDeductions){
     int phase_threshold = 313800; //married
     if (!married)
        phase_threshold = 261500;
     int stdDed = this.getStandardDeduction(married);
     int itemDed = homeInterest + propertyTaxes + stateTaxes + otherDeductions;
     if (itemDed > stdDed){
       double phaseout = 0;  //PEASE limitation
       if (.03*(wages-phase_threshold)>0)
        phaseout = .03*(wages-phase_threshold);
       if (itemDed * .8 < phaseout)
        phaseout = itemDed *.8;
       System.out.println("phaseout for deductions "+phaseout);
       deduction = itemDed - phaseout;
     } else {
       deduction = stdDed;
     }
     return wages - deduction;
   }

  public int getStandardDeduction(boolean married){
    if (married)
      return 12700;
    else
      return 6350;
  }

  public  Bracket[] getRateTable(boolean married){
    if (married)
      return BRACKETS_MARRIED;
    else
      return BRACKETS_SINGLE;
  }

  public  int getAmtExemption(boolean married){
    if (married)
      return 84500;
    else
      return 54300;
  }

  public  int getAmtPhaseout(boolean married){
    if (married)
      return 160900;
    else
      return 120700;
  }

  public double getDeduction() { return deduction;}



}
