package beans;

import java.io.Serializable;


public class BuyDetailBeans implements Serializable{

	private int buyDetailId;
	private int buyId;
	private int itemId;
	private int colorId;
	private int sizeId;
	private int purchaseQuantity;

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
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getSizeId() {
		return sizeId;
	}
	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}

}
