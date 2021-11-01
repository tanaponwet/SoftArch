import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter word enter cancel to cancel Program");//อยากให้หยุดโปรแกรมให้พิมพ์ว่า cancel
        String username = myObj.nextLine();
        while (!username.equals("cancel")){
            try {
                StringPublisher publisher = new StringPublisher();
                StringSubscriber alphabet = new AlphabetSubscriber(64,new FileWriter("alphabet.txt",true));
                StringSubscriber number = new NumberSubscriber(64,new FileWriter("number.txt",true));
                StringSubscriber symbol = new SymbolSubscriber(64,new FileWriter("symbol.txt",true));
                publisher.subscribe(alphabet);
                publisher.subscribe(number);
                publisher.subscribe(symbol);
                publisher.publish(username);

            } catch (IOException e) {

                e.printStackTrace();
            }
            username = myObj.nextLine();
        }













    }
}