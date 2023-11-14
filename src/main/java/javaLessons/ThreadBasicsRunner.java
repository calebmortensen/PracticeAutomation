package javaLessons;


//extend Thread
//implements Runnable

//States: NEW, RUNNABLE, RUNNING, BLOCKED/WAITING, TERMINATED/DEAD

class Task1 extends Thread {
	public void run() {     //RUN
		System.out.println("\nTask1 Run");
		for (int i = 101; i <= 199; i++)
			System.out.print(i + " ");

		System.out.print("\nTask1 Done");

	}
}

class Task2 implements Runnable{

	@Override
	public void run() {
		System.out.println("\nTask2 Started");
		for (int i = 201; i <= 299; i++)
			System.out.print(i + " ");

		System.out.print("\nTask2 Done");
		
	}
	
}
public class ThreadBasicsRunner {

	public static void main(String[] args) throws InterruptedException {
		// Task1
		System.out.print("\nTask1 Kicked Off");
		Task1 task1 = new Task1();
		task1.setPriority(1);   //1-10 (it's a request. May or may not be honored
		task1.start();  //START
		
		System.out.print("\nTask2 Kicked Off");
		Task2 task2 = new Task2();
		Thread task2thread = new Thread(task2);
		task2thread.setPriority(10);
		task2thread.start();
		
		
		//Wait for task1 then task2thread to complete (running in parallel) before task3 starts
		task1.join();
		task2thread.join();

		System.out.print("\nTask3 Kicked Off");
		// Task3
		for (int i = 301; i <= 199; i++)
			System.out.print(i + " ");

		System.out.print("\nTask3 Done");

		System.out.print("\nMainDone");

	}

}
