package tollBarrier.gui;

import java.util.TimerTask;

import javax.swing.JTextField;

public class Chrono extends TimerTask{
	
	private JTextField jt;
	
	public Chrono(JTextField jTextField4) {
		jt = jTextField4;
	}
	@Override
	public void run() {
		int tmp = Integer.parseInt(jt.getText());
		tmp++;
		jt.setText("" + tmp);
	}

}
