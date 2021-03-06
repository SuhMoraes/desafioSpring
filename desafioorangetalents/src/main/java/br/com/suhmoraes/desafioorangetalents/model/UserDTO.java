package br.com.suhmoraes.desafioorangetalents.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;



public class UserDTO {

    @NotBlank(message = "O campo nome deve ser válido")
    @Size(min = 5, max = 255, message = "O campo nome deve ter no mínimo 5 letras e no máximo 255 letras")
    public String name;

    @NotBlank(message = "Informe um e-mail válido")
    @Email(message = "Informe um e-mail válido")
    @Size(max = 255, message = "O campo email deve ter no máximo 255 letras")
    public String email;

    @CPF(message = "Informe CPF válido")
    @NotBlank(message = "Informe um CPF válido")
    public String registerId;

    @NotBlank(message = "Informe uma data de nascimento válida")
    public LocalDate birthDate;

}