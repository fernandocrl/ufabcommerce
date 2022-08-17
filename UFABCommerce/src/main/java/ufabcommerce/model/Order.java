package ufabcommerce.model;

public class Order extends Product{
	private int orderId;
	private int uid;
	private int aid;
	private int quantity;
	private String date;
	
	public Order() {}

	public Order(int orderId, int uid, int aid, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		this.aid = aid;
		this.quantity = quantity;
		this.date = date;
	}

	public Order(int uid, int aid, int quantity, String date) {
		super();
		this.uid = uid;
		this.aid = aid;
		this.quantity = quantity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", uid=" + uid + ", aid=" + aid + ", quantity=" + quantity + ", date="
				+ date + "]";
	}

	
	
	
	
}
