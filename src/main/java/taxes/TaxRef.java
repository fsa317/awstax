package taxes;

public interface TaxRef {

  public double getTaxableIncome(boolean married, int wages, int homeInterest, int propertyTaxes, int stateTaxes, int otherDeductions);
  public int getStandardDeduction(boolean married);
  public  Bracket[] getRateTable(boolean married);
  public  int getAmtExemption(boolean married);
  public  int getAmtPhaseout(boolean married);
  public double getDeduction();

}
