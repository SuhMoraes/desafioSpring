package br.com.suhmoraes.desafioorangetalents.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.suhmoraes.desafioorangetalents.client.model.CarBrand;
import br.com.suhmoraes.desafioorangetalents.client.model.CarModel;
import br.com.suhmoraes.desafioorangetalents.client.model.CarYear;


@SpringBootTest
class FipeServiceTest {
	
	@Autowired
	private FipeService fipeService;
	
	@Test
	public void testShouldFindCarBrandByName() {
		// given
		final String carNameBrand = "Acura";
		
		// When
		final CarBrand found = this.fipeService.findCarBrandByName(carNameBrand);
		
		//then
		assertEquals("Acura", found.getName());
		assertEquals("1", found.getCode());
		
	
	}
	
	@Test
	public void testShouldFindCarBrandByUnknownName() {
		// given
		final String carNameBrand = "unknown";
		
		// When
		RuntimeException thrown = null;
		try {
		
			this.fipeService.findCarBrandByName(carNameBrand);
		} catch (RuntimeException ex) {
			thrown = ex;
		}
		
		//then
		
		assertNotNull(thrown);
		assertEquals("Marca não encontrada", thrown.getMessage());		
	
	}


	@Test
	public void testClientShouldFindCarModelsByCarBrandCodeAndCarModelName() {
		// given
		final String carBrandCode = "1";
		final String carModelName = "Legend 3.2/3.5";
		
		// when
		CarModel carModel = this.fipeService.findCarModelByCarBrandCodeAndCarModelName(carBrandCode, carModelName);
		
		
		
		//then
		assertEquals("2", carModel.getCode());
	}
	
	@Test
	public void testClientShouldNotFindCarModelsByCarBrandCodeAndUnknownCarModelName() {
		// given
		final String carBrandCode = "1";
		final String carModelName = "unknown";
		
		// when
		RuntimeException thrown = null;
		try {
		
			this.fipeService.findCarModelByCarBrandCodeAndCarModelName(carBrandCode, carModelName);
		} catch (RuntimeException ex) {
			thrown = ex;
		}
		
		//then
		
		assertNotNull(thrown);
		assertEquals("Modelo de carro não encontrado", thrown.getMessage());		
	}
	

    @Test
    public void testShouldFindCarYearByCarBrandCodeAndCarModelCodeAndYear() {
        // given
        final String carBrandCode = "1";
        final String carModelCode = "2";
        final String year = "1997";

        // when
        final CarYear carYear = this.fipeService.findCarYearByCarBrandCodeAndCarModelCodeAndCarYearCodeContains(
                carBrandCode,
                carModelCode,
                year
        );

        // then
        assertEquals("1997-1", carYear.getCode());
        assertEquals("1997 Gasolina", carYear.getName());
    }
	
	@Test
    public void testShouldNotFindCarYearByCarBrandCodeAndCarModelCodeAndUnknownYear() {
        // given
        final String carBrandCode = "1";
        final String carModelCode = "2";
        final String year = "unknown";

        // when
        RuntimeException thrown = null;
        try {
        	this.fipeService.findCarYearByCarBrandCodeAndCarModelCodeAndCarYearCodeContains(
                    carBrandCode,
                    carModelCode,
                    year
            );
        } catch (RuntimeException ex) {
            thrown = ex;
        }

        // then
        assertNotNull(thrown);
        assertEquals("Ano não encontrado para o veículo", thrown.getMessage());
    }
}
		
		
