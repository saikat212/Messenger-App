
package myserver1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.Objects;
import static myserver1.MyServer1.newClientList;
import static myserver1.RegisteredClient.RegisterList;


public class LMessage implements Serializable {
    String username;
    String password;
    String type;

    public LMessage(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public LMessage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void amni()
    {
        System.out.println("yes work done");
    }

    @Override
    public String toString() {
        return "LMessage{" + "username=" + username + ", password=" + password + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LMessage other = (LMessage) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
    public void LMessageAction(LMessage LM,Socket s1,DataInputStream dis1,DataOutputStream dos1) throws IOException
    {
          Socket s=s1;
          DataInputStream dis=dis1;
          DataOutputStream dos=dos1;
         
        
          boolean is_register=false;
          boolean is_login=false;
           
         
            
          for (LMessage rml : RegisterList) {
                
                if(LM.equals(rml))
                {
                    is_register=true;
                    break;
                    
                }
            }
         
           if(newClientList.isEmpty())
                     { 
                         is_login=false;
                        
                          
                }
                     else
                     {
                         for (LMessage ncl : newClientList) {
                     
                        
                        if(LM.equals(ncl))
                        {  
                            is_login=true;
                            break;
                            
                        }
                        
                         }
                     }
                         
                         if(is_register==true && is_login==false)
                         {
                             dos.writeUTF("Login Successful");
                             MyServer1.newClientList.add(LM);
                             
                             dos.flush();
                         }
                         
                         if(is_register==true && is_login==true)
                         {
                             dos.writeUTF("Already Login");
                             
                             dos.flush();
                         }
                         
                         if(is_register==false && is_login==false)
                         {
                             dos.writeUTF("Login failed.complete register.");
                            
                             dos.flush();
                         }   
  
        
    }
    
        
    
}
