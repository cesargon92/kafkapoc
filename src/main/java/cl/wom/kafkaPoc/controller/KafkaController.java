package cl.wom.kafkaPoc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.wom.kafkaPoc.producer.KafkaProducer;
import cl.wom.kafkaPoc.to.ResponseKafkaProducerTO;

@RestController
@RequestMapping(path = "/producer")
public class KafkaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaController.class);
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping(path = "/send")
	public ResponseEntity<ResponseKafkaProducerTO> envioNotificacion(){
		LOGGER.info("[envioRegistro] -  : inicio del envio de la notificacion");
		return new ResponseEntity<>(kafkaProducer.send("Holi"), HttpStatus.OK);
	}
}
