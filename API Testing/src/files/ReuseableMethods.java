package files;

import io.restassured.path.json.JsonPath;

public class ReuseableMethods {

	public static  JsonPath rawtoJson(String str_json)
	{
		JsonPath js=new JsonPath(str_json); //Parse String into JSON.
		return js;
	}
}
