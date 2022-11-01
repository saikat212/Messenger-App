
package myserver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import myclient1.SMessage;
import static myserver1.MyServer1.newClientList;
import static myserver1.RegisteredClient.RegisterList;


/**
 *
 * @author SAIKAT
 */
public class WorkerThread implements Runnable{
    DataInputStream dis;
    DataOutputStream dos;
    Socket s;
    int Client_no;

    public WorkerThread(Socket s1, DataInputStream dis1, DataOutputStream dos1,int cn) {
        
        dis=dis1;
        dos=dos1;
        s=s1;
        Client_no=cn;
    }

    @Override
    public void run() {
        
       InputStream is;
      while(true)
      {
            
        try {
            is = s.getInputStream();
             
            String client_message=dis.readUTF();
            System.out.println("client: "+client_message);
            
            if(client_message.startsWith("#L#"))
            {
                String lmgs_info=client_message.substring(3);
                System.out.println("main msg: "+lmgs_info);
                String[] lmgs=lmgs_info.split("##");
                LMessage LM=new LMessage(lmgs[0],lmgs[1],lmgs[2]);
                System.out.println("username: "+lmgs[0]);
                System.out.println("pass: "+lmgs[1]);
                System.out.println("type: "+lmgs[2]);
                LM.LMessageAction(LM, s, dis, dos);
                
                
            }
            if(client_message.startsWith("#S#"))
            {
                SMessage smsg=new SMessage();
                smsg.SMessage_Action(client_message,s,dis,dos,Client_no);
            }
            if(client_message.startsWith("#B#"))
            {
                BMessage bmsg=new BMessage();
                bmsg.BMessage_Action(client_message,s,dis,dos,Client_no);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            
      }
          
       
    
  }
}
    
        


    

