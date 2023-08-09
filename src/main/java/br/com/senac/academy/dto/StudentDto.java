package br.com.senac.academy.dto;

import lombok.Getter;
import lombok.Setter;

public class StudentDto
{
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surname;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
