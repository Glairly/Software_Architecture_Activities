import java.sql.Timestamp;
import java.util.Date;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
    }

    @Override
    public void service() {
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));
        super.service();
    }
}
