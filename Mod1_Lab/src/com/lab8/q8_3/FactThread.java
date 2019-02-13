package com.lab8.q8_3;

public class FactThread {

	public static void main(String[] args) throws InterruptedException {
		
        int val = Rand();
    
		Thread tr = new Thread(new Runnable()
		{
			public void run()
			{   
				System.out.println("Number: "+val);
			}
		});
	
		Thread tf = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Factorial: "+Fact(val));
				
			}
			
		});
		tr.start();
		tr.join();
		
		tf.start();
		
	}
	public static int Rand()
	{
		return (int) (Math.random()*11); 
	}
	
	public static int Fact(int num)
    {
    	int fact=1;
    	for(int i=1;i<=num;i++)
    	{
    		fact=fact*i;
    	}
    	return fact;
    }
}
