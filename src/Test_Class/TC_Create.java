package Test_Class;

import Common_Method.API_Method_Create ;
import Common_Method.Common_Utility_Method;
import Repository.Post_Create ;
import io.restassured.path.json.JsonPath ;

import java.io.IOException;

import org.testng.Assert ;

public class TC_Create 
{
	public static void extract() throws IOException 
	{
		int StatusCode = API_Method_Create.StatusCode(Post_Create.baseURI(),Post_Create.Resource(),Post_Create.RequestBody()) ;
    
	    System.out.println(StatusCode);
    
	    String ResponseBody = API_Method_Create.ResponseBody(Post_Create.baseURI(),Post_Create.Resource(),Post_Create.RequestBody()) ;
	    System.out.println(ResponseBody);
	    
	    String RequestBody = Post_Create.RequestBody() ;
	    
	    Common_Utility_Method.EvidenceFileCreator("TC1", RequestBody, ResponseBody, StatusCode);
	    
		JsonPath jspres = new JsonPath(ResponseBody);
		String res_name = jspres.getString("name");
		String res_job = jspres.getString("job");
		 
	 	JsonPath jspreq = new JsonPath(RequestBody) ;   
		   String Req_name = jspreq.getString("name") ;
		   String Req_job = jspreq.getString("job") ; 
		
		 Assert.assertEquals(res_name,Req_name);
		 Assert.assertEquals(res_job,Req_job);
    }

}