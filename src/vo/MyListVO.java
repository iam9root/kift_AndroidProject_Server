package vo;

public class MyListVO {

	/*CREATE TABLE itemlist
	(
	    itemid           VARCHAR2(10)     NOT NULL, 
	    itemname         VARCHAR2(200)    NOT NULL, 
	    price            number(6)        NOT NULL, 
	    thumbnailpath    VARCHAR2(500)    NOT NULL, 
	    imagepath_i      VARCHAR2(500)    NOT NULL, 
	    accessibility    number(5)        NOT NULL, 
	    storename        VARCHAR2(200)    NOT NULL, 
	    fitage           number(2)        NULL, 
	    classify         varchar2(5)      NOT NULL, 
	    heartcount       number(5)        NOT NULL, 
	    destination      VARCHAR2(30)     NULL, 
	    CONSTRAINT ITEMLIST_PK PRIMARY KEY (itemid)
	)*/
	private String itemid;
	private String itemname;
	private int price;
	private String thumbnailpath;
	private String imagepath_i;
	private int accessibility;
	private String storename;
	private int fitage;
	private String classify;
	private int heartcount;
	private String destination;
	
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getThumbnailpath() {
		return thumbnailpath;
	}
	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}
	public String getImagepath_i() {
		return imagepath_i;
	}
	public void setImagepath_i(String imagepath_i) {
		this.imagepath_i = imagepath_i;
	}
	public int getAccessibility() {
		return accessibility;
	}
	public void setAccessibility(int accessibility) {
		this.accessibility = accessibility;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public int getFitage() {
		return fitage;
	}
	public void setFitage(int fitage) {
		this.fitage = fitage;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public int getHeartcount() {
		return heartcount;
	}
	public void setHeartcount(int heartcount) {
		this.heartcount = heartcount;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
}
