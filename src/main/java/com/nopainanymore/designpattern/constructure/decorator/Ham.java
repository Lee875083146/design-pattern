package com.nopainanymore.designpattern.constructure.decorator;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * design-pattern: Ham
 *
 * @author nopainanymore
 * @version 2019-07-22 22:08
 */
@Slf4j
public class Ham extends PancakeRawMaterial {

    public Ham(RawMaterial rawMaterial) {
        super(rawMaterial);
    }

    @Override
    public BigDecimal costMoney() {
        moreProtein();
        log.info("ADD Ham- costMoney- $3");
        return rawMaterial.costMoney().add(BigDecimal.valueOf(3));
    }

    public void moreProtein() {
        log.info("Ham- moreProtein");
    }
}
