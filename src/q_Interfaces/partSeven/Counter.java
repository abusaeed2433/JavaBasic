package q_Interfaces.partSeven;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Counter {

    private int delayBetween = 2000;

    private int maxCountValue;
    private int currentValue = 1;
    private boolean isRunning;

    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    private final CounterListener listener;

    public Counter(int delayBetween,CounterListener listener) {
        this.delayBetween = delayBetween;
        this.listener = listener;
    }

    public void startCounter(int maxCountValue){
        this.maxCountValue = maxCountValue;
        if(isRunning) {
            listener.onMessageFound("Counter already running");
            return;
        }
        startRunning();
        isRunning = true;
    }

    public void stopCounter(){
        if(!isRunning) return;

        isRunning = false;
        executor.shutdown();
        currentValue = 1;
        listener.onMessageFound("Counter stopped");
    }

    private void startRunning(){
        if(currentValue >= maxCountValue) return;

        isRunning = true;
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                currentValue++;
                listener.onTimeChanged(currentValue);
                if(currentValue >= maxCountValue) {
                    isRunning = false;
                    executor.shutdown();
                }
            }
        },0, delayBetween,TimeUnit.MILLISECONDS);
    }

    public void changeCounterValue(int maxCountValue) {
        this.maxCountValue = maxCountValue;
    }

    public void setDelayBetween(int delayBetween) {
        this.delayBetween = delayBetween;
    }

    public CounterListener getListener() {
        return listener;
    }

}
