package model;

public class Product {
	
	private String[] pname= {"���Ǵ�","���ڿ�","�Ƿ�Ƽ"};
	private int[] price= {500,300,800};
	
	public String[] getPname() {
		return pname;
	}
	public int[] getPrice() {
		return price;
	}
	public int calc(String name,int cnt) {
		int tot=0; // ����ڰ� �����Է������ʴ� ������ -> �ʱ�ȭ �ʼ����!
		for(int i=0;i<pname.length;i++) {
			if(pname[i].equals(name)) {
				tot=price[i]*cnt;
			}
		}
		/*if(name.equals("���Ǵ�")) {
			tot=price[0]*cnt;
		}
		else if(name.equals("���ڿ�")) {
			tot=price[1]*cnt;
		}
		else if(name.equals("�Ƿ�Ƽ")) {
			tot=price[2]*cnt;
		}*/
		return tot;
	}
}
