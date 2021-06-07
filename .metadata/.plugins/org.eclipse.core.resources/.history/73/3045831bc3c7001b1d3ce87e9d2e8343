package br.com.suhmoraes.desafioorangetalents.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.suhmoraes.desafioorangetalents.client.model.CarBrand;
import br.com.suhmoraes.desafioorangetalents.client.model.CarsModelsResponse;

@FeignClient(name = "fipeClient", url =  "${fipe-api.url}")
public interface FipeClient {
	
	@GetMapping("/carros/marcas")
	List<CarBrand> findCarsBrands();
	
	@GetMapping("/carros/marcas/{carBrandCode}/modelos")
	CarsModelsResponse findCarBrandModels(@PathVariable("carBrandCode") final String carBranCode);
}
