public class TaxPayingHealthcareWorker extends HealthcareWorkerDecorator {

    public TaxPayingHealthcareWorker(HealthcareWorker worker) {
        super(worker);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 1.10;
    }
}
