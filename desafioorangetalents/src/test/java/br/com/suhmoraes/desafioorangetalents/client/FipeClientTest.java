package br.com.suhmoraes.desafioorangetalents.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.suhmoraes.desafioorangetalents.client.model.CarBrand;
import br.com.suhmoraes.desafioorangetalents.client.model.CarModel;
import br.com.suhmoraes.desafioorangetalents.client.model.CarYear;
import br.com.suhmoraes.desafioorangetalents.client.model.CarsModelsResponse;


@SpringBootTest
class FipeClientTest {

	@Autowired
	private FipeClient fipeClient;	
	
	@Test
	public void testClientShouldFindCarsBrands() {
		// when		
		List<CarBrand> carsBrands = this.fipeClient.findCarsBrands();
		
		
		// Then
		assertEquals(90, carsBrands.size());
		
		CarBrand acura = carsBrands.stream()
				.filter(carBrand -> carBrand.getCode().equals("1"))
				.collect(Collectors.toList())
				.get(0);
		
		assertEquals("Acura", acura.getName());
	}
	
	@Test
	public void testClientShouldFindCarBrandModelsByCarBrandCode() {
		// given
		final String carBrandCode = "1";
		
		// when
		final CarsModelsResponse response = this.fipeClient.findCarBrandModels(carBrandCode);
		
		
		//then
		List<CarModel> models = response.getModels();
		
		assertEquals(3, models.size());
		
		CarModel model = models.stream()
				.filter(carModel -> carModel.getCode().equals("2"))
				.collect(Collectors.toList())
				.get(0);
		
		assertEquals("Legend 3.2/3.5", model.getName());
	}
	
	
	@Test
	public void testClientShouldFindCarsYearByCarBrandCodeAndModelCode() {
		// given
		final String carBrandCode = "1";
		final String carModelCode = "2";
	
		//when
		final List<CarYear> carYears = this.fipeClient.findCarModelYearsByCarBrandCodeAndCarModelCode(
				carBrandCode,
				carModelCode
		);
		
		// then
		assertEquals(8, carYears.size());
		
		CarYear carYear = carYears
				.stream()
				.filter(year -> year.getCode().equals("1997-1"))
				.collect(Collectors.toList())
				.get(0);
		
		assertEquals("1997 Gasolina", carYear.getName());
	}

	
	

	
}

































