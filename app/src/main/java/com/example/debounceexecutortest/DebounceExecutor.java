package com.example.debounceexecutortest;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

    public class DebounceExecutor {
        private  ScheduledFuture<Object> future;
        private ScheduledExecutorService executor;

        DebounceExecutor(ScheduledExecutorService executor) {
            this.executor = executor;
        }

        public  void cancel() {
            if (future != null && !future.isDone())
                future.cancel(false);
        }

        public  ScheduledFuture<Object> debounce(long delay, Callable<Object> task) {
            if (future != null && !future.isDone()) {
                future.cancel(false);
            }
            future = executor.schedule(task, delay, TimeUnit.MILLISECONDS);
            return future;
        }

    }



