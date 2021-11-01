import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Flow.Subscription;
import java.util.regex.Pattern;

public class SymbolSubscriber extends StringSubscriber{

    SymbolSubscriber(long bufferSize, FileWriter writer) {
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
            if (Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(item).find())
                writer.write(item+"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "SymbolSubscriber";
    }
}