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



public class kali {
	public String login1_api()
	{
		String dyn;
		LocalDate today=LocalDate.now();
		String issName = "Serious Issue!";
		//String baseUrl = "https://app.gopazo.com/login";
		Date now = new Date();
		String time1 = now.toString();
		System.out.println(today+"kjf");
		time1.substring(11); //Use this in case issue raising time should be present time.
		
		try
		{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost post11 = new HttpPost("https://beta.gopazo.com/api/v3/login");

		StringEntity input1 = new StringEntity("{\"username\":\"7777027702\",\"pin\":\"1234\",\"overwrite\":\"1\",\"deviceId\":\"adsfasdf\"}");
		input1.setContentType("application/json");
		post11.setEntity(input1);

		HttpResponse response = httpClient.execute(post11);

		String result = EntityUtils.toString(response.getEntity());
		HttpEntity entity = response.getEntity(); 
	    InputStream instream = (InputStream) entity.getContent();

        JSONObject j = new JSONObject(result);
        Object fg= j.get("name");
        dyn = fg.toString();
        //dyn=j.p("uid");
        
        
        System.out.println(" \n");
       // Reporter.log("The login name:" +dyn,true);
        System.out.println();
        //System.out.println(j+"");

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
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhuva\\Videos\\Selenium jars\\chromedriver.exe");
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("start-maximized");
		 WebDriver webdriver=new ChromeDriver(options1);
		WebDriver driver = new ChromeDriver();*/
		/* driver.get("https://beta.gopazo.com/login");
		   /* String str2=driver.getTitle();
		    System.out.println(str2);*/
		 /*   driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys("phase4test");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("phase4test");
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    driver.findElement(By.xpath("//span[contains(text(),'Change Site')]")).click();
		    driver.findElement(By.xpath("//span[contains(text(),'Beta_Yell')]")).click();
		    driver.findElement(By.xpath("//span[@class='nav-label text-capitalize'][contains(text(),'Issuess')]")).click();
		    driver.findElement(By.xpath("//span[contains(text(),'Raise a Issuee')]")).click();*/
		    

	
	kali ip = new kali();
	String loginid = ip.login1_api();
	String login = loginid;
	System.out.println("The login name is: " + loginid);	
	
	}}