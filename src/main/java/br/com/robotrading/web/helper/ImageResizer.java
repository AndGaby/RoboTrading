package br.com.robotrading.web.helper;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;


public class ImageResizer {
 
    public static File resize(File image,int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        BufferedImage inputImage = ImageIO.read(image);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        
        // extracts extension of output file
        String formatName = image.getName().substring(image.getName()
                .lastIndexOf(".") + 1);
       
        // writes to output file
         ImageIO.write(outputImage, formatName, image);
         
         return image;
     
    }
}
