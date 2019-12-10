package kutt;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class api_handler 
{
	private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

	
	public String sendPost(String url,String curl,String pass,boolean r)
	{
		JSONObject json_raw=new JSONObject();
		json_raw.put("target", url);
		json_raw.put("customurl", curl);
		json_raw.put("password", pass);
		json_raw.put("reuse", r);
		
		String json=json_raw.toString();
		HttpResponse<String> response = null;
		
		try 
		{
			HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
					.uri(URI.create("https://kutt.it/api/url/submit")).header("Content-Type", "application/json")
					.header("x-api-key","WHGqtwXmE4ubZ7dBkOSTLNFhrfiIr_gcJKG1gFbo").build();
			
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(response.statusCode()==200)
		{
			return(response.body());
		}
		else
		{
			return("Error");
		}
	}	

}