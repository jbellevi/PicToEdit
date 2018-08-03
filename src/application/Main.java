package application;

import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  

public class Main extends Application
{
	@Override
	public void start(Stage stage) throws FileNotFoundException
	{
		//create an image
		Image image = new Image(new FileInputStream("test.jpg"));
		
		//set image view
		ImageView imageView = new ImageView(image);
		
		//set image position
		imageView.setX(50);
		imageView.setY(50);
		
		//set image height and width to default
		int width = (int)image.getWidth();
		int height = (int)image.getHeight();
		
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		
		imageView.setPreserveRatio(true);
		
		//Create a Group object
		Group root = new Group(imageView);
		
		//Create a Scene object
		Scene scene = new Scene (root, width + 100, height + 100);
		
		//setting a stage title, adding scene to stage
		stage.setTitle("Driver Image Viewer");
		stage.setScene(scene);
		
		//showing contents of stage
		stage.show();
		
		/*try {
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
