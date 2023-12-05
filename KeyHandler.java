import java.awt.event.*;
public class KeyHandler implements KeyListener{
	demopanel dp;
	public KeyHandler(demopanel dp) {
		this.dp=dp;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			dp.search();
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
