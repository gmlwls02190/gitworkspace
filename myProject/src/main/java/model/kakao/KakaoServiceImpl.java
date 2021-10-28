package model.kakao;

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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



@Service("kakaoService")
public class KakaoServiceImpl implements KakaoService{

	@Override
	public String getReturnAccessToken(String code) {
		String access_token = "";
		String refresh_token = "";
		String reqURL = "https://kauth.kakao.com/oauth/token";

		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			//HttpURLConnection ���� �� ����
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// buffer ��Ʈ�� ��ü �� ���� �� ��û
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder sb = new StringBuilder();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=a1a82c6ddf498743e99395481ba41136");  //�� KEY VALUE
			sb.append("&redirect_uri=http://localhost:8088/app/kakaoCallback.do"); // �� CALLBACK ���
			sb.append("&code=" + code);
			bw.write(sb.toString());
			bw.flush();

			//  RETURN �� result ������ ����
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String br_line = "";
			String result = "";

			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}

			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(result);

			// ��ū �� ���� �� ����
			access_token = element.getAsJsonObject().get("access_token").getAsString();
			refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();

			br.close();
			bw.close();
			System.out.println("getReturnAccessToken Finish!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return access_token;
	}

	@Override
	public Map<String, Object> getUserInfo(String access_token) {
		Map<String,Object> resultMap =new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			//��û�� �ʿ��� Header�� ���Ե� ����
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

			JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
			JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

			String nickname = properties.getAsJsonObject().get("nickname").getAsString();
//            String profile_image = properties.getAsJsonObject().get("profile_image").getAsString();
			String email = kakao_account.getAsJsonObject().get("email").getAsString();
//			System.out.println("nickname: "+nickname);
			resultMap.put("nickname", nickname);
//            resultMap.put("profile_image", profile_image);
			resultMap.put("email", email);
			System.out.println("getUserInfo Finish!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public void getLogout(String access_token) {
		String reqURL ="https://kapi.kakao.com/v1/user/logout";
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			conn.setRequestProperty("Authorization", "Bearer " + access_token);
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);

			if(responseCode ==400) throw new RuntimeException("īī�� �α׾ƿ� ���� ���� �߻�");


			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String br_line = "";
			String result = "";
			while ((br_line = br.readLine()) != null) {
				result += br_line;
			}
			System.out.println("���");
			System.out.println(result);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
