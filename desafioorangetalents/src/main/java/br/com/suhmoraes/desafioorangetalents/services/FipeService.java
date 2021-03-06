package br.com.suhmoraes.desafioorangetalents.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.suhmoraes.desafioorangetalents.client.FipeClient;
import br.com.suhmoraes.desafioorangetalents.client.model.CarBrand;
import br.com.suhmoraes.desafioorangetalents.client.model.CarModel;
import br.com.suhmoraes.desafioorangetalents.client.model.CarYear;
import br.com.suhmoraes.desafioorangetalents.client.model.CarsModelsResponse;

@Service
public class FipeService {
	private final FipeClient fipeClient;
	
	public FipeService(final FipeClient fipeClient) {
		this.fipeClient = fipeClient;		
	}
	
	public CarBrand findCarBrandByName(final String carBrandName) {
		final List<CarBrand> carsBrands = this.fipeClient.findCarsBrands();
		Optional<CarBrand> carBrand = carsBrands
				.stream().filter(cb -> cb.getName().equals(carBrandName))
				.findFirst();
		return carBrand.orElseThrow(() -> new RuntimeException("Marca não encontrada"));
		
	}
	
	public CarModel findCarModelByCarBrandCodeAndCarModelName(final String carBrandCode, final String carModelName ) {
		final CarsModelsResponse response = this.fipeClient.findCarBrandModels(carBrandCode);
		Optional<CarModel> carModel = response
				.getModels()
				.stream()
				.filter(model -> model.getName().equals(carModelName))
				.findFirst();
		
		return carModel.orElseThrow(() -> new RuntimeException("Modelo de carro não encontrado"));
		
	}
	
	

	public CarYear findCarYearByCarBrandCodeAndCarModelCodeAndCarYearCodeContains(         final String carBrandCode,
            final String carModelCode,
            final String year
    ) {
        final List<CarYear> carYears = this.fipeClient.findCarModelYearsByCarBrandCodeAndCarModelCode(
                carBrandCode,
                carModelCode
        );

        final Optional<CarYear> carYear = carYears
                .stream()
                .filter(cy -> cy.getCode().contains(year))
                .findFirst();

        return carYear.orElseThrow(() ->
                new RuntimeException("Ano não encontrado para o veículo"));
	
	}

}
