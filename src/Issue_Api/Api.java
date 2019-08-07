package Issue_Api;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Api {
	public String login_api()
	{
		String dyn1;
		LocalDate today=LocalDate.now();
		String issName = "Serious Issue!";
		//String baseUrl = "https://app.gopazo.com/login";
		Date now = new Date();
		String time1 = now.toString();
		
		time1.substring(11); 
	try{
	HttpClient httpClient = HttpClientBuilder.create().build();
	HttpPost post11 = new HttpPost("https://beta.gopazo.com/api/v3/login");
	//new ("https://beta.gopazo.com/api/v3/login");

	StringEntity input1 = new StringEntity("{\"username\":\"6058\",\"pin\":\"1234\",\"overwrite\":\"1\",\"deviceId\":\"adsfasdf\"}");
			
	input1.setContentType("application/json");
	post11.setEntity(input1);
	//HttpResponse response =httpclient.
	HttpResponse response =httpClient.execute(post11);
	String result = EntityUtils.toString(response.getEntity());
	HttpEntity entity = response.getEntity(); 
    InputStream instream = (InputStream) entity.getContent();

   // String result = response.getContentString();
	//String result = EntityUtils.toString(response.getEntity());
	//HttpEntity entity = ((org.apache.http.HttpResponse) response).getEntity(); 
    //InputStream instream = (InputStream) result.

    		JSONObject j = new JSONObject(result);
    		/*Object fg= j.get("uid");
            dyn1 = fg.toString();*/
   String dyn11 = j.getString("uid");
    
    System.out.println(" \n");
    Reporter.log("The issues id generated is:" +dyn11,true);
    //System.out.println();
    System.out.println(j+"");

    instream.close();
    

  } 
catch (MalformedURLException e) {

	e.printStackTrace();

  } catch (IOException e) {

	e.printStackTrace();

  } catch (JSONException e) {
	e.printStackTrace();
}
	return null;
		
	
}
public static void main(String [] args){Api ap = new Api();
 String apitoken1= ap.login_api();
 
	String apitoken = apitoken1;
System.out.println("The newly created issue ID is: " + apitoken1);	

}}