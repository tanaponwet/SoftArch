import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;
import java.util.regex.Pattern;

public class NumberSubscriber extends StringSubscriber {

    NumberSubscriber(long bufferSize, FileWriter writer) {
        super(bufferSize, writer);
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        long initialRequestSize = bufferSize;
        count = bufferSize - bufferSize / 2; // re-request when half consumed
        (this.subscription = subscription).request(initialRequestSize);


    }

    @Override
    public void onNext(String item) {
        if (--count <= 0)
            subscription.request(count = bufferSize - bufferSize / 2);
        try {
            if (Pattern.compile("[0-9]+").matcher(item).find())
                writer.write(item+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "NumberSubscriber";
    }
}