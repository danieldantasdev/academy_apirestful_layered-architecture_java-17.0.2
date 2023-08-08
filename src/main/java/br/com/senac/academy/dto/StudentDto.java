package br.com.senac.academy.dto;

import lombok.Getter;
import lombok.Setter;

public class StudentDto
{
    @Getter
    @Setter
    private Integer _id;
    @Getter
    @Setter
    private String _name;
    @Getter
    @Setter
    private String _surName;
    private String _email;

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
}
