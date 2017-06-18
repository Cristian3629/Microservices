package es.kita.utils;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;
import javax.net.ssl.HttpsURLConnection;


public class Request{

  private int responseCode;
  private String response;

  public Request(String url, String action){
    try{
      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod(action);

      this.responseCode = con.getResponseCode();


      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Responsessss Code : " + responseCode);
      //System.out.println("rgetInputStream()."+con.getInputStream());

      BufferedReader in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      //print result
      System.out.println("response toString"+response.toString());
      this.response = response.toString();
      in.close();
    }catch (Exception e) {
      this.responseCode = 400;
    }
  }


  public Boolean isOk(){
    System.out.println("Is Ok:"+this.responseCode);
    return this.responseCode == 200;
  }


  public JSONArray getResponse(){
    JSONArray jsonObj;
    try{
      jsonObj = new JSONArray(this.response);
    }catch (JSONException e) {
      System.out.println("Error en el parse");
      return null;
    }
    return jsonObj;
  }

}
