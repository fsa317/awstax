package taxes;

import org.codehaus.jackson.map.ObjectMapper;

public class TestRun{


  public static void main(String[] args){
    int wages = 200000;
    int homeInterest = 15000;
    int propertyTaxes = 15000;
    int stateTaxes = 13000;
    int otherDeductions = 4000;
    boolean married = true;

    TaxRef17 tRef17 = new TaxRef17();
    TaxRef18 tRef18 = new TaxRef18();
    System.out.println("Old Taxes:");
    TaxCalculations t17 = new TaxCalculations(tRef17,married,wages,homeInterest,propertyTaxes,stateTaxes,otherDeductions);
    t17.processTaxes();
  

    System.out.println("\n\nNew Taxes:");
    TaxCalculations t18 = new TaxCalculations(tRef18,married,wages,homeInterest,propertyTaxes,stateTaxes,otherDeductions);
    t18.processTaxes();
  }

  public static String toJSON(TaxCalculations t){
    ObjectMapper mapperObj = new ObjectMapper();

    try {
        // get Employee object as a json string
        String jsonStr = mapperObj.writeValueAsString(t);
        return jsonStr;
      } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          return null;
      }
  }

}
