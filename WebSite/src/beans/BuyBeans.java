package beans;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyBeans implements Serializable{

	private int buyId;
	private int userId;
	private int totalPrice;
	private Date createDate;
	private int itemQuantity;
	private int allItemQuantity;

	public BuyBeans(int userId,int totalPrice) {
		this.userId=userId;
		this.totalPrice=totalPrice;
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
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(createDate);
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int totalItemQuantity) {
		this.itemQuantity = totalItemQuantity;
	}


	public int getAllItemQuantity() {
		return allItemQuantity;
	}


	public void setAllItemQuantity(int allItemQuantity) {
		this.allItemQuantity = allItemQuantity;
	}




}
