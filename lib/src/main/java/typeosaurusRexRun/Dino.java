package typeosaurusRexRun;

import java.awt.Graphics;
import java.util.function.Consumer;

public interface Dino extends GameDrawable {
	
	double getX();

	void move();

	void back();

	void jumpForward();

	Consumer<Graphics> drawConsumer();

}