/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class SMessage_pageController implements Initializable {
   
    @FXML
    private TextField text;
    @FXML
    private ListView<String> listView;
    ObservableList<String> list=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Show_Button_Action(ActionEvent event) throws IOException {
        
        String str1="#S#"+"S";
          boolean isSimilar=false;
         DataOutputStream dos =new DataOutputStream(MyClient1.s.getOutputStream());
        
         dos.writeUTF(str1);
         dos.flush();
         
         DataInputStream dis=new DataInputStream(MyClient1.s.getInputStream());
         String login_username=dis.readUTF();
         
          String[] name=login_username.split("#");
          for (String string : name) {
      
             
             
           list.add(string);
            
        }
          listView.setItems(list);
         
         
    }

    @FXML
    private void Logout_ButtonAction(ActionEvent event) throws IOException {
          String str1="#S#"+"O";
          
         DataOutputStream dos =new DataOutputStream(MyClient1.s.getOutputStream());
        
         dos.writeUTF(str1);
         dos.flush();
        DataInputStream dis=new DataInputStream(MyClient1.s.getInputStream());
        String lout=dis.readUTF();
        if(lout.equals("Logout"))
        {
            
        }
        
    }

    @FXML
    private void SMSG_send_action(ActionEvent event) throws IOException {
         String str=text.getText();
         
         String str1="#S#"+"T"+"##"+str;
          
         DataOutputStream dos =new DataOutputStream(MyClient1.s.getOutputStream());
        
         dos.writeUTF(str1);
         dos.flush();
          
        
    }
    
}
