package com.lab8.q8_2;


class ThreadTimer implements Runnable
{

  	@Override
  	public void run()
  	{
  		for(int j=1;j<=10;j++) {
  			System.out.println(j);
  			try {
  				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  		}

  	}

}
public class TimerEg {

	public static void main(String[] args) {
		
		ThreadTimer timer = new ThreadTimer();
		for(int i=0;i<5;i++) {
		
		Thread t = new Thread(timer);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
