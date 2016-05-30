package cn.com.idaka.core.message.parts;


public class Room {
	private String id;
	private String name;
	/**
	 * 销售最低价格
	 */
	private Integer price;
	private Integer marketPrice;
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(Integer marketPrice) {
		this.marketPrice = marketPrice;
	}
	private int breakfast;
	private int wireless;
	private int numbers;
	/**
	 * 返现
	 */
	private int cash;
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBreakfast() {
		return breakfast;
	}
	public void setBreakfast(int breakfast) {
		this.breakfast = breakfast;
	}
	public int getWireless() {
		return wireless;
	}
	public void setWireless(int wireless) {
		this.wireless = wireless;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
