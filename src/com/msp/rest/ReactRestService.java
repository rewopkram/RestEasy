package com.msp.rest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;



@Path("/react")
public class ReactRestService {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public String printMessage() {
		System.out.println("react service!");
		return readFile();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String saveComment(String comment) {
		System.out.println("****ReactRestService POST to rest service...");
		
		try {
			String tmp = readFile();

			System.out.println("trying to creat json array with " + tmp);
			JSONArray arr = new JSONArray(tmp);
			// parse comment string author=Mike&text=hello&id=21212112
			// surely JAXB or Jettison can do this?
			// meantime I will hard code to see if it can work
			
			JSONObject obj = new JSONObject();
			StringTokenizer st = new StringTokenizer(comment, "&");
			
			while(st.hasMoreTokens()) {
				String token = st.nextToken();
				int idx = token.indexOf("=");
				String key = token.substring(0, idx);
				String val = token.substring(idx + 1);
				val = val.replaceAll("%20", " ");
				
				obj.put(key, val);
			}
			
			arr.put(obj);
			
			//obj.append(comment.)
			System.out.println("comments.json = " + arr.toString());
			System.out.println("new comments = " + comment.toString());
			
			String data = arr.toString();
			
			writeFile(data);
			//return obj.toString();
		} catch(Exception e) {
			System.out.println("Exception creating json object");
			e.printStackTrace();
		}
		return readFile();
	}
	
	private void writeFile(String data) {
		BufferedWriter r = null;
		try {
			System.out.println("Writing comments file with data " + data);
			FileWriter comments = new FileWriter("/Library/Tomcat/webapps/RestEasyExample-0.0.1/rjs/comments.json");
			r = new BufferedWriter(comments);
			r.write(data);
			r.flush();
		} catch(FileNotFoundException e) {
			System.out.println("Exception writing data...");
			e.printStackTrace();
		} catch(IOException ie) {
			System.out.println("Exception writing data...");
			ie.printStackTrace();
		} finally {
			if (r != null) {
				try {
					r.close();
				} catch(Exception e) {}
			}
		}
	}
	
	private String readFile() {
		StringBuffer ret = new StringBuffer();

		try {
			FileReader json = new FileReader("/Library/Tomcat/webapps/RestEasyExample-0.0.1/rjs/comments.json");
			BufferedReader r = new BufferedReader(json);
			String line = "";

			while ((line = r.readLine()) != null) {
				ret.append(line);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} 
		//System.out.println("react service returning "+ ret.toString());
		return ret.toString();
	}
	
}
