package beans;


import java.io.Serializable;
import java.util.Date;

public class BuyBeans implements Serializable{

	private int buyId;
	private int userId;
	private int totalPrice;
	private Date createDate;
	private int totalItemQuantity;
	private int allItemQuantity;


	public BuyBeans(int totalPrice,int totalItemQuantity) {

		this.totalPrice=totalPrice;
		this.totalItemQuantity=totalItemQuantity;

	}
	public BuyBeans(int totalPrice,int totalItemQuantity,int allItemQuantity) {

		this.totalPrice=totalPrice;
		this.totalItemQuantity=totalItemQuantity;
		this.allItemQuantity = allItemQuantity;
	}


	public BuyBeans(int buyId, int userId, int totalPrice, Date createDate) {
		this.buyId=buyId;
		this.userId=userId;
		this.totalPrice=totalPrice;
		this.createDate=createDate;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public int getTotalItemQuantity() {
		return totalItemQuantity;
	}


	public void setTotalItemQuantity(int totalItemQuantity) {
		this.totalItemQuantity = totalItemQuantity;
	}


	public int getAllItemQuantity() {
		return allItemQuantity;
	}


	public void setAllItemQuantity(int allItemQuantity) {
		this.allItemQuantity = allItemQuantity;
	}



}
