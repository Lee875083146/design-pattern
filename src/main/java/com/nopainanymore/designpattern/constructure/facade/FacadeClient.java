package com.nopainanymore.designpattern.constructure.facade;

import lombok.extern.slf4j.Slf4j;

/**
 * design-pattern: FacadeClient
 *
 * @author nopainanymore
 * @version 2019-10-21 19:38
 */
@Slf4j
public class FacadeClient {

    public static void main(String[] args) {
        Task task = new Task("s", 1);
        TaskFacade taskFacade = new TaskFacade();
        taskFacade.verify(task);
    }
}
