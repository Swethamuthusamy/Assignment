package maven_demos.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class GetLinkStatus {

	static int invalidlink;
	
	public static void verifyLink(String Link) {
		
		try {
			//open the HTTP
			URL url = new URL(Link);
			
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
			
			//define timeout
			urlconnection.setConnectTimeout(5000);
			
			//connect the url
			urlconnection.connect();
			
			//logic to find invalid link
			if(urlconnection.getResponseCode()>=400) {
				System.out.println("Broken link is = "+urlconnection.getResponseMessage()+" "+HttpURLConnection.HTTP_NOT_FOUND);
				invalidlink ++;
			}else {
				System.out.println("Vlaid link is = "+urlconnection.getResponseMessage()+" "+Link+"Response code : "+urlconnection.getResponseCode());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getInvalidLinkCount() {
		System.out.println("Total invalid link count = "+invalidlink);
	}
	
}
