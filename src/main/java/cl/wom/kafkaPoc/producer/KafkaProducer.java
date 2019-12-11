package cl.wom.kafkaPoc.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import cl.wom.kafkaPoc.to.ResponseKafkaProducerTO;

public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	private ResponseKafkaProducerTO responseKafkaProducerTO;
	
	@Value("${spring.kafka.template.default-topic}")
	private String kafkaTopic;

	public ResponseKafkaProducerTO send(String mensaje) {
		LOGGER.info("enviando mensaje='{}' al tópico {}", mensaje, kafkaTopic);
		kafkaTemplate.send(kafkaTopic, mensaje);
		
		responseKafkaProducerTO.setResponseCode("Ok");
		responseKafkaProducerTO.setResponseMessage("Success");
		
		return responseKafkaProducerTO;
	}
}
