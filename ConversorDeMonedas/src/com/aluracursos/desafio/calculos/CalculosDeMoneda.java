package com.aluracursos.desafio.calculos;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Dictionary;

public class CalculosDeMoneda {
    private double valorAConvertir;
    private double resultadoConvertido;
    private double valorUSD;
    private double valorARS;
    private double valorBRL;
    private double valorCOP;

    public double getValorUSD() {
        return valorUSD;
    }

    public void setValorUSD(double valorUSD) {
        this.valorUSD = valorUSD;
    }

    public double getValorARS() {
        return valorARS;
    }

    public void setValorARS(double valorARS) {
        this.valorARS = valorARS;
    }

    public double getValorBRL() {
        return valorBRL;
    }

    public void setValorBRL(double valorBRL) {
        this.valorBRL = valorBRL;
    }

    public double getValorCOP() {
        return valorCOP;
    }

    public void setValorCOP(double valorCOP) {
        this.valorCOP = valorCOP;
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



    public double metodoConversionCOPADollar(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir / valorCOP;
        return resultadoConvertido;

    }

    public double metodoConversionDollarACOP(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir *valorCOP;
        return resultadoConvertido;

    }

    public double metodoConversionARSADollar(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir / valorARS;
        return resultadoConvertido;

    }

    public double metodoConversionDollarAARS(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir *valorARS;
        return resultadoConvertido;

    }

    public double metodoConversionBRLADollar(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir / valorBRL;
        return resultadoConvertido;

    }

    public double metodoConversionDollarABRL(double valorAConvertir){

        this.resultadoConvertido= valorAConvertir *valorBRL;
        return resultadoConvertido;

    }


}
