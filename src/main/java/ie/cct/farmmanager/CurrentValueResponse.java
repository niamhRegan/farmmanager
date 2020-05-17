package ie.cct.farmmanager;

public class CurrentValueResponse {

	private Float currentValue;

	public CurrentValueResponse() {
	}
	
	public CurrentValueResponse(Float currentValue) {
		super();
		this.currentValue = currentValue;
	}
	
	public Float getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Float currentValue) {
		this.currentValue = currentValue;
	}
	
}
