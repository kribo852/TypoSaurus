package typeosaurusRexRun;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Consumer;

import lombok.*;

@AllArgsConstructor
class LetterTypedListener implements KeyListener {
	
	final Consumer<Character> letterConsumer;

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		letterConsumer.accept(arg0.getKeyChar());
		
	}	
}
