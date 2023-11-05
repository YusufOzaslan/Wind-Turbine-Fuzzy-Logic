package pkt;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

public class WindTurbine {
	private final FIS fis;
    private final double windSpeed;
    private final double height;
    private final double wingLength;
    
    public WindTurbine(double windSpeed,double height, double wingLength)throws URISyntaxException{
    	this.windSpeed = windSpeed;
        this.height=height;
        this.wingLength=wingLength;

        File file = new File(getClass().getResource("WindTurbine.fcl").toURI());        
        fis = FIS.load(file.getPath(),true);
        fis.setVariable("windSpeed", windSpeed);
        fis.setVariable("height", height);
        fis.setVariable("wingLength", wingLength);
        fis.evaluate();
    }
    public FIS getModel() {
    	return fis;
    }
    @Override
    public String toString() {
        String output = "Energy Produced : "+Math.round(fis.getVariable("energyProduced").getValue())+" kW/h";
        return output;
    } 
}
