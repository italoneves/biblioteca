package br.com.italo.biblioteca.recurso.exception;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErroPadrao implements Serializable {

    private static final long SerialVersionUID = 1L;

    private LocalDateTime time;
    private String erro;
    private Integer status;


    public ErroPadrao(LocalDateTime time, String erro, Integer status) {
        this.time = time;
        this.erro = erro;
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
