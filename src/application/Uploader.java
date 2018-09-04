package application;
import java.io.FileInputStream;
import javafx.scene.image.WritableImage;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;

/*
 * Grabs an image from URL and returns a WritableImage
 */

public class Uploader
{
	static public WritableImage getImage()
	{
		WritableImage img = null;
		try
		{
			Image image = new Image(new FileInputStream("test.jpg"));
			PixelReader picReader = image.getPixelReader();
			
			if (picReader == null)
			{
				throw new IllegalArgumentException("Cannot create pixel reader");
			}
			
			img = new WritableImage(picReader, (int) image.getWidth(), (int)image.getHeight());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return img;
	}
}
