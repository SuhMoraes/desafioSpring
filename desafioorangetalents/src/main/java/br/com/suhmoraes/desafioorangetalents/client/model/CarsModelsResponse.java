package br.com.suhmoraes.desafioorangetalents.client.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarsModelsResponse {

	@JsonProperty("modelos")
	private List<CarModel> models;
	
	public CarsModelsResponse() {
		this.models = new ArrayList<>();
	}

	public List<CarModel> getModels() {
		return models;
	}
	
	
}

