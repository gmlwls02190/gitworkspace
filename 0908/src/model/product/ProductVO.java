package model.product;

public class ProductVO {
	
	private int pnum;
	private String pname;
	private int pcnt;
	private String pstatus;
	
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public String getPstatus() {
		return pstatus;
	}
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	@Override
	public String toString() {
		return "ProductVO [pname=" + pname + ", pcnt=" + pcnt + ", pstatus=" + pstatus + "]";
	}
	
}
