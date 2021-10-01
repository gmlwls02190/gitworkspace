package test;

public class Teemo implements Skill{
	
	private Items items;
	private String user;
	private LevList levlist;
	
	public void setItems(Items items) {
		this.items = items;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setLevlist(LevList levlist) {
		this.levlist = levlist;
	}
	public Teemo() {
		System.out.println("기본 티모");
	}
	public Teemo(Items items,String user) {
		this.items=items;
		this.user=user;
		System.out.println("강화된 티모"+this.user);
	}
	@Override
	public void q() {
		System.out.print(this.levlist.getList().get(4)+" ");
		System.out.println("맹독다트");
	}
	@Override
	public void w() {
		System.out.print(this.levlist.getList().get(0)+" ");
		System.out.println("신속한몸놀림");
	}
	@Override
	public void e() {
		this.items.ad();
		System.out.print(this.levlist.getList().get(2)+" ");
		System.out.println("독성물질");
	}
}