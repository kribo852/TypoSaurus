package typeosaurusRexRun;

import java.awt.Graphics;
import java.util.function.Consumer;

public interface GameDrawable {
	
	public Consumer<Graphics> drawConsumer();

}
