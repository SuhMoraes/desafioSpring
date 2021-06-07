package br.com.suhmoraes.desafioorangetalents.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarBrand {
	
	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("codigo")
	private String code;

	public CarBrand() {		
		this.name = "";
		this.code = "";
	}


	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
	
	
	
}
