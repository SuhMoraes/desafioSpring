package br.com.suhmoraes.desafioorangetalents.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.suhmoraes.desafioorangetalents.domain.UserEntity;


@SpringBootTest
class UserCreatorServiceTest {
    @Autowired
    private UserCreatorService service;

     @Test
    public void testShouldCreateANewUser() {
        // given
        UserEntity entity = new UserEntity(
                "Mariana Lima",
                "marilima@gmail.com",
                "01204112811",
                LocalDate.of(1998, Month.FEBRUARY, 20)        );

        // when
        UserEntity created = this.service.create(entity);

        // then
        assertEquals(entity, created);
    }


     @Test
     public void testShouldNotCreateAnInvalidNewUser() {
         // given
         UserEntity entity = new UserEntity(
                 null,
                 "douglasf.filho@gmail.com",
                 "08468331406",
                 LocalDate.of(1991, Month.FEBRUARY, 20)
         );

         // when
         UserEntity created = null;
         Exception thrown = null;
         try {
             created = this.service.create(entity);
         } catch (Exception ex) {
             thrown = ex;
         }

         // then
         assertNull(created);
         assertNotNull(thrown);
     }

     
     

}
