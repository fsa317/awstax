package taxes;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class TaxHandler implements RequestHandler<TaxRequest, TaxResponse>{

  public TaxResponse handleRequest(TaxRequest request, Context context){
        System.out.println("NEW REQUEST - wages "+request.getWages());
        System.out.println("Interest "+request.getHomeInterest());
        int wages = request.getWages();
        int homeInterest = request.getHomeInterest();
        int propertyTaxes = request.getPropertyTaxes();
        int stateTaxes = request.getStateTaxes();
        int otherDeductions = request.getOtherDeductions();
        boolean married = request.isMarried();

        TaxRef17 tRef17 = new TaxRef17();
        TaxRef18 tRef18 = new TaxRef18();
        System.out.println("Old Taxes:");
        TaxCalculations t17 = new TaxCalculations(tRef17,married,wages,homeInterest,propertyTaxes,stateTaxes,otherDeductions);
        t17.processTaxes();

        System.out.println("\n\nNew Taxes:");
        TaxCalculations t18 = new TaxCalculations(tRef18,married,wages,homeInterest,propertyTaxes,stateTaxes,otherDeductions);
        t18.processTaxes();

        TaxResponse response = new TaxResponse();
        response.setOwedTaxes17(t17.getTaxesOwed());
        response.setOwedTaxes18(t18.getTaxesOwed());
        response.setEffectiveRate17(t17.getEffectiveTaxRate());
        response.setEffectiveRate18(t18.getEffectiveTaxRate());
        response.setSavings(t17.getTaxesOwed() - t18.getTaxesOwed());
        response.setTaxableIncome17(t17.getTaxableIncome());
        response.setStdTaxLiability17(t17.getStdTaxLiability());
        response.setAmtTaxLiability17(t17.getAmtTaxLiability());
        response.setPayingAmt17(t17.isPayingAmt());
        response.setDeduction17(t17.getDeduction());
        response.setTaxableIncome18(t18.getTaxableIncome());
        response.setStdTaxLiability18(t18.getStdTaxLiability());
        response.setAmtTaxLiability18(t18.getAmtTaxLiability());
        response.setPayingAmt18(t18.isPayingAmt());
        response.setDeduction18(t18.getDeduction());



        TaxCompObj tObj = new TaxCompObj(request,response);


        try {
          System.out.println("Setting up dynamo db");
          AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
          DynamoDBMapper mapper = new DynamoDBMapper(client);
          System.out.println("Saving object");
          mapper.save(tObj);
        } catch (Exception e){
          System.out.println("Error saving object");
          e.printStackTrace();
        }

        return response;
  }

}
