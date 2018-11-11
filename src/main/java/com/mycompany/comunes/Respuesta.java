/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comunes;

/**
 *
 * @author LAPTOP
 */
public class Respuesta {
    
    int codigo;
    String respuesta;

    public Respuesta() {
        this.codigo = 1;
        this.respuesta = "CORRECTO";
    }

    public Respuesta(int codigo, String respuesta) {
        this.codigo = codigo;
        this.respuesta = respuesta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public void setError(String r){
        this.codigo = 0;
        this.respuesta = r;
    }

    @Override
    public String toString() {
        return codigo + "-" + respuesta ;
    }
    
    
    
}
