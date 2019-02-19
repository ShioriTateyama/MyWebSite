package beans;

import java.io.Serializable;
import java.util.List;

public class FileBeans implements Serializable{


	private int fileId;
	private int itemDetailId;
	private List<String> fileNames;


	public FileBeans(int itemDetailId,List<String> fileNames) {
		this.itemDetailId = itemDetailId;
		this.fileNames = fileNames;
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
		return fileNames;
	}
	public void setFileName( List<String>fileName) {
		this.fileNames = fileName;
	}

}
