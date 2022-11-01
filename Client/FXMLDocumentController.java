/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient1;

import myserver1.LMessage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author SAIKAT
 */
public class FXMLDocumentController implements Initializable {

    
    
    @FXML
    private AnchorPane Maincontent;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
       
    }    

    @FXML
    private void LMsg_ButtonAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("LMessage_page.fxml"));
        Maincontent.getChildren().setAll(root);
        
    }

    @FXML
    private void SMsg_ButtonAction(ActionEvent event) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("SMessage_page.fxml"));
        Maincontent.getChildren().setAll(root);
    }

    @FXML
    private void BMsg_ButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("BMessage_page.fxml"));
        Maincontent.getChildren().setAll(root);
    }

    @FXML
    private void CMsg_ButtonAction(ActionEvent event) {
         System.out.println("a");
    }





  
    
}
