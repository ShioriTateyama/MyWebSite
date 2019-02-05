package beans;

import java.io.Serializable;

public class ColorBeans implements Serializable{

	private int colorId;
	private String colorName;

	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

}
