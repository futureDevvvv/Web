package com.dev.vo;

public class ProductVO {
	private String pId;
	private String pName;
	private int pPrice;
	private String pInfo;
	private String pImage;
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pID=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", pInfo=" + pInfo + ", pImage="
				+ pImage + "]";
	}
}
