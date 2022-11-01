
package myserver1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SAIKAT
 */
public class RegisteredClient {
public static  ObservableList<LMessage> RegisterList=FXCollections.observableArrayList();
    public RegisteredClient() throws FileNotFoundException {
        File file=new File("Register.txt");
        Scanner input=new Scanner(file);
        while(input.hasNext())
        {
            String str=input.nextLine();
            String[] info=str.split("##");
            LMessage RLM=new LMessage(info[0],info[1],info[2]);
            RegisterList.add(RLM);
        }
        
    }
   
   
    
    
}
