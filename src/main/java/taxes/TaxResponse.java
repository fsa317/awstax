package taxes;

public class TaxResponse{

  double savings;
  double owedTaxes17;
  double owedTaxes18;
  double effectiveRate17;
  double effectiveRate18;
  double taxableIncome17;
  double taxableIncome18;
  double stdTaxLiability17;
  double stdTaxLiability18;
  double amtTaxLiability17;
  double amtTaxLiability18;
  boolean payingAmt17;
  boolean payingAmt18;
  double deduction17;
  double deduction18;


  public double getSavings() {
       return this.savings;
    }

    /**
     * Sets the savings
     */
    public void setSavings(double value) {
       this.savings = value;
    }

    /**
     * Gets the owedTaxes17
     */
    public double getOwedTaxes17() {
       return this.owedTaxes17;
    }

    /**
     * Sets the owedTaxes17
     */
    public void setOwedTaxes17(double value) {
       this.owedTaxes17 = value;
    }

    /**
     * Gets the owedTaxes18
     */
    public double getOwedTaxes18() {
       return this.owedTaxes18;
    }

    /**
     * Sets the owedTaxes18
     */
    public void setOwedTaxes18(double value) {
       this.owedTaxes18 = value;
    }

    /**
     * Gets the effectiveRate17
     */
    public double getEffectiveRate17() {
       return this.effectiveRate17;
    }

    /**
     * Sets the effectiveRate17
     */
    public void setEffectiveRate17(double value) {
       this.effectiveRate17 = value;
    }

    /**
     * Gets the effectiveRate18
     */
    public double getEffectiveRate18() {
       return this.effectiveRate18;
    }

    /**
     * Sets the effectiveRate18
     */
    public void setEffectiveRate18(double value) {
       this.effectiveRate18 = value;
    }

    public double getTaxableIncome17() {
        return taxableIncome17;
    }
    public void setTaxableIncome17(double taxableIncome17) {
      this.taxableIncome17 = taxableIncome17;
    }
    public double getTaxableIncome18() {
      return taxableIncome18;
    }
    public void setTaxableIncome18(double taxableIncome18) {
      this.taxableIncome18 = taxableIncome18;
    }
    public double getStdTaxLiability17() {
      return stdTaxLiability17;
    }
    public void setStdTaxLiability17(double stdTaxLiability17) {
      this.stdTaxLiability17 = stdTaxLiability17;
    }
    public double getStdTaxLiability18() {
      return stdTaxLiability18;
    }
    public void setStdTaxLiability18(double stdTaxLiability18) {
      this.stdTaxLiability18 = stdTaxLiability18;
    }
    public double getAmtTaxLiability17() {
      return (amtTaxLiability17 > 0 ? amtTaxLiability17 : 0);
    }
    public void setAmtTaxLiability17(double amtTaxLiability17) {
      this.amtTaxLiability17 = amtTaxLiability17;
    }
    public double getAmtTaxLiability18() {
      return (amtTaxLiability18 > 0 ? amtTaxLiability18 : 0);
    }
    public void setAmtTaxLiability18(double amtTaxLiability18) {
      this.amtTaxLiability18 = amtTaxLiability18;
    }
    public boolean isPayingAmt17() {
      return payingAmt17;
    }
    public void setPayingAmt17(boolean payingAmt17) {
      this.payingAmt17 = payingAmt17;
    }
    public boolean isPayingAmt18() {
      return payingAmt18;
    }
    public void setPayingAmt18(boolean payingAmt18) {
      this.payingAmt18 = payingAmt18;
    }

    public double getDeduction17() {
    	return deduction17;
    }
    public void setDeduction17(double deduction17) {
    	this.deduction17 = deduction17;
    }
    public double getDeduction18() {
    	return deduction18;
    }
    public void setDeduction18(double deduction18) {
    	this.deduction18 = deduction18;
    }


}
