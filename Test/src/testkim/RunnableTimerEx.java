package testkim;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import oracle.jrockit.jfr.JFR;

class TimerRunnable implements Runnable{
	JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel){
		this.timerLabel = timerLabel;
	}
	
	
	
	public void run(){
		int n =0;
		while(true){
			timerLabel.setText(Integer.toString(n));
			n++;
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
	}
}

public class RunnableTimerEx extends JFrame{
	public RunnableTimerEx(){
		setTitle("sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		
		Thread th = new Thread(runnable);
		
		c.add(timerLabel);
		
		setSize(300,150);
		setVisible(true);
		th.start();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RunnableTimerEx();

	}

}
