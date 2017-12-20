package taxes;
import java.util.*;



public class TaxCalculations{

  boolean married;
  int wages;
  int homeInterest;
  int propertyTaxes;
  int stateTaxes;
  int otherDeductions;

  double deduction;
  double taxableIncome;
  double stdTaxLiability;

  double amti;
  double amtTaxLiability;
  boolean payingAmt;

  double taxesOwed;
  double effectiveTaxRate;

  TaxRef taxRef;

  public TaxCalculations(TaxRef taxRef, boolean married, int wages, int homeInterest, int propertyTaxes, int stateTaxes, int otherDeductions){
    this.taxRef = taxRef;
    this.married = married;
    this.wages = wages;
    this.homeInterest = homeInterest;
    this.propertyTaxes = propertyTaxes;
    this.stateTaxes = stateTaxes;
    this.otherDeductions = otherDeductions;

  }

  public void log(String s){
    System.out.println(s);
  }

  public void processTaxes(){
    taxableIncome = taxRef.getTaxableIncome(married, wages, homeInterest, propertyTaxes, stateTaxes,otherDeductions);
    deduction = taxRef.getDeduction();
    log("Taxable Income = "+taxableIncome);
    stdTaxLiability = getStdTaxLiability(taxableIncome,taxRef.getRateTable(married));
    log("stdTaxLiability = "+stdTaxLiability);
    processAMT();
    log("amtTaxLiability = "+amtTaxLiability);
    if (amtTaxLiability > stdTaxLiability){
      taxesOwed = amtTaxLiability;
      payingAmt = true;
    } else {
      taxesOwed = stdTaxLiability;
      payingAmt = false;
    }
    log("taxes Owed = "+taxesOwed);
    effectiveTaxRate = taxesOwed / wages;
    log("effective tax rate = "+effectiveTaxRate);
  }

  private void processAMT(){
    int amtwages = wages - homeInterest;
    int ex = taxRef.getAmtExemption(married);
    int threshold = taxRef.getAmtPhaseout(married);
    if (amtwages < threshold){
      //use all exemption
      amti = amtwages - ex;
    } else {
      //H1-H2-MAX((H8-0.25*((H1-H2)-H9)),0)
      if ((ex - .25 * (amtwages-threshold)) > 0 )
        amti = amtwages - (ex - .25 * (amtwages-threshold));
      else
        amti = amtwages;
    }
    //=IF(B24<187800,B24*0.26,187800*0.26+0.28*(B24-187800))
    if (amti < 187800){
      amtTaxLiability = .26 * amti;
    } else {
      amtTaxLiability = .26 * 187800 + .28 * (amti - 187800);
    }
  }

  private double getStdTaxLiability(double taxableIncome,Bracket[] rates){
    int i = 0;
    for (Bracket b : rates){
      if (taxableIncome < b.getLimit()){
        log("rate "+b.getRate());
        if (i!=0)
          return b.getBaseAmt() + b.getRate() * (taxableIncome-rates[i-1].getLimit());
        else
          return b.getRate() * taxableIncome;
      }
      i++;
    }
    return -1;
  }


  public double getDeduction() {
		return deduction;
	}
	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}
	public double getTaxableIncome() {
		return taxableIncome;
	}
	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public double getStdTaxLiability() {
		return stdTaxLiability;
	}
	public void setStdTaxLiability(double stdTaxLiability) {
		this.stdTaxLiability = stdTaxLiability;
	}
	public double getAmti() {
		return amti;
	}
	public void setAmti(double amti) {
		this.amti = amti;
	}
	public double getAmtTaxLiability() {
		return amtTaxLiability;
	}
	public void setAmtTaxLiability(double amtTaxLiability) {
		this.amtTaxLiability = amtTaxLiability;
	}
	public boolean isPayingAmt() {
		return payingAmt;
	}
	public void setPayingAmt(boolean payingAmt) {
		this.payingAmt = payingAmt;
	}
	public double getTaxesOwed() {
		return taxesOwed;
	}
	public void setTaxesOwed(double taxesOwed) {
		this.taxesOwed = taxesOwed;
	}
	public double getEffectiveTaxRate() {
		return effectiveTaxRate;
	}
	public void setEffectiveTaxRate(double effectiveTaxRate) {
		this.effectiveTaxRate = effectiveTaxRate;
	}



}
