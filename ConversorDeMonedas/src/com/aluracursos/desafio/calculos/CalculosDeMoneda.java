package com.aluracursos.desafio.calculos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Dictionary;

public class CalculosDeMoneda {
    private double valorAConvertir;
    private double resultadoConvertido;
    private Dictionary listaValorDolar;
    @SerializedName("Title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getValorAConvertir() {
        return valorAConvertir;
    }

    public void setValorAConvertir(double valorAConvertir) {
        this.valorAConvertir = valorAConvertir;
    }

    public double getResultadoConvertido() {
        return resultadoConvertido;
    }

    public void setResultadoConvertido(double resultadoConvertido) {
        this.resultadoConvertido = resultadoConvertido;
    }

    public Dictionary getListaValorDolar() {
        return listaValorDolar;
    }

    public void setListaValorDolar(Dictionary listaValorDolar) {
        this.listaValorDolar = listaValorDolar;
    }

    public void dolarAPesoArgentino(double valorAConvertir,Dictionary listaValorDolar){
        this.resultadoConvertido=valorAConvertir* (double) listaValorDolar.get("ARS");




    }
}
