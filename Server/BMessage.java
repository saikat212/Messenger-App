/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myserver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import static myserver1.MyServer1.newClientList;
/**
 *
 * @author SAIKAT
 */
public class BMessage {
    
    public void BMessage_Action(String str,Socket s,DataInputStream dis,DataOutputStream dos,int cn) throws IOException
    {
        String str1=str;
        String text=str1.substring(3);
        if(newClientList.get(cn-1).getType().equals("admin"))
        {
            for (LMessage lMessage : newClientList) {
                if(!(newClientList.get(cn-1).equals(lMessage)))
                {
                    dos.writeUTF(cn+"-th Client:::"+text);
                }
                
            }
        }
    }
    
}
