package test;

import graphics.Images;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("unused")
public class Test2 {

	static BufferedImage img;
	
	public static void main(String[] args) throws IOException{
		
		Scanner keybd = new Scanner(System.in);
		
		img = ImageIO.read(new File("flower@2x.png"));
		
		JFrame frame = new JFrame("Image Window");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,600));
		
		JPanel pane = new JPanel();
		JLabel label = new JLabel(new ImageIcon(img));
		pane.add(label);
		
		JRadioButton rb = new JRadioButton("Effect");
		rb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(rb.isSelected()){
					img = Images.effect(img);
				}else{
					try {
						img = ImageIO.read(new File("flower@2x.png"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				label.setIcon(new ImageIcon(img));
			}
		});
		pane.add(rb);
		
		frame.setContentPane(pane);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		keybd.close();
	}
	
	private static String input(Scanner s, String message){
		System.out.print("Input ("+message+"): ");
		String input = s.nextLine();
		return input;
	}
	private static String input(Scanner s){
		return input(s,"");
	}
	private static int rand(){
		Random rand = new Random();
		return rand.nextInt();
	}

}
