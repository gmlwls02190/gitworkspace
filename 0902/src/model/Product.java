package model;

public class Product {
	
	private String[] pname= {"솔의눈","데자와","실론티"};
	private int[] price= {500,300,800};
	
	public String[] getPname() {
		return pname;
	}
	public int[] getPrice() {
		return price;
	}
	public int calc(String name,int cnt) {
		int tot=0; // 사용자가 직접입력하지않는 데이터 -> 초기화 필수대상!
		for(int i=0;i<pname.length;i++) {
			if(pname[i].equals(name)) {
				tot=price[i]*cnt;
			}
		}
		/*if(name.equals("솔의눈")) {
			tot=price[0]*cnt;
		}
		else if(name.equals("데자와")) {
			tot=price[1]*cnt;
		}
		else if(name.equals("실론티")) {
			tot=price[2]*cnt;
		}*/
		return tot;
	}
}
