package com.ge.exercise1;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyParser implements Parser {

	@Override
	public Application parseApplicationData(String data) {
		//convert data String to json format
		data = "{" + data + "}";
		data = data.replace("(", ":{").replace(")", "}").
				replace("[", "[{").replace("]", "}]").
				replace(":","\":\"").replace("{","{\"").
				replace(",","\",\"").replace("", "").
				replace("}","\"}").
				replace("]\"","]").replace("}\"", "}").
				replaceAll(":\\s?\"\\s?[{]",":{").
				replaceAll(":\\s?\"\\s?[\\[]",":[");
		System.out.println(data);
		
		ObjectMapper mapper = new ObjectMapper();
		MyApplication result = null;
		try {
			result = mapper.readValue(data.getBytes(), MyApplication.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result.getApplication();
	}
	public static void main(String[] args) {
		String simpleTestData = "Application(id: 0,name: MyApp,users:[User(id: 2,name: Beth Jones)],groups:[Group(id: 1,name: SimpleGroup,users:[User(id: 2,name: Beth Jones)])])";
		new MyParser().parseApplicationData(simpleTestData);
	}
}
