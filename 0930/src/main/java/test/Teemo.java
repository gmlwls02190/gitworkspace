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
		System.out.println("�⺻ Ƽ��");
	}
	public Teemo(Items items,String user) {
		this.items=items;
		this.user=user;
		System.out.println("��ȭ�� Ƽ��"+this.user);
	}
	@Override
	public void q() {
		System.out.print(this.levlist.getList().get(4)+" ");
		System.out.println("�͵���Ʈ");
	}
	@Override
	public void w() {
		System.out.print(this.levlist.getList().get(0)+" ");
		System.out.println("�ż��Ѹ��");
	}
	@Override
	public void e() {
		this.items.ad();
		System.out.print(this.levlist.getList().get(2)+" ");
		System.out.println("��������");
	}
}