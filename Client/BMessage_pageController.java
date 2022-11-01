/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author SAIKAT
 */
public class BMessage_pageController implements Initializable {

    @FXML
    private TextField BMessage_text;
    @FXML
    private TextField BMmessage_see;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BMessage_send_Action(ActionEvent event) throws IOException {
        String str=BMessage_text.getText();
        String str1="#B#"+str;
          
         DataOutputStream dos =new DataOutputStream(MyClient1.s.getOutputStream());
          DataInputStream dis=new DataInputStream(MyClient1.s.getInputStream());
        
         dos.writeUTF(str1);
         dos.flush();
         String Bmsg_from_another=dis.readUTF();
         BMmessage_see.setText(Bmsg_from_another);
         
        
    }
    
}
