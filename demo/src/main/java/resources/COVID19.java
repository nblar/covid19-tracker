package resources;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class COVID19 {
	HashMap<Object, Object> infy = new HashMap<Object, Object>();
	public HashMap<Object, Object> getInfy() {
		return infy;
	}

	public void setInfy(HashMap<Object, Object> infy) {
		this.infy = infy;
	}


	public void runfunction() {
		OkHttpClient client = new OkHttpClient();
		Request rqst = new Request.Builder().url("https://disease.sh/v2/all").get().build();
		

		try {
			Response response = client.newCall(rqst).execute();
			String data = response.body().string();
			JSONParser jsonParse = new JSONParser();

			JSONObject jsonObj = (JSONObject) jsonParse.parse(data);
			System.out.println("Total Cases : " + jsonObj.get("cases"));
			System.out.println("Total People Recovered : " + jsonObj.get("recovered").toString());
			System.out.println("Total Deaths : " + jsonObj.get("deaths"));
			System.out.println("People Critical : " + jsonObj.get("critical"));
			System.out.println("Population : " + jsonObj.get("population"));
			System.out.println("Cases Today : " + jsonObj.get("todayCases"));
			System.out.println("Affected Countries : " + jsonObj.get("affectedCountries"));
			
			 
			infy.put("TotalCases",jsonObj.get("cases").toString() );
			infy.put("TotalPeopleRecovered",jsonObj.get("recovered").toString() );
			infy.put("TotalDeaths",jsonObj.get("deaths").toString() );
			infy.put("PeopleCritical",jsonObj.get("critical").toString() );
			infy.put("Population",jsonObj.get("population").toString() );
			infy.put("CasesToday",jsonObj.get("todayCases").toString() );
			infy.put("AffectedCountries",jsonObj.get("affectedCountries").toString() );
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
