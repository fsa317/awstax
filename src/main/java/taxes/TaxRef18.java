package taxes;

public class TaxRef18 implements TaxRef{


    static Bracket[] BRACKETS_MARRIED = { new Bracket(.1,19050,0),
                                   new Bracket(.12,77400,1905),
                                   new Bracket(.22,165000,8907),
                                   new Bracket(.24,315000,28179),
                                   new Bracket(.32,400000,64179),
                                   new Bracket(.35,600000,91379),
                                   new Bracket(.37,99999999,161379)
                                 };

    static Bracket[] BRACKETS_SINGLE = { new Bracket(.1,9525,0),
                                    new Bracket(.12,38700,952.50),
                                    new Bracket(.22,82500,4453.50),
                                    new Bracket(.24,157500,14089.50),
                                    new Bracket(.32,200000,32089.50),
                                    new Bracket(.35,500000, 45689.50),
                                    new Bracket(.37,99999999,150689.50)
                                 };

     double deduction;

     public double getTaxableIncome(boolean married, int wages, int homeInterest, int propertyTaxes, int stateTaxes, int otherDeductions){
       int stdDed = this.getStandardDeduction(married);
       int itemDed = homeInterest + otherDeductions;
       int salt = propertyTaxes + stateTaxes;
       if (salt>10000)
          salt = 10000;
       itemDed += salt;
       if (itemDed > stdDed){
         deduction = itemDed;
       } else {
         deduction = stdDed;
       }
       return wages - deduction;
     }

    public int getStandardDeduction(boolean married){
      if (married)
        return 24000;
      else
        return 12000;
    }

    public  Bracket[] getRateTable(boolean married){
      if (married)
        return BRACKETS_MARRIED;
      else
        return BRACKETS_SINGLE;
    }

    public  int getAmtExemption(boolean married){
      if (married)
        return 109400;
      else
        return 70300;
    }

    public  int getAmtPhaseout(boolean married){
      if (married)
        return 1000000;
      else
        return 500000;
    }

    public double getDeduction() { return deduction;}


}
