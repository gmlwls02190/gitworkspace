package controller;

// 페이지 전달방식, 경로
public class ActionForward {
	
	private boolean redirect;
	// true 주로 전달할 정보가 없을때 사용
	// false 전달할 정보가 있을때 사용
	private String path;
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
