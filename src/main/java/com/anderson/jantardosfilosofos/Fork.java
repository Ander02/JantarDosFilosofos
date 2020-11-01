package com.anderson.jantardosfilosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Pessoa
 */
public class Fork extends Semaphore {

    public Fork() {
        super(1);
    }
}
