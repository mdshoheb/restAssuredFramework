package api.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.GetUsersEnpoint;

public class GetUserTest {
	
	GetUsersEnpoint getUsers;
	
	@BeforeMethod
	public void init() {
		getUsers = new GetUsersEnpoint();
	}
	
	@Test
	public void getuserTest() {
		getUsers.getUsers();
		getUsers.statusCodeValidation();
		getUsers.responseBodyValidation("data.email","byron.fields@reqres.in");
		getUsers.responseBodyValidation("data.first_name", "George");
	}

}
