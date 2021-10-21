package edu.parinya.softarchdesign.structural;

public class HealthcareWorkerDecorator extends HealthcareWorker{

    protected HealthcareWorker worker;

    public HealthcareWorkerDecorator(HealthcareWorker worker){
        super(worker);
        this.worker = worker;
    }

    public void service(){
        worker.service();
    }

    @Override
    public double getPrice(){
        return worker.getPrice();
    }
}
