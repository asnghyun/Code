package testkim;

public class SynchronizedEx {
	  public static void main(String [] args) {
	    SyncObject obj = new SyncObject(); // 집계판 공유데이타 생성

	    // 스레드 생성시 집계판의 주소를 알려준다. 두 스레드는 집계판에 동시에 접근한다.
	    Thread th1 = new WorkerThread("kitae", obj); // kitae 이름의 스레드 생성
	    Thread th2 = new WorkerThread("hyosoo", obj); // hyosoo 이름의 스레드 생성
	    Thread th3 = new WorkerThread("KimSSang", obj);
	    
	    // 두 스레드를 실행시킨다.
	    th1.start();
	    th2.start();
	    th3.start();
	  }
	}

	// 공유데이타인 집계판을 시뮬레이션하는 클래스. 
	// 두 WorkerThread 스레드에 의해 동시 접근됨
	class SyncObject {
	  int sum = 0; // 집계판의 합
	  void add() {
	    int n = sum;
	    Thread.currentThread().yield();
	    n += 10; // 10을 증가시킨다.
	    sum = n; // 증가한 값을 집계합에 쓴다.
	    System.out.println(Thread.currentThread().getName() + " : " + sum);
	  }
	  int getSum() {return sum;}
	}

	// 학생을 시뮬레이션하는 스레드 클래스
	class WorkerThread extends Thread {
	  SyncObject sObj; // 집계판의 주소
	  
	  WorkerThread(String name, SyncObject sObj) {
	    super(name);
	    this.sObj = sObj;
	  }
	  
	  // 집계판을 반복적으로 10번 접근하여 카운팅한다.
	  public void run() {
	    int i=0;
	    while(i<10) {
	      sObj.add();
	      i++;
	    }
	  }
	}
