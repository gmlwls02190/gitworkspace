package test;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("champ")
public class Champ implements ChampAction{
	
	private String name;
	private List<String> inven;
	// @Autowired // 컨테이너는 자신이 만들어두었던 객체들의 "타입"을 확인! ★의존성 주입★
	// 같은 타입이 두개 이상일 경우 둘중 어떤걸 넣어야되는지 모르기때문에 오류
	// 주입할게 없을 경우에는 없어서 오류
	// Component에 이름을 지정안해줘도 타입을 보고 찾아간다
	@Resource(name="bow")
	private Weapon weapon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getInven() {
		return inven;
	}
	public void setInven(List<String> inven) {
		this.inven = inven;
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	@Override
	public void attack() {
		weapon.attack();
		// 널포인터익셉션(예외) 발생우려가있으니, new 했어야했다!
		// -> 멤버변수로 처리, 생성자 주입
		// -> setter 주입으로 변경(기본 생성자가 필요!)
	}
	@Override
	public void print() {
		System.out.println(name);
		for(String v: inven) {
			System.out.println(v);
		}
	}
	
}
