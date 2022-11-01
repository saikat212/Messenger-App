
package myclient1;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.UnknownHostException;



public class MyClient1 extends Application {
        
    public static Socket s;
            
            
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
     
    }

 
    public static void main(String[] args) throws IOException {
        s=new Socket("127.0.0.1",5110);
        launch(args);
    }
    
}
