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



public class Issue_page {
	public String issues_api()
	{
		String dyn;
		LocalDate today=LocalDate.now();
		String issName = "Serious Issue!";
		//String baseUrl = "https://app.gopazo.com/login";
		Date now = new Date();
		String time1 = now.toString();
		
		time1.substring(11); //Use this in case issue raising time should be present time.
		
		
		try
		{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost("https://beta.gopazo.com/api/v3/issues/add-issue");

		
		StringEntity input = new StringEntity("{\r\n   \r\n  "
				+ " \"apiKey\":\"$2a$10$m2p2kiQSN5xnSJIwkT5BUuvubHXrkw14rUhjCZRLKct26og0f4ay6\","
				+ "\r\n   \"issueTypeId\":\"5b169cc41edc08c272f661c3\","
				+ "\r\n   \"siteId\":\"5bf3e5be5087fb15036c6ee6\","
				+ "\r\n   \"locationCode\":\"5b1e174d1edc08c272f66fff\","
				+ "\r\n   \"departmentId\":\"5c88ee4513e51f2d1aabf14f\","
				+ "\r\n   \"customValues\":[\r\n   "
				+ "   {\r\n         \"_id\":\"issueName\","
				+ "\r\n         \"label\":\"Issue Name\","
				+ "\r\n         \"type\":\"text\","
				+ "\r\n         \"value\":\""+ issName + "\"\r\n      },"
				+ "\r\n      {\r\n         \"_id\":\"issuePics\","
				+ "\r\n         \"label\":\"Add photos of the Issue\","
				+ "\r\n         \"type\":\"picture\","
				+ "\r\n         \"value\":\"\"\r\n      },"
				+ "\r\n      {\r\n         \"_id\":\"dueDate\","
				+ "\r\n         \"label\":\"Due Date\","
				+ "\r\n         \"type\":\"datetime\","
				+ "\r\n         \"value\":\"2018-12-30T17:44:00.000+0530\"\r\n      }\r\n   ],"
				+ "\r\n   \"time\":\""
				+ today + "T00:04:59.056+0530\","
				+ "\r\n   \"deviceTime\":\"" + today	+ "T00:04:59.661+0530\","
				+ "\r\n   \"incidentLat\":\"0.0\","
				+ "\r\n   \"incidentLong\":\"0.0\","
				+ "\r\n   \"lac\":\"34022\","
				+ "\r\n   \"cid\":\"26379884\","
				+ "\r\n   \"mcc\":\"404\","
				+ "\r\n   \"mnc\":\"45\","
				+ "\r\n   \"version\":\"4.5.0.2\","
				+ "\r\n   \"assignedTo\":\"5c8b70cd7c6b246d1a7eadb6\"\r\n}");
		input.setContentType("application/json");
		postRequest.setEntity(input);

		HttpResponse response = httpClient.execute(postRequest);

		String result = EntityUtils.toString(response.getEntity());
		HttpEntity entity = response.getEntity(); 
	    InputStream instream = (InputStream) entity.getContent();

        JSONObject j = new JSONObject(result);
        dyn=j.getString("refId");
        
        System.out.println(" \n");
        Reporter.log("The issues id generated is:" +dyn,true);
        //System.out.println();
        System.out.println(j+"");

        instream.close();
        return(dyn);

	  } 
	catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  } catch (JSONException e) {
		e.printStackTrace();
	}
		return("null");		
		
	}
	


	public static void main(String [] args){
		

	
	Issue_page ip = new Issue_page();
	String issueID = ip.issues_api();
	String IssueName = issueID;
	System.out.println("The newly created issue ID is: " + issueID);	
	
	}}