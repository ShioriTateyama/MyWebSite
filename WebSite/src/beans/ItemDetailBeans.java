package beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import dao.FavoriteDAO;
import dao.FileDAO;
import dao.ItemDAO;
import dao.SizeDAO;


public class ItemDetailBeans implements Serializable{

	private int itemDetailId;
	private int itemId;
	private int colorId;
	private int sizeId;
	private int stock;
	private Date createDate;
	private Date updateDate;

	private ItemBeans itemBeans;
	private FileBeans fileBeans;
	private SizeBeans sizeBeans;
	private FavoriteBeans favoriteBeans;


	private int userId;

	private String itemName;
	private int price;
	private int categoryId;
	private String detail;

	private int fileId;
	private List<String> fileName;

	private String sizeName;


	private boolean favoriteFlg;
	private int quantity;

	public ItemDetailBeans(int itemDetailId,int userId) {
		this.itemDetailId=itemDetailId;
		this.userId=userId;

	}

	public ItemDetailBeans(int itemDetailId,int sizeId,int quantity) {
		this.itemDetailId=itemDetailId;
		this.sizeId=sizeId;
		this.quantity=quantity;
	}

	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock,  int sizeId, int colorId) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeId=sizeId;
		this.colorId=colorId;

	}

	public ItemDetailBeans(boolean f, int itemId, int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock,  int sizeId, int colorId) {
		this.itemId = itemId;
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeId=sizeId;
		this.colorId=colorId;

	}


	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, int sizeId, List<String> fileNames,int quantity) {
		this.itemDetailId=itemDetailId;
		this.itemName=itemName;
		this.price=price;
		this.categoryId=categoryId;
		this.detail=detail;
		this.stock=stock;
		this.sizeName=sizeName;
		this.sizeId=sizeId;
		this.fileName=fileNames;
		this.quantity=quantity;

	}

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
			int stock, String sizeName, int sizeId, List<String> fileNames, boolean favoriteFlg,int quantity) {
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
		this.quantity=quantity;
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
	public ItemDetailBeans(int itemDetailId, String itemName, int price, int categoryId, String detail,
			int stock, String sizeName, int sizeId, List<String> fileNames, boolean favoriteFlg,
			int purchaceQuantity, java.sql.Date createDate, int totaolPrice, int userId) {
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
		this.createDate = createDate;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ItemBeans getItemBeans() {
		ItemDAO dao =new ItemDAO();
		return dao.getItem(this.itemId);
	}
	public FileBeans getFileBeans() {
		FileDAO fileDao =new FileDAO();

		if(this.categoryId!=3) {

			return fileDao.getFile(this.itemDetailId);
		}else {

			return fileDao.getBathrobeFile(this.itemDetailId);

		}
	}
	public SizeBeans getSizeBeans() {
		SizeDAO sizeDao =new SizeDAO();
		return sizeDao.selectSizeData(this.itemDetailId);
	}
	public List<FavoriteBeans> getFavoriteBeans() {
		FavoriteDAO favoriteDao =new FavoriteDAO();
		return favoriteDao.getAllFavoriteData(this.userId);
	}

}
