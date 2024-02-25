package typeosaurusRexRun;

import java.awt.Color;
import java.awt.Graphics;
import java.util.function.Consumer;

public class TestTextRepository implements TextToWriteRepository {
	
	private String typed = "";
	private String untyped ="the rain in spain stays mainly in the plane";

	@Override
	public String getUntyped() {
		return untyped;
	}

	@Override
	public String getTyped() {
		return typed;
	}

	@Override
	public void completeNextChar() {
		typed += untyped.charAt(0);
		untyped = untyped.substring(1);
		if(untyped.isEmpty()) {
			untyped = typed;
			typed = "";
		}
	}
	
	@Override
	public Consumer<Graphics> drawConsumer() {
		return graphics -> {
			graphics.setColor(Color.orange);
			graphics.drawString(typed, 50, 500);
			graphics.setColor(Color.green);
			graphics.drawString(untyped, 50 + typed.length() * 6, 520);
		};
	}

}
