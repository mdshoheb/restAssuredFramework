package steps;

import utils.Configuration;
import utils.RestSteps;

public class PassengerEndpoint extends RestSteps{
	
	final String ENDPOINT =  "/v1/passenger";
	
	Configuration config = new Configuration();
	
	public PassengerEndpoint() {
		setBaseUrl(config.get("baseUrl"));
	}
	
	public void getPassenger() {
		sentAsGet(ENDPOINT);
	}
	
}
