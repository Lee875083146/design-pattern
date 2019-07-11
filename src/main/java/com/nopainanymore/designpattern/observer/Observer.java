package com.nopainanymore.designpattern.observer;

/**
 * design-pattern: Observer
 *
 * @author NoPainAnymore
 * @date 2019-07-11 22:41
 */
public interface Observer {

    void update(float temperature, float humidity, float pressure);
}
