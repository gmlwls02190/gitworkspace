package controller;

// ������ ���޹��, ���
public class ActionForward {
	
	private boolean redirect;
	// true �ַ� ������ ������ ������ ���
	// false ������ ������ ������ ���
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
