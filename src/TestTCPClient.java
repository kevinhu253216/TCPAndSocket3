import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TestTCPClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1",6666);

            InputStream is = s.getInputStream();
            DataInputStream dis =new DataInputStream(is);
            System.out.println(dis.readUTF());

            dis.close();
            s.close();
        }catch (ConnectException e){
            e.printStackTrace();
            System.err.println("服务器连接失败！");
        }catch (IOException e1){
            e1.printStackTrace();
        }

    }


}