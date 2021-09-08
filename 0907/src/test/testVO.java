package test;

public class testVO {
	
	private String product;
	private String status;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public testVO(String product,String status) {
		this.product=product;
		this.status=status;
	}
	
}
