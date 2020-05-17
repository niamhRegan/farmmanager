package ie.cct.farmmanager;

public class AverageWeightResponse {

	private String type;
	private Float avgWeight;


	public AverageWeightResponse() {		
	}
	
	public AverageWeightResponse(String type, Float avgWeight) {
		super();
		this.type = type;
		this.avgWeight = avgWeight;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Float getAvgWeight() {
		return avgWeight;
	}
	public void setAvgWeight(Float avgWeight) {
		this.avgWeight = avgWeight;
	}
	
}
