package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class BuyDetailBeans implements Serializable{

	private int buyDetailId;
	private int buyId;
	private int itemDetailId;
	private int purchaseQuantity;
	private int totalPrice;
	private int itemQuantity;
	private int allItemQuantity;
	private int userId;



	private int itemId;
	private int colorId;
	private int sizeId;
	private int stock;
	private Date createDate;

	private String itemName;
	private int price;
	private int categoryId;
	private String detail;

	private int fileId;
	private List<String> fileName;

	private String sizeName;


	private boolean favoriteFlg;

	public BuyDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, int sizeId, List<String> fileNames,
			int purchaceQuantity, java.sql.Date createDate, int totalPrice,int allItemQuantity) {
		this.itemDetailId=itemDetailId;

		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeName=sizeName;
		this.sizeId=sizeId;
		this.fileName=fileNames;

		this.createDate = createDate;
		this.totalPrice=totalPrice;

		this.allItemQuantity = allItemQuantity;

	}


	public BuyDetailBeans(int buyDetailId, int buyId, int itemDetailId, int purchaseQuantity) {
		this.buyDetailId=buyDetailId;
		this.buyId=buyId;
		this.itemDetailId=itemDetailId;
		this.purchaseQuantity=purchaseQuantity;

	}
	public BuyDetailBeans(int totalPrice,int itemQuantity) {

		this.totalPrice=totalPrice;
		this.itemQuantity=itemQuantity;

	}
	public BuyDetailBeans(int totalPrice,int itemQuantity,int allItemQuantity) {

		this.totalPrice=totalPrice;
		this.itemQuantity=itemQuantity;
		this.allItemQuantity = allItemQuantity;
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getAllItemQuantity() {
		return allItemQuantity;
	}
	public void setAllItemQuantity(int allItemQuantity) {
		this.allItemQuantity = allItemQuantity;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public List<String> getFileName() {
		return fileName;
	}
	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public boolean isFavoriteFlg() {
		return favoriteFlg;
	}
	public void setFavoriteFlg(boolean favoriteFlg) {
		this.favoriteFlg = favoriteFlg;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

}
