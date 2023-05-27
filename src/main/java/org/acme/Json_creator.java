package org.acme;
import org.json.JSONObject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import org.json.JSONArray;

public class Json_creator {
	 
	Json_creator(){
		
	}
	
	String create_json_spending(String user_id,String user_name, calendar cal, Double total_price, Double[] price_per_item, String[] item) {
		JSONObject json = new JSONObject();
		json.put("user_id", user_id);
		json.put("user_name", user_name);
		json.put("date",cal.getFullDate());
		JSONArray items = new JSONArray();
		for(int i = 0; i<item.length;i++) {
			JSONObject eachitem = new JSONObject();
			int temp = i+1;
			eachitem.put("ID", temp);
			eachitem.put("item", item[i]);
			eachitem.put("price", price_per_item[i]);
			System.out.println(eachitem);
	        items.put(eachitem);
	        System.out.println("Adding item ID :"+i+1+" item :"+ item[i]+" price :"+ price_per_item[i]);
			
		}
		json.put("Details", items);
		json.put("Total_price", total_price);
	
		System.out.println(json);
		String tempFilepath = "//home//chan//data//"+user_id+"//"+cal.getYear()+"//"+cal.getMonth()+"//"+cal.getWeek()+"//"+cal.getDay();
		
		    //check if user_id file existed
		    
		    File file = new File(tempFilepath);
		    if(!file.exists()) {
		    	file.mkdirs();
		    	System.out.println("Folder for user_id : "+user_id+" created!");
		    }
		    tempFilepath = "//home//chan//data//"+user_id+"//"+cal.getYear()+"//"+cal.getMonth()+"//"+cal.getWeek()+"//"+cal.getDay()+"//"+cal.getFullDate()+".json";
		    file = new File(tempFilepath);
		    try {
		    	FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(json.toString());
				fileWriter.flush();
				fileWriter.close();
				System.out.println("json info saved");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("json info error");
				return "error";
			}
		    System.out.println("done");
		  
		   return tempFilepath;
		
	}
	
	

}
