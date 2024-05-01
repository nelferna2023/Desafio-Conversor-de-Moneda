package com.aluracursos.desafio.modelos;

public class ClaseJson1 {
    private String result;//se crean las variables acuerdo el valor de la variable en el Json, se debe observar
    //la estructura del json para poder crear la clase con las variables
    private String documentation;
    private Conversion_Rates conversion_rates;

    // Getters
    public String getResult() { return result; }
    public String getDocumentation() { return documentation; }

    //public Time_to_live getTime_to_live() { return time_to_live; }
    public Conversion_Rates getConversion_Rates() { return conversion_rates; }

    public static class Conversion_Rates {//conversion_rates es un objeto tipo clase, por lo tanto internamente creamos sus variables para poder invocarlos

        private double USD; // Use the actual currency code as a variable name

        public double getUSD() { // Use the actual currency code as a method name
            return USD;
        }

        private double ARS;

        public double getARS() { // Use the actual currency code as a method name
            return ARS;
        }

        private double COP;

        public double getCOP() { // Use the actual currency code as a method name
            return COP;
        }

        private double BRL;

        public double getBRL() { // Use the actual currency code as a method name
            return BRL;
        }



    }


    }

