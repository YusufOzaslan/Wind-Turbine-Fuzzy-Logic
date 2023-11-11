package pkt;

import java.net.URISyntaxException;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;

public class Program {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        System.out.print("Wind Speed in m/s(0-25): ");
        double windSpeed = in.nextDouble();
        
        System.out.print("\rWing Length in meters (1-80):");
        double wingLength = in.nextDouble();

        double max = wingLength*(10/2);
        double min = wingLength*(10/4);
        
        System.out.print("\rHeight in meters (" + Math.round(max) + "-" + Math.round(min) + "): ");
        double height = in.nextDouble();
        
        while (height < min || height > max) {
        	System.out.print("\rHeight in meters (" + Math.round(max) + "-" + Math.round(min) + "): ");
        	height = in.nextDouble();
		}
        
        try {
        	WindTurbine windTurbine = new WindTurbine(windSpeed, height, wingLength);
	        JFuzzyChart.get().chart(windTurbine.getModel());
	        for(Rule r:windTurbine.getModel().getFunctionBlock("WindTurbine").getFuzzyRuleBlock("ruleBlock1").getRules()) {
	        	if (r.getDegreeOfSupport()>0) {
					System.out.println(r);// calistirilan kurallar yazilir. Bastaki degerler kuralin etki oranini verir
				} 
	        } 

	        System.out.println(windTurbine);
	        JFuzzyChart.get().chart(windTurbine.getModel().getVariable("energyProduced").getDefuzzifier(), "Energy Produced", true);
        }
        catch (URISyntaxException ex) {
        	System.out.println(ex.getMessage());
		}

	}

}
