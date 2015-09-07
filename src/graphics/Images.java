package graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class Images {

	private Images(){}
	
	public static boolean isImageNull(BufferedImage img) {
		return (img == null);
	}

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public static BufferedImage blur(BufferedImage img) {
		float weight = 1.0f / 9.0f;

		float[] elements = { weight, weight, weight, weight, weight, weight,
				weight, weight, weight };

		Kernel k = new Kernel(3, 3, elements);
		ConvolveOp op = new ConvolveOp(k);

		BufferedImage dest = new BufferedImage(img.getWidth(), img.getHeight(),
				img.getType());

		op.filter(img, dest);
		return dest;
	}

	public static BufferedImage sharpen(BufferedImage img) {
		float data[] = { 
				0.0f, -1.0f, 0.0f, 
				-1.0f, 5.0f, -1.0f, 
				0.0f, -1.0f, 0.0f };
		Kernel kernel = new Kernel(3, 3, data);
		ConvolveOp convolve = new ConvolveOp(kernel);

		BufferedImage dest = new BufferedImage(img.getWidth(), img.getHeight(),
				img.getType());

		convolve.filter(img, dest);
		return dest;
	}

	public static BufferedImage edgeKernel(BufferedImage img) {
		float[] data = { 0.0f, -1.0f, 0.0f, -1.0f, 4.0f, -1.0f, 0.0f, -1.0f,
				0.0f };
		Kernel kernel = new Kernel(3, 3, data);
		ConvolveOp convolve = new ConvolveOp(kernel);

		BufferedImage dest = new BufferedImage(img.getWidth(), img.getHeight(),
				img.getType());

		convolve.filter(img, dest);
		return dest;
	}
	
	public static BufferedImage effect(BufferedImage img){
		float[] data = { 0.2f, 0.1f, 0.2f,
						 3.0f, 1.0f, 3.0f,
						 0.2f, 0.1f, 0.2f };
		Kernel kernel = new Kernel(3,3,data);
		ConvolveOp con = new ConvolveOp(kernel);
		BufferedImage dest = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
		con.filter(img, dest);
		return dest;
	}
	
	/*
	public static BufferedImage invert(BufferedImage img){
		short[] invert = new short[256];
		for (int i = 0; i < 256; i++)
		invert[i] = (short)(255 - i);
		BufferedImageOp invertOp = new LookupOp(
		new ShortLookupTable(0, invert), null);
		return invertOp;
	}
	*/

}
