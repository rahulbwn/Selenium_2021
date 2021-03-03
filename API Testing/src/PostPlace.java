import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReuseableMethods;
public class PostPlace {

	public static void main(String[] args) {
		
		//Validate whether PostPlace API is working perfectly or not.
		//Post a Place => Update the Place => Get and Validate the update Place
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		//JsonPath js=new JsonPath(response); //Parse String into JSON. or
		JsonPath js=ReuseableMethods.rawtoJson(response);
		String PlaceId=js.getString("place_id");
		
		//Update the Place
		String NewAddress="70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+PlaceId+"\",\r\n"
				+ "\"address\":\""+NewAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json").
		then().log().all().assertThat().statusCode(200).header("Server", "Apache/2.4.18 (Ubuntu)").body("msg", equalTo("Address successfully updated"));

		//Validate Updated Address
	/*	given().log().all().queryParams("key","qaclick123","place_id",PlaceId)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).body("address", equalTo(NewAddress));   */ // Rest Assured way to validate. One More Alternate way is here
		
		String getResponse=given().log().all().queryParams("key","qaclick123","place_id",PlaceId)
		.when().get("maps/api/place/get/json")
		.then().log().all().statusCode(200).extract().response().asString();
		
		js=ReuseableMethods.rawtoJson(getResponse);
		String ActualAddress=js.getString("address");  // Need to use JUnit and TestNG methods to validate ActualAddress with NewAddress (Assertion)
		System.out.println(ActualAddress);
		Assert.assertEquals(ActualAddress, NewAddress);  //TestNG Method of performing validation.
	}

}