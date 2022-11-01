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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class LMessage_pageController implements Initializable {

    @FXML
    private Label label1;

  
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField type;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void Login_Button_Action(ActionEvent event) throws IOException {
        
        
         String name=username.getText();
         String pass=password.getText();
         String typ=type.getText();
         
         String lm="#L#"+name+"##"+pass+"##"+typ;
        
        
         
          
         DataOutputStream dos =new DataOutputStream(MyClient1.s.getOutputStream());
         DataInputStream dis =new DataInputStream(MyClient1.s.getInputStream());
         dos.writeUTF(lm);
         dos.flush();
 
        
         
         String LM_msg_result=dis.readUTF();
         label1.setText(LM_msg_result);
          
        
    }
    
}
