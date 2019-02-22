package beans;

import java.io.Serializable;

import dao.BuyDAO;
import dao.FileDAO;
import dao.ItemDetailDAO;


public class BuyDetailBeans implements Serializable{

	private int buyDetailId;
	private int buyId;
	private int itemDetailId;
	private int purchaseQuantity;
	private int totalPrice;
	private int itemQuantity;
	private int allItemQuantity;
	private int userId;

	private ItemDetailBeans itemDetailBeans;
	private BuyBeans buyBeans;
	private FileBeans fileBeans;


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



	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}

	public ItemDetailBeans getItemDetailBeans() {
		ItemDetailDAO dao = new ItemDetailDAO();
		return dao.selectItemDetailDatabyItemDetailId(this.itemDetailId);
	}
	public BuyBeans getBuyBeans() {
		BuyDAO buyDao =new BuyDAO();
		return buyDao.selectBuyData(this.buyId);
	}
	public FileBeans getFileBeans() {
		FileDAO fileDao =new FileDAO();
		return fileDao.getFile(this.itemDetailId);
	}
}
