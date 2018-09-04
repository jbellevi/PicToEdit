/*
 * Used as a driver class right now to test the Picture class
 * Will be reorganised later
 */


package application;

import javafx.application.Application; 

import javafx.scene.Group; 
import javafx.scene.Scene; 
//import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  

public class GUI extends Application
{
	final int WINDOW_WIDTH = 1000;
	final int WINDOW_HEIGHT = 600;

	@Override
	public void start(Stage stage) throws InterruptedException
	{
		// Relevant objects
		WritableImage img = Uploader.getImage();
		ImageView imageView = setUpImageView(img);
		Picture pic = new Picture((int)img.getWidth(), (int) img.getHeight(), img);
		
		//Create a Group object
		Group root = new Group(imageView);
		
		//Create a Scene object
		Scene scene = new Scene (root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//setting a stage title, adding scene to stage
		stage.setTitle("Driver Image Viewer");
		stage.setScene(scene);
		
		//showing contents of stage
		stage.show();
		//there was once a try-catch statement at tutorialspoints for JavaFX environment
		

		pic.turnAllTo();
		System.out.println(pic.getPixEnergy(0, 0));
		System.out.println(pic.getPixEnergy(1, 1));
		System.out.println(pic.getPixEnergy(1, 0));

	}
	
	
	
	/*
	 * Provides the initial settings for the image display
	 * Returns the ImageView wanted
	 */
	private ImageView setUpImageView(WritableImage img)
	{		
		//set image view
		ImageView imageView = new ImageView(img);
		
		//set image position
		imageView.setX(50);
		imageView.setY(50);
			
		//set image height and width to default
		int width = (int)img.getWidth();
		int height = (int)img.getHeight();
				
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
				
		imageView.setPreserveRatio(true);
		
		return imageView;
	}
	
	
	/*
	 * Launches JavaFX
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
	
}
