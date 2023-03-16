package tools;

import java.util.*;

public class Publisher {
    private Set<Subscriber> subscribers = new HashSet<>();//In this scenario, an arraylist could be used as the order of the "subscriber" does not matter as much

    public void notifySubscribers() {
        for (Subscriber s: subscribers){
            s.update();
        }
    }
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }
    public void unSubscribe(Subscriber s) {
        subscribers.remove(s);
    }
}
