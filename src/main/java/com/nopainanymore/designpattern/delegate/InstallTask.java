package com.nopainanymore.designpattern.delegate;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * design-pattern: InstallTask
 *
 * @author nopainanymore
 * @version 2019-07-13 22:37
 */
@Data
@Slf4j
public class InstallTask implements Task {

    @Override
    public void runTask() {
        log.info("InstallTask- runTask- installing");
    }
}
