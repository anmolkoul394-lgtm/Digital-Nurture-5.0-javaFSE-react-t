// ObserverDemo.java
// Demonstrates the Observer Design Pattern.
// YouTubeChannel is the "Subject" - it maintains a list of Subscribers ("Observers")
// and notifies ALL of them automatically whenever a new video is uploaded.

import java.util.ArrayList;
import java.util.List;

// Observer interface - anyone who wants to "listen" for updates implements this.
interface Subscriber {
    void update(String videoTitle);
}

// Concrete Observer
class ChannelSubscriber implements Subscriber {
    private String name;

    public ChannelSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + ": Notified about new video - " + videoTitle);
    }
}

// Subject - keeps track of observers and notifies them of changes.
class YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Called when the channel uploads a new video - notifies EVERY subscriber.
    public void uploadVideo(String videoTitle) {
        System.out.println("--- New video uploaded: \"" + videoTitle + "\" ---");
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Subscriber alice = new ChannelSubscriber("Alice");
        Subscriber bob = new ChannelSubscriber("Bob");

        channel.subscribe(alice);
        System.out.println("Alice has subscribed.");

        channel.subscribe(bob);
        System.out.println("Bob has subscribed.");

        // Both Alice and Bob get notified automatically.
        channel.uploadVideo("Java Design Patterns Tutorial");
    }
}
