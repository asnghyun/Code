package testkim;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import oracle.jrockit.jfr.JFR;


public class ThreadInterruptEx extends JFrame{
	Thread th;
	public ThreadInterruptEx(){
		setTitle("sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		c.add(timerLabel);
		
		JButton btn = new JButton("kill");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
				// TODO Auto-generated method stub
				
			}
		});
		c.add(btn);
		
		setSize(300, 250);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadInterruptEx();

	}

}
