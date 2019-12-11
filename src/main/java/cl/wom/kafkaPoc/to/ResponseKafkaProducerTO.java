package cl.wom.kafkaPoc.to;

import org.springframework.stereotype.Component;

@Component
public class ResponseKafkaProducerTO {
	
	private String responseCode;
	private String responseMessage;
	
	public ResponseKafkaProducerTO() {
		super();
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseKafkaProducerTO [responseCode=");
		builder.append(responseCode);
		builder.append(", responseMessage=");
		builder.append(responseMessage);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
