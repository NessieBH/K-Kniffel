/**
 * @author Vanessa Lutz
 *
 */

package kniffel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartKniffel extends Application {

	@Override
    public void start(Stage primaryStage) {
        try {
            // Read file fxml and draw interface.
            Parent root = FXMLLoader.load(getClass()
                    .getResource("Wuerfel.fxml"));
            
            primaryStage.setTitle("K-Kniffel");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
   
}