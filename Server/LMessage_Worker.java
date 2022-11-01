
package myserver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author SAIKAT
 */
class LMessage_Worker implements Runnable {
    
    DataInputStream dis;
    DataOutputStream dos;
    Socket s;


    public LMessage_Worker(Socket s1, DataInputStream dis1, DataOutputStream dos1) {
        
        dis=dis1;
        dos=dos1;
        s=s1;
        
    }

    @Override
    public void run() {
       
        
    }
    
    
    
}
