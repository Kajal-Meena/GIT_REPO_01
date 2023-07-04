package Test_Class;

import java.io.IOException;
import org.testng.Assert;
import Common_Method.API_Method_Create_Retry_F;
import Repository.Post_Create_Retry_F;
import io.restassured.path.json.JsonPath;

public class TC_Create_Retry_F
{
	public static void extractor() throws IOException 
	{
		System.out.println("extractor method call");
		for(int i=0;i<5;i++) 
		{
		int StatusCode = API_Method_Create_Retry_F.StatusCode(Post_Create_Retry_F.baseURI(),Post_Create_Retry_F.Resource() ,
		                     Post_Create_Retry_F.RequestBody()) ;
		
		System.out.println(StatusCode);
		
		if(StatusCode==200) 
		{
		String ResponseBody = API_Method_Create_Retry_F.ResponseBody(Post_Create_Retry_F.baseURI(),Post_Create_Retry_F.Resource() ,
					          Post_Create_Retry_F.RequestBody()) ;
		
		System.out.println(ResponseBody);
			
		String RequestBody = Post_Create_Retry_F.RequestBody() ;
		
		Validator(RequestBody,ResponseBody);
		break;
		}
		else 
		{
		System.out.println("invalid statuscode");
		}
		}
	}
    public static void Validator(String RequestBody, String ResponseBody) 
    {
        System.out.println("validator method call");
        
        JsonPath jspres = new JsonPath (ResponseBody);
        
  		 String res_name = jspres.getString("name");
  		 String res_job = jspres.getString("job");
  		 String res_id = jspres.getString("id");
  		 
  		System.out.println(ResponseBody);
  		 
        JsonPath jspreq = new JsonPath (RequestBody);
  		
        String req_name = jspres.getString("name");
        String req_job = jspres.getString("job");
  		 
        System.out.println(RequestBody);
  		 
  		Assert.assertEquals(res_name,req_name);
  		Assert.assertEquals(res_job,req_job);
 
    }
}

	    