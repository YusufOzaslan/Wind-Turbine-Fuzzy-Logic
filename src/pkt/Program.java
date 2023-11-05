package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("Wind Speed (0-25):");
        double windSpeed = 15; //in.nextDouble();
        System.out.print("Height (5-150):");
        double height = 55; //in.nextDouble();
        System.out.print("Wing Length (1-80):");
        double wingLength = 33; //in.nextDouble();
        
        try {
        	System.out.println("tets 1");
        	WindTurbine windTurbine = new WindTurbine(windSpeed, height, wingLength);
	        JFuzzyChart.get().chart(windTurbine.getModel());
	      //  for(Rule r:windTurbine.getModel().getFunctionBlock("energyProduced").getFuzzyRuleBlock("ruleBlock1").getRules()) {
	     //   	if (r.getDegreeOfSupport()>0) {
		//			System.out.println(r);// calistirilan kurallar yazilir. Bastaki degerler kuralin etki oranini verir
			//	} 
	       // } 

	        System.out.println(windTurbine);
	        //JFuzzyChart.get().chart(windTurbine.getModel().getVariable("energyProduced").getDefuzzifier(), "Energy Produced", true);
        }
        catch (URISyntaxException ex) {
        	System.out.println(ex.getMessage());
		}

	}

}
