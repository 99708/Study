package com.xyq.test07;

public class Test2 {
	public static void main(String[] args) {
		
		Printer p = new Printer();
		NumberPrinter np = new NumberPrinter(p);
		np.start();
		LetterPrinter lp = new LetterPrinter(p);
		lp.start();
	}
}

class Printer{
	private int index = 1;
	
	public synchronized void print(int i) {
			
			if(index % 3 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print(i);
			index++;
			notifyAll();
	}
	
	public synchronized void print(char c) {
		if(index % 3 != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(c);
		index++;
		notifyAll();
	}
}

class NumberPrinter extends Thread{
	
	private Printer p;
	
	@Override
	public void run() {
		for(int i=1; i<53; i++) {
			p.print(i);
		}
	}

	public NumberPrinter(Printer p) {
		this.p = p;
	}
	
}

class LetterPrinter extends Thread{
	
	private Printer p;
	
	@Override
	public void run() {
		for (char a = 'A'; a >= 'A' && a <= 'Z'; a++) {
			p.print(a);
		}
	}
	
	public LetterPrinter(Printer p) {
		this.p = p;
	}
}


