package model.google;

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

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service("googleService")
public class GoogleServiceImpl implements GoogleService{

	@Override
	public String getReturnAccessToken(String code) {
		String access_token="";
		String refresh_token="";
		String reqURL="https://oauth2.googleapis.com/token";
		
		try {
			URL url=new URL(reqURL);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb=new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=클라이언트아이디");
			sb.append("&client_secret=클라이언트보안");
			sb.append("&redirect_uri=라다이렉트주소");
			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String br_line="";
			String result="";
			
			while((br_line=br.readLine())!=null) {
				result+=br_line;
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
		String reqURL = "https://www.googleapis.com/userinfo/v2/me?access_token="+access_token;
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			//요청에 필요한 Header에 포함될 내용
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

			String name = element.getAsJsonObject().get("name").getAsString();
			String email = element.getAsJsonObject().get("email").getAsString();
			String id = "GOOGLE_"+element.getAsJsonObject().get("id").getAsString();
			resultMap.put("name", name);
			resultMap.put("email", email);
			resultMap.put("id", id);
			
			System.out.println("getUserInfo Finish!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void getLogout(String access_token) {
		String reqURL ="https://accounts.google.co.kr/accounts/logout";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			if(responseCode ==400) throw new RuntimeException("구글 로그아웃 도중 오류 발생");


			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String br_line = "";
			String result = "";
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			System.out.println("결과");
			System.out.println(result);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
