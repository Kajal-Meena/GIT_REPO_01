package Common_Method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Utility_Method_Login_success 
{
	public static void EvidenceFile(String FileName , String RequestBody , String ResponseBody , int StatusCode ) throws IOException 
	{
		File TextFile = new File("F:\\REST  ASSURED\\EvidenceFileCreator\\" +FileName+".txt") ;
		System.out.println("A new blank text file : "+TextFile.getName()) ;
		
		FileWriter DataWrite = new FileWriter(TextFile) ;
		
		DataWrite.write("Request Body is : " + RequestBody + "\n\n") ;
		DataWrite.write("Response Body is : " + ResponseBody + "\n\n") ;
		DataWrite.write("Status Code is : " + StatusCode + "\n\n" ) ;
		
		DataWrite.close();
		
		System.out.println("Request Body and Response Body is written in textfile : " + TextFile.getName()) ;
	}
	
}
