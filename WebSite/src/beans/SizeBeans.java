package beans;

import java.io.Serializable;

public class SizeBeans implements Serializable{

	private int sizeId;
	private String sizeName;

	public SizeBeans(int sizeId, String sizeName) {
		this.sizeId=sizeId;
		this.sizeName=sizeName;
	}
	public int getSideId() {
		return sizeId;
	}
	public void setSideId(int sizeId) {
		this.sizeId = sizeId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}


}
