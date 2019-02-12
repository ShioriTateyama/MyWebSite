package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ItemDetailBeans implements Serializable{

	private int itemDetailId;
	private int itemId;
	private int colorId;
	private int sizeId;
	private int stock;
	private Date createDate;
	private Date updateDate;

	private String itemName;
	private int price;
	private int categoryId;
	private String detail;

	private int fileId;
	private List<String> fileName;

	private String sizeName;


	private boolean favoriteFlg;
	private int quantity;



	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, int sizeId, List<String> fileNames) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeName=sizeName;
		this.sizeId=sizeId;
		this.fileName=fileNames;

	}

	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, List<String> fileNames, boolean favoriteFlg) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeName=sizeName;
		this.fileName=fileNames;
		this.favoriteFlg = favoriteFlg;
	}
	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, int sizeId, List<String> fileNames, boolean favoriteFlg) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeName=sizeName;
		this.sizeId=sizeId;
		this.fileName=fileNames;
		this.favoriteFlg = favoriteFlg;
	}

	public int getItemDetailId() {
		return itemDetailId;
	}
	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
