//ReportJUnitResults.java
//By Matthew Heusser Matt@xndev.com
//Redistributed under Creative commons share-alike license
//https://creativecommons.org/licenses/by-sa/4.0/

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import org.json.simple.JSONObject;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class ReportJUnitResults {

	static String userid = "";
	static String pwd = ""; 
	static String baseurl = "";
	static String projectid = "1";
    static String testrunnamebase = "automation run";
    static String workingdir = "/Users/matthewheusser/Documents/workspace/Triangle_02/build";
    
	
	public static void main(String[] args)  {

			userid = System.getenv("TESTRAIL_USERNAME");
            pwd = System.getenv("TESTRAIL_PASSWORD");
            baseurl = System.getenv("TESTRAIL_URL");
            
            //create the test run
    		APIClient client = new APIClient(baseurl);
		    boolean bSuccess = false;
			//System.out.println("user is '" + userid + "'");
			//System.out.println("password is '" + pwd + "'");
		    //System.out.println("testrail url is '" + baseurl + "'");
		    client.setUser(userid);
			client.setPassword(pwd);

			
			try {
				
		
	  		   String test_run_id;
	  		   test_run_id = api_call_create_test_run(client);
			
	  		   System.out.println("Test Run Id " + test_run_id + " " + System.getProperty("user.dir"));
			
	  		   //Loop through the directory, finding test case runs and pushing them over the API
	  		   bSuccess = create_test_case_execution_records(client, test_run_id); 
	  		   
	  		   //Make run as complete
	  		   close_test_run(client, test_run_id);
			
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (APIException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if (bSuccess){
				System.exit(0);
			} else {
				System.exit(1);
			}
			
		}



	private static boolean create_test_case_execution_records(APIClient client, String test_run_id)
		throws IOException, APIException {
		   //Start off as true, can become false when a single test case fails
		   boolean bResult = true;
		   System.setProperty("user.dir", workingdir);
		   File dir = new File(workingdir);
		   File[] directoryListing = dir.listFiles();
		   if (directoryListing != null) {
			   for (File child : directoryListing) {
				   String test_case_id = get_test_case_id_from_filename(child);
				    if (test_case_id != "") {
				    	boolean bTestrun;
				        bTestrun = process_test_case_run(client, test_run_id, test_case_id, child);
                        //If the test case fails the entire run fails 
				        if (!bTestrun) {
		                   bResult = false;
		                }
			        }
			   } 
		   }
		   return bResult;
	}


    private static String get_test_case_id_from_filename(File child) {
    //returns "0" if it not a test case file, a number if it is
    	  if (child.getName().contains(".txt") && child.getName().contains("testResults")) {
    	      Pattern p = Pattern.compile("\\d+");
		      Matcher m = p.matcher(child.getName());
		      
		      if (m.find()) {
		    	  String test_case_number = m.group().toString();
		    	  System.out.println("Test CASE  Id " + test_case_number);
		    	  return test_case_number;
		      } else {
		    	  return "";
		      }
    	  } else {
    	      return "";
    	  }
    }

	private static boolean process_test_case_run(APIClient client, String test_run_id, String test_case_id, File child) throws IOException, APIException {
		  boolean bRunpassed = false;
		  

		  Path path = Paths.get(workingdir + "/" + child.getName());  
		  int status_id;
		  byte[] byteResults = java.nio.file.Files.readAllBytes(path);
		  String stringResults = new String (byteResults, StandardCharsets.UTF_8);
		  if ( stringResults.contains("\nOK (")) {
		      status_id = 1;
		      bRunpassed = true;
		  } else {
		      status_id = 5;
		      bRunpassed=  false;
		  }
		      	  	
		  api_call_add_test_case_run(client, test_run_id, test_case_id, status_id, stringResults);
		  System.out.println("FILE OUTPUT:\n" + stringResults + "\n");	      	  	
	      return bRunpassed;
	}
		




	private static void api_call_add_test_case_run(APIClient client, String test_run_id, String testcasenum, int status_id,
			String stringResults) throws MalformedURLException, IOException, APIException {
		JSONObject obj = new JSONObject();	
		obj.put("status_id", String.valueOf(status_id));
		obj.put("comment", stringResults);
		
		JSONObject r;
		String url = "add_result_for_case/"+test_run_id+"/"+testcasenum;
		System.out.println("Result of add_result call is " + url);		
		r = (JSONObject) client.sendPost(url, obj);

		String add_result_result = r.get("id").toString(); 
			
		System.out.println("Result of add_resut call is " + add_result_result);
		
	}
			
			

	private static String api_call_create_test_run(APIClient client) throws MalformedURLException, IOException, APIException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		
		String this_run = testrunnamebase + " " + dtf.format(now);
		String result = "";
		
		JSONObject obj = new JSONObject();	
		obj.put("name", this_run);
		JSONObject r;

			r = (JSONObject) client.sendPost("add_run/"+projectid, obj);
			result = r.get("id").toString(); 
			
			System.out.println("Calculated value is " + result);

		return result;

	}

	private static String close_test_run(APIClient client, String test_run_id) throws MalformedURLException, IOException, APIException {
		JSONObject obj = new JSONObject();	
		JSONObject r;

		r = (JSONObject) client.sendPost("close_run/"+test_run_id, obj);
		String result = r.toString(); 
			
		System.out.println("Resut of closing run is " + result);

		return result;
	}
}
