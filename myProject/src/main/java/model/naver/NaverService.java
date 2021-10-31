package model.naver;

import java.util.Map;

public interface NaverService {
	String getReturnAccessToken(String code,String state);
	Map<String,Object> getUserInfo(String access_token);
	void getLogout(String access_token);
}
