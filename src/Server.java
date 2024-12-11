import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class Server {
    public static ServerSocket ss;
    public static int n = new Random().nextInt(999)+1;
    public static ArrayList<DataOutputStream> css = new ArrayList<>();
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(6969)){
            System.out.println("porta 6969 in ascolto");
            while(true){
                Socket sc = ss.accept();
                System.out.println("Nuova connessione :" + sc);
                new Thread(new ClientHandler(sc)).start();
            }
        }catch(Exception e){
            System.out.println("Errore connessione");
        }
    }
}