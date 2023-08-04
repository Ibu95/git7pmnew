package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\ibu95\\eclipse-workspace2\\Mvn7pm\\src\\test\\resources\\Features",
                    glue = "stepdef", dryRun = false, monochrome= true, 
                    
        tags ="@chrome and not @seqlogin" ,
                    plugin= {"pretty", 
                    		"html:CucmberReports/cucmhtml.html",
                    		"json:CucmberReports/cucmjson.json",
                    		"junit:CucmberReports/cucmjunit.xml", 
                    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class FbRunner {
	private void addnew() {
		System.out.println("Changes in Runnerclass By shivin");
		
		
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j <5; j++) {
				
			}
		}
	}
}
