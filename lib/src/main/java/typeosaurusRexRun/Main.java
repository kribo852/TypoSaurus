package typeosaurusRexRun;

import java.util.List;
import java.util.function.*;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import lombok.*;

public class Main {
	
	static int screenxsize = 800, screenysize = 600;
	static int scoreCounter = 0;
	static boolean game_over = false;
	
	static TextToWriteRepository text = new AliceHardCodedTextRepo();
	static Dino dino = new TypoSaurus();
	static JurassicBackground background = new JurassicBackground(screenxsize, screenysize);
	static Clouds clouds = new Clouds();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		JFrame jframe = new JFrame();
		jframe.setSize(screenxsize, screenysize);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jframe.addKeyListener(new LetterTypedListener(c -> {
			if(!game_over) {
				if(c == text.getUntyped().charAt(0) ) {
					dino.back();
					text.completeNextChar();
				} else {
					dino.jumpForward();
				}
			}
		}));
		
		
		Graphics g = jframe.getGraphics();
		
		while(true) {
			g.drawImage(getWorldImage(), 0, 0, null);
			if(dino.getX()<750) {
				dino.move();
				clouds.update();
				scoreCounter++;
			} else {
				game_over = true;
			}
			
			Thread.sleep(10);
		}
			
	}
	
	public static BufferedImage getWorldImage() {
		BufferedImage bimg = new BufferedImage(screenxsize, screenysize, 
				BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = bimg.getGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, screenxsize, screenysize);
		
		List.of(background.drawConsumer(), clouds.drawConsumer(), 
				dino.drawConsumer(), drawTextConsumer())
		.forEach(c -> c.accept(graphics));
		graphics.drawString("score: "+ scoreCounter, 100, 550);
		return bimg;
	}
	
	//Move in to text repositories?
	public static Consumer<Graphics> drawTextConsumer() {
		return graphics -> {
			graphics.setColor(Color.orange);
			graphics.drawString(text.getTyped(), 50, 500);
			graphics.setColor(Color.green);
			graphics.drawString(text.getUntyped(), 50+ text.getTyped().length()*5 , 520);
		};
	}

}
