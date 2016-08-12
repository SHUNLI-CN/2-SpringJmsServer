package fr.aoufi.springsample.service;

import org.springframework.jms.core.JmsTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.aoufi.springsample.model.Personne;

public class PersonneServiceImpl implements PersonneService {

	private JmsTemplate jmsTemplate;

	private ObjectMapper objectMapper;

	public PersonneServiceImpl(JmsTemplate jmsTemplate, ObjectMapper objectMapper) {
		this.jmsTemplate = jmsTemplate;
		this.objectMapper = objectMapper;
	}

	@Override
	public void save(Personne personne) throws JsonProcessingException {
		String message = objectMapper.writeValueAsString(personne);
		jmsTemplate.convertAndSend("personneQueue", message);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

}
