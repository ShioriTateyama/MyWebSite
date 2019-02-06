package beans;

import java.io.Serializable;

public class SizeBeans implements Serializable{

	int sideId;
	String sizeName;

	public int getSideId() {
		return sideId;
	}
	public void setSideId(int sideId) {
		this.sideId = sideId;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}


}
