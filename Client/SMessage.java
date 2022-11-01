
package myclient1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import myserver1.LMessage;
import static myserver1.MyServer1.newClientList;

/**
 *
 * @author SAIKAT
 */
public class SMessage {
    public void SMessage_Action(String st,Socket s1,DataInputStream dis1,DataOutputStream dos1,int cn) throws IOException
    {
        DataInputStream dis=dis1;
        DataOutputStream dos=dos1;
        String client_Lmessage=st;
        int Client_no=cn;
         if(client_Lmessage.charAt(3)=='T')
                {
                    String str=client_Lmessage.substring(6);
                    System.out.println(Client_no+"-th "+"Client SMessage Text sent for Server: "+str);
                }
                 if(client_Lmessage.charAt(3)=='S')
                {
                    String str="";
                    for (LMessage lMessage : newClientList) {
                        str+=lMessage.getUsername()+"#";
                        
                    }
                    dos.writeUTF(str);
                    
                }
                  if(client_Lmessage.charAt(3)=='O')
                {
                    newClientList.remove(Client_no-1);
                    System.out.println("Client No: "+Client_no+" Logout ");
                    dos.writeUTF("Logout");
                    dos.flush();
                }

    }
}
