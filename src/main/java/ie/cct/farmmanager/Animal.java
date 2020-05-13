package ie.cct.farmmanager;

public class Animal {
	
	private String type;
	private Float weight;

	public Animal() {
	}

	public Animal(String type, Float weight) {
		this.type = type;
		this.weight = weight;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Float getWeight() {
		return weight;
	}
	
	public void setWeight(Float weight) {
		this.weight = weight;
	}

}
