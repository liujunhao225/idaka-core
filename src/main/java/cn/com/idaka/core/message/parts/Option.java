package cn.com.idaka.core.message.parts;

public class Option {
	public Option(){}
	public Option(String name, String image, int votes) {
		super();
		this.name = name;
		this.image = image;
		this.votes = votes;
	}
	String name;
	String image;
	int votes;
	String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}