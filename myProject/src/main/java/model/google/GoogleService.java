package model.google;

import java.util.Map;

public interface GoogleService {
	String getReturnAccessToken(String code);
	Map<String,Object> getUserInfo(String access_token);
	void getLogout(String access_token);
}
