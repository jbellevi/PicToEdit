package application;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.lang.Math;

public class Picture
{
	int width;
	int height;
	
	WritableImage img;
	
	PixelReader pixelReader;
	PixelWriter pixelWriter;
		
	
	Picture(int width, int height, WritableImage img)
	{
		this.width = width;
		this.height = height;
		
		this.img = img;
		
		this.pixelReader = img.getPixelReader();
		this.pixelWriter = img.getPixelWriter();
	}
	
	/*
	 * Returns the energy of each given pixel, based on how similar its colour is to others around
	 * Arguments: x - the x value of the pixel 
	 * 			  y - the y value of the pixel
	 */
	public double getPixEnergy(int x, int y)
	{
		double energy = 0;
		energy += getColorDistance(x - 1, y - 1, x, y);
		energy += getColorDistance(x, y + 1, x, y);
		energy += getColorDistance(x + 1, y + 1, x, y);
		energy += getColorDistance(x - 1, y, x, y);
		energy += getColorDistance(x + 1, y, x, y);
		energy += getColorDistance(x - 1, y - 1, x, y);
		energy += getColorDistance(x, y - 1, x, y);
		energy += getColorDistance(x + 1, y - 1, x, y);
		
		return energy;
	}
	
	
	/*
	 * Returns the "distance" between two pixels. Distance is defined by treating each of the red, green, blue components as vectors
	 */
	private double getColorDistance(int x1, int y1, int x2, int y2)
	{
		//returns 0 if one of the pixels does not exist on the image
		if (x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 ||
			x1 >= width || x2 >= width || y1 >= height || y2 >= height)
		{
			return 0;
		}
		Color color1 = pixelReader.getColor(x1, y1);
		Color color2 = pixelReader.getColor(x2, y2);
		
		double distance = Math.pow((color1.getRed() - color2. getRed()), 2);
		distance += Math.pow((color1.getGreen() - color2. getGreen()), 2);
		distance += Math.pow((color1.getBlue() - color2. getBlue()), 2);

		
		return Math.sqrt(distance);
	}

	
	
	
	/*
	 * Method used for testing (turns the image into something else, with known colours)
	 */
	public void turnAllTo()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				if (i%2 == 0)
				{
					pixelWriter.setColor(i,  j,  Color.rgb(255,  255, 255));
				}
				else
				{
					pixelWriter.setColor(i,  j,  Color.rgb(0,  0, 0));
				}
			}
		}
			
	}
}
