package model.naver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service("naverService")
public class NaverServiceImpl implements NaverService{

	@Override
	public String getReturnAccessToken(String code, String state) {
		String access_token="";
		String refresh_token="";
		String reqURL="https://nid.naver.com/oauth2.0/token";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=클라이언트아이디");
			sb.append("&client_secret=클라이언트보안");
			sb.append("&redirect_uri=리다이렉트주소");
			sb.append("&code="+code);
			sb.append("&state="+state);
			bw.write(sb.toString());
			bw.flush();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String br_line = "";
			String result = "";
			
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			access_token = element.getAsJsonObject().get("access_token").getAsString();
//			refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();
			
			br.close();
			bw.close();
			System.out.println("getReturnAccessToken Finish!!!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return access_token;
	}

	@Override
	public Map<String, Object> getUserInfo(String access_token) {
		Map<String,Object> resultMap =new HashMap<String, Object>();
		String reqURL="https://openapi.naver.com/v1/nid/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

			String br_line = "";
			String result = "";

			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			System.out.println("response:" + result);

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);
			
			JsonObject response = element.getAsJsonObject().get("response").getAsJsonObject();
			
//			String id = element.getAsJsonObject().get("id").getAsString();
			String nickname = response.getAsJsonObject().get("nickname").getAsString();
			String name = response.getAsJsonObject().get("name").getAsString();
			String email = response.getAsJsonObject().get("email").getAsString();
			String gender = response.getAsJsonObject().get("gender").getAsString();
			String age = response.getAsJsonObject().get("age").getAsString();
			String mobile = response.getAsJsonObject().get("mobile").getAsString();
//			resultMap.put("id", id);
			resultMap.put("nickname", nickname);
			resultMap.put("name", name);
			resultMap.put("email", email);
			resultMap.put("gender", gender);
			resultMap.put("age", age);
			resultMap.put("mobile", mobile);
			
			System.out.println("getUserInfo Finish!!!");
		}catch(IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void getLogout(String access_token) {
		// TODO Auto-generated method stub
		
	}

}
