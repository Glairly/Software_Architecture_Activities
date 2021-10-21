import java.util.LinkedHashSet;
import java.util.Set;

public class HealthcareWorkerTeam implements HealthcareServiceable {

    private Set<HealthcareServiceable> members;

    public HealthcareWorkerTeam(){
        members = new LinkedHashSet<>();
    };

    public void addMember(HealthcareServiceable worker){
        members.add(worker);
    };

    public void removeMember(HealthcareServiceable worker){
        members.remove(worker);
    };

    public void service(){
        for(var o : members) {
            o.service();
        }
    };

    public double getPrice(){
        double totalPrice = 0;
        for(var o : members) {
           totalPrice += o.getPrice();
        }
        return totalPrice;
    };
}
