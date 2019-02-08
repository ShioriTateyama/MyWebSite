package beans;

import java.io.Serializable;
import java.sql.Date;

public class UserBeans implements Serializable{

	private int userId;
	private String loginId;
	private String name;
	private String address;
	private String password;
	private Date createDate;
	private Date updateDate;



	//DAOで使うコンストラクタ
	public UserBeans(String loginId, String name) {
		this.loginId=loginId;
		this.name=name;
	}
	public UserBeans(String loginId, String name,String address,String password) {
		this.loginId=loginId;
		this.name=name;
		this.address=address;
		this.password=password;
	}
	public UserBeans(int userId,String loginId,String name,String address,String password,Date createDateData,Date updateDateData) {
		this.userId=userId;
		this.loginId=loginId;
		this.name=name;
		this.address=address;
		this.password=password;
		this.createDate=createDateData;
		this.updateDate=updateDateData;
	}
	public UserBeans(int userId, String loginId, String name, String address) {
		this.userId=userId;
		this.loginId=loginId;
		this.name=name;
		this.address=address;
	}
	public UserBeans(int userId, String loginId, String name, String address, String password) {
		this.userId=userId;
		this.loginId=loginId;
		this.name=name;
		this.address=address;
		this.password=password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

}
