package beans;

import java.io.Serializable;

public class ItemBeans implements Serializable{

	private int itemId;
	private String itemName;
	private int price;
	private int categoryId;
	private String detail;

	public ItemBeans() {

	}


	public ItemBeans(int itemId, String itemName, int price, int categoryId, String detail) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.categoryId = categoryId;
		this.detail = detail;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}


}
