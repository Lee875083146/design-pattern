package com.nopainanymore.designpattern.behavior.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * design-pattern: RadioObserver
 *
 * @author nopainanymore
 * @version 2019-07-11 22:51
 */
@Slf4j
public class RadioObserver implements Observer {

    @Override
    public void update(WeatherMetaData weatherMetaData) {
        log.info("RadioObserver-  now weather - temperature:{},  humidity:{} , pressure:{}", weatherMetaData.getTemperature(), weatherMetaData.getHumidity(), weatherMetaData.getPressure());
    }
}
