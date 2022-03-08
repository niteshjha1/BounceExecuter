package com.example.debounceexecutortest;

import static java.sql.DriverManager.println;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public class NiteshNitesh {

    DebounceExecutor  debounceExecutor;

    // How to use
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "Debouncer");
            t.setDaemon(true);
            return t;
        }
    });

    Callable<Object> refreshUICallable = () -> {
        println(Thread.currentThread().getName());
        return null;
    };
//        debounceExecutor.debounce(500,refreshUICallable);

    {
        debounceExecutor = new DebounceExecutor(executor);
        debounceExecutor.debounce(500,refreshUICallable);
    }


}


