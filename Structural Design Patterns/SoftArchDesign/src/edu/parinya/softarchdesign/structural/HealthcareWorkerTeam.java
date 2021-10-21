package edu.parinya.softarchdesign.structural;

import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable{

    private Set<HealthcareServiceable> members = new LinkedHashSet<>();

    public void addMember(HealthcareServiceable h){
        members.add(h);
    }

    public void removeMember(HealthcareServiceable h){
        members.remove(h);
    }

    @Override
    public void service(){
        for (HealthcareServiceable treat : members){
            treat.service();
        }
    }

    @Override
    public double getPrice(){
        double price = 0;
        for (HealthcareServiceable h : members){
            price += h.getPrice();
        }
        return price;
    }

}
