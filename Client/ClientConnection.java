
package myclient1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnection {
    public static Socket s;

    public ClientConnection() throws UnknownHostException, IOException  {
          s=new Socket("127.0.0.1",5110);
    }

    
    
   




    
    
}
