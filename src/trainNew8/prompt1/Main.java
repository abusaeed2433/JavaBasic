package trainNew8.prompt1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Main {

    public static byte[] captureScreen() throws IOException {
        // Get the default graphics configuration
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        // Create a new buffered image
        BufferedImage image = gc.createCompatibleImage(gc.getBounds().width, gc.getBounds().height);

        // Paint the screen onto the buffered image
        GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
        // todo issue here, it doesn't work
        //gc.createGraphics().drawImage(gc.getDevice().getFullScreenWindow(), 0, 0, null);

        // Create a byte array output stream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Write the buffered image to the byte array output stream
        ImageIO.write(image, "png", baos);
        ImageIO.write(image, "png", new File("screen_shot.png"));

        // Close the byte array output stream
        baos.close();

        // Return the byte array
        return baos.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        byte[] screenshot = captureScreen();
        System.out.println( screenshot.length );
        System.out.println("Screenshot captured successfully!");
    }
}
