package beans;

import java.io.Serializable;


public class BuyDetailBeans implements Serializable{

	private int buyDetailId;
	private int buyId;
	private int itemDetailId;
	private int purchaseQuantity;

	public BuyDetailBeans(int buyDetailId, int buyId, int itemDetailId, int purchaseQuantity) {
		this.buyDetailId=buyDetailId;
		this.buyId=buyId;
		this.itemDetailId=itemDetailId;
		this.purchaseQuantity=purchaseQuantity;

	}
	public int getBuyDetailId() {
		return buyDetailId;
	}
	public void setBuyDetailId(int buyDetailId) {
		this.buyDetailId = buyDetailId;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}


	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getItemDetailId() {
		return itemDetailId;
	}
	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}

}
