import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPServer {//写到客户端

    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            while (true) {
                Socket s =ss.accept();
                System.out.println("A client is accept!!!");
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF("Hello,"+s.getInetAddress() + " Client Port#" + s.getPort() + "bye-bye!");
                dos.close();
                s.close();
            }
        }catch (ConnectException e){
            e.printStackTrace();
            System.out.println("服务器连接失败！");
        }catch (IOException e1){
            e1.printStackTrace();
        }


    }
}