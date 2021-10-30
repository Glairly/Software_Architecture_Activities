import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class StringPublisher implements Flow.Publisher {

    private final List<Flow.Subscriber<String> > subscribers;

    private String state;

    public StringPublisher(){
        this.subscribers = new ArrayList<>();
    }

    public StringPublisher(List<Flow.Subscriber<String>> subscribers) {
        this.subscribers = subscribers;
    }


    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        if(subscriber == null || subscribers.contains(subscriber))  subscriber.onError(new IllegalStateException());
        subscribers.add(subscriber);
        subscriber.onSubscribe(new StringSubscription(subscriber));
    }

    public void unsubscribe(Flow.Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void submit(String state){
        this.state = state;
        notifySubscribers();
    }

    public void notifySubscribers(){
        for(var sub : subscribers){
//            sub.update()
            sub.onNext(this.state);
            sub.onComplete();
        }
    }
}
