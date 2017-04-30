package com.rafsanjani.anwar.model;

public class Model {

    public Double processPercentage(Double value) {

        return (value * 0.01);
    }

    public Double processConversion(Double value) {

        return (value * (-1));
    }

    public Double getAddition(Double a, Double b) {

        return a + b;
    }

    public Double getSubtraction(Double a, Double b) {

        return a - b;
    }

    public Double getMultiplication(Double a, Double b) {

        return a * b;
    }

    public Double getDivision(Double a, Double b) {

        return a / b;
    }
}
