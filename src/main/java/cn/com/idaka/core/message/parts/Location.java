package cn.com.idaka.core.message.parts;

public class Location {
	public Location() {
		super();
	}
	public Location(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}
	private float x;
	private float y;
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

}
