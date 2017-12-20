package taxes;

public class TaxRequest{

  boolean married;
  int wages;
  int homeInterest;
  int propertyTaxes;
  int stateTaxes;
  int otherDeductions;
  String postalCode;

  /**
      * Gets the married
      */
     public boolean isMarried() {
        return this.married;
     }

     /**
      * Sets the married
      */
     public void setMarried(boolean value) {
        this.married = value;
     }

     /**
      * Gets the wages
      */
     public int getWages() {
        return this.wages;
     }

     /**
      * Sets the wages
      */
     public void setWages(int value) {
        this.wages = value;
     }

     /**
      * Gets the homeInterest
      */
     public int getHomeInterest() {
        return this.homeInterest;
     }

     /**
      * Sets the homeInterest
      */
     public void setHomeInterest(int value) {
        this.homeInterest = value;
     }

     /**
      * Gets the propertyTaxes
      */
     public int getPropertyTaxes() {
        return this.propertyTaxes;
     }

     /**
      * Sets the propertyTaxes
      */
     public void setPropertyTaxes(int value) {
        this.propertyTaxes = value;
     }

     /**
      * Gets the stateTaxes
      */
     public int getStateTaxes() {
        return this.stateTaxes;
     }

     /**
      * Sets the stateTaxes
      */
     public void setStateTaxes(int value) {
        this.stateTaxes = value;
     }

     /**
      * Gets the otherDeductions
      */
     public int getOtherDeductions() {
        return this.otherDeductions;
     }

     /**
      * Sets the otherDeductions
      */
     public void setOtherDeductions(int value) {
        this.otherDeductions = value;
     }

     /**
      * Gets the postalCode
      */
     public String getPostalCode() {
        return this.postalCode;
     }

     /**
      * Sets the postalCode
      */
     public void setPostalCode(String value) {
        this.postalCode = value;
     }

}
