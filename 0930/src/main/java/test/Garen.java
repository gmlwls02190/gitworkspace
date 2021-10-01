package test;

public class Garen implements Skill{
	
	private Items items;
	private String user;
	
	public void setItems(Items items) {
		this.items = items;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Garen() {
		System.out.println("기본");
	}
	public Garen(Items items,String user) {
		this.items=items;
		this.user=user;
		System.out.println("강화"+user);
	}
	@Override
	public void q() {
		System.out.println("q");
	}
	@Override
	public void w() {
		System.out.println("w");
	}
	@Override
	public void e() {
		System.out.println("e");
	}
}
