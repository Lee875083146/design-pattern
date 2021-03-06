package com.nopainanymore.designpattern.creation.builder;

/**
 * design-pattern: CarBuilder
 *
 * @author nopainanymore
 * @version 2019-07-23 21:00
 */
public interface CarBuilder {

    void buildBrad();

    void buildCarBody();

    void buildCarHeadLight();

    void buildCarWheel();

    Car buildCar();
}
