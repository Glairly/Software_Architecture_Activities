
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeLoggingHealthcareWorker extends HealthcareWorkerDecorator {

    public TimeLoggingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
        System.out.println("Decorate " + worker.getName() + " with TimeLogging.");
    }

    @Override
    public void service() {
        Date date = new Date();
        var dateformat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH);
        System.out.print(dateformat.format(date) + ": ");
        super.service();
    }
}
