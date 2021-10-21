package edu.parinya.softarchdesign.structural;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator{

    public TimeLoggingHealthcareWorker(HealthcareWorker worker){
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TimeLogging.");
    }

    @Override
    public void service(){
        long time = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(time);
        System.out.println(date + ": " + worker.getName() + " performs a surgery.");
    }
}
