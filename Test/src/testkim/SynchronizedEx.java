package testkim;

public class SynchronizedEx {
	  public static void main(String [] args) {
	    SyncObject obj = new SyncObject(); // ������ ��������Ÿ ����

	    // ������ ������ �������� �ּҸ� �˷��ش�. �� ������� �����ǿ� ���ÿ� �����Ѵ�.
	    Thread th1 = new WorkerThread("kitae", obj); // kitae �̸��� ������ ����
	    Thread th2 = new WorkerThread("hyosoo", obj); // hyosoo �̸��� ������ ����
	    Thread th3 = new WorkerThread("KimSSang", obj);
	    
	    // �� �����带 �����Ų��.
	    th1.start();
	    th2.start();
	    th3.start();
	  }
	}

	// ��������Ÿ�� �������� �ùķ��̼��ϴ� Ŭ����. 
	// �� WorkerThread �����忡 ���� ���� ���ٵ�
	class SyncObject {
	  int sum = 0; // �������� ��
	  void add() {
	    int n = sum;
	    Thread.currentThread().yield();
	    n += 10; // 10�� ������Ų��.
	    sum = n; // ������ ���� �����տ� ����.
	    System.out.println(Thread.currentThread().getName() + " : " + sum);
	  }
	  int getSum() {return sum;}
	}

	// �л��� �ùķ��̼��ϴ� ������ Ŭ����
	class WorkerThread extends Thread {
	  SyncObject sObj; // �������� �ּ�
	  
	  WorkerThread(String name, SyncObject sObj) {
	    super(name);
	    this.sObj = sObj;
	  }
	  
	  // �������� �ݺ������� 10�� �����Ͽ� ī�����Ѵ�.
	  public void run() {
	    int i=0;
	    while(i<10) {
	      sObj.add();
	      i++;
	    }
	  }
	}
