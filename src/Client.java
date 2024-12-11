import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args){
        try(Socket ss = new Socket("localhost",6969)){
            BufferedReader ui = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(ss.getOutputStream());
            new Thread(new MsgReceiver(ss)).start();
            while(true){
                String msg = ui.readLine();
                out.writeBytes(msg + "\n");
            }

        }catch(IOException e){
            System.out.println("Errore di connessione");
        }
    }
}