package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FavoriteBeans implements Serializable{

	private int favoriteId;
	private int userId;
	int itemId;
	private Date createDate;


	private String itemName;
	private int price;
	private int categoryId;
	private String detail;

	private int fileId;
	private int itemDetailId;
	private List<String> fileName;

	private int colorId;
	private int sizeId;
	private int stock;

	private String sizeName;
	private boolean favoriteFlg;



	public FavoriteBeans(int itemDetailId, String itemName, int price, String detail, String sizeName,int stock,
			List<String> fileName) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.detail=detail;
		this.sizeName=sizeName;
		this.stock=stock;
		this.fileName=fileName;
	}
	public FavoriteBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
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
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
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
	public int getItemDetailId() {
		return itemDetailId;
	}
	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}
	public List<String> getFileName() {
		return fileName;
	}
	public void setFileName(List<String> fileName) {
		this.fileName = fileName;
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

}
