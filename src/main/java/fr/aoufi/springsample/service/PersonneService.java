package fr.aoufi.springsample.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import fr.aoufi.springsample.model.Personne;

public interface PersonneService {

	void save(Personne personne) throws JsonProcessingException;

}
