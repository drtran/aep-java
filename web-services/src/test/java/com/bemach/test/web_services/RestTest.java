/**
 * Copyrights (C) 2013-2015 Kiet T. Tran
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.
 *
 * Use as is - No warranties whatsoever.
 * 
 */
package com.bemach.test.web_services;
import static com.jayway.restassured.RestAssured.get;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.response.Response;

/**
 * Copied from: http://artoftesting.com/automationTesting/restAPIAutomationGetRequest.html
 * Make sure to use a lesser version of JSON. The latest requires 1.8 or some sort. 
 * Here is the one works for 1.7:
 * 
 * <dependency>
 *   <groupId>org.json</groupId>
 * 	  <artifactId>json</artifactId>
 *	  <version>20131018</version>
 * </dependency>
 * 
 * Also needs these:
 * <dependency>
 *	 <groupId>com.jayway.restassured</groupId>
 *	 <artifactId>rest-assured</artifactId>
 *	 <version>2.4.1</version>
 * </dependency>
 *
 * <dependency>
 *	 <groupId>org.codehaus.groovy</groupId>
 *	 <artifactId>groovy-all</artifactId>
 *	 <version>2.4.4</version>
 * </dependency>
 *
 */
public class RestTest {
	@Test
	public void getRequestFindCapital() throws JSONException {

		// make get request to fetch capital of norway
		Response resp = get("http://restcountries.eu/rest/v1/name/norway");

		// Fetching response in JSON
		JSONArray jsonResponse = new JSONArray(resp.asString());

		// Fetching value of capital parameter
		String capital = jsonResponse.getJSONObject(0).getString("capital");

		// Asserting that capital of Norway is Oslo
		Assert.assertEquals(capital, "Oslo");
	}
}
