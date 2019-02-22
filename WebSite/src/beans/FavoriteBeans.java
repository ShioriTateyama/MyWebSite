package beans;

import java.io.Serializable;

import dao.FileDAO;
import dao.ItemDetailDAO;

public class FavoriteBeans implements Serializable{

	private int favoriteId;
	private int userId;
	private int itemDetailId;
	private FileBeans fileBeans;
	private ItemDetailBeans itemDetailBeans;
	private boolean favoriteFlg;

	public FavoriteBeans(int favoriteId,int userId, int itemDetailId) {
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.itemDetailId = itemDetailId;
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
	public int getItemDetailId() {
		return itemDetailId;
	}
	public void setItemDetailId(int itemDetailId) {
		this.itemDetailId = itemDetailId;
	}
	public FileBeans getFileBeans() {
		FileDAO fileDao =new FileDAO();
		return fileDao.getFile(this.itemDetailId);
	}
	public ItemDetailBeans getItemDetailBeans() {
		ItemDetailDAO itemDetailDao = new ItemDetailDAO();
		return itemDetailDao.selectItemDetailDatabyItemDetailId(this.itemDetailId);
	}
	public boolean isFavoriteFlg() {
		return favoriteFlg;
	}
	public void setFavoriteFlg(boolean favoriteFlg) {
		this.favoriteFlg = favoriteFlg;
	}

}
