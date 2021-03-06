package br.com.suhmoraes.desafioorangetalents.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.suhmoraes.desafioorangetalents.DesafioorangetalentsApplication;
import br.com.suhmoraes.desafioorangetalents.domain.UserEntity;
import br.com.suhmoraes.desafioorangetalents.repository.UsersRepository;

@SpringBootTest
class UserRetrievalServiceTest extends DesafioorangetalentsApplication {
	    @Autowired
	    private UserRetrievalService service;

	    @Autowired
	    private UsersRepository repository;

	    private UserEntity autoCreated;

	    @BeforeEach
	    private void setup() {
	        this.repository.deleteAll();

	        this.autoCreated = new UserEntity(
	        		 "Mariana Lima",
	                 "marilima@gmail.com",
	                 "01204112811",
	                 LocalDate.of(1998, Month.FEBRUARY, 20)  
	        );

	        this.repository.save(autoCreated);
	    }

	    @Test
	    public void testShouldRetrieveUserById() {
	        // given
	        String id = "01204112811";

	        // when
	        UserEntity entity = this.service.findById(id);

	        // then
	        assertNotNull(entity);
	        assertEquals(this.autoCreated, entity);
	    }

	    @Test
	    public void testShouldThrowErrorByRetrievingUserByUnknownId() {
	        // given
	        String id = "1111111111";

	        // when
	        Exception thrown = null;
	        UserEntity found = null;
	        try {
	            this.service.findById(id);
	        } catch (Exception ex) {
	            thrown = ex;
	        }

	        // then
	        assertNull(found);
	        assertNotNull(thrown);
	        assertEquals("Usu??rio N??o encontrado", thrown.getMessage());
	    }
	
}
