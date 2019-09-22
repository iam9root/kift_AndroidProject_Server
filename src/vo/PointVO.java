package vo;

public class PointVO {

	String title, mapx, mapy;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMapx() {
		return mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	public String getMapy() {
		return mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	public PointVO(String title, String mapx, String mapy) {
		super();
		this.title = title;
		this.mapx = mapx;
		this.mapy = mapy;
	}
	
	public PointVO() {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "title : " +title+", mapx :" +mapx + ", mapy : " + mapy;
	}
	
	
}
