import java.util.Random;

/*
 * 2. �켱���� ť�� �����ϴ� naive �� ����� �ϳ��� �׳� ���ĵ��� ���� �迭�� ����ϴ� ���̴�.
 * ���ο� ���Ҵ� �׻� �迭�� �� ���� �����ϰ�, �ִ밪 ������ �ִ밪�� O(N) �ð��� ã�Ƽ� �����ϰ� �迭�� ������
 * ���Ҹ� �ִ밪�� �ִ� ��ġ�� �̵��Ͽ� �迭�� �߰��� �� ĭ�� ������ ó���Ѵ�. heap�� �̿��Ͽ� �켱����ť��
 * ������ �� �̷��� �ܼ��ϰ� �迭�� ������ ���� ����ӵ��� ���϶�. ������ �񱳴� ������ ���� �Ѵ�.
 * �켱 N���� 0���� N������ ������ �����ϰ� �����Ͽ� �켱����ť�� �����Ѵ�. �׷� ���� M���� ���� Ȥ��
 * �ִ밪 ���� ������ �����Ͽ� �����ϴµ� �ɸ��� �� �ð��� �����Ѵ�. M���� ���� ������ �켱 1/2�� Ȯ����
 * ���� �������� Ȥ�� �ִ밪 ���� ���������� ������ ��, ���� ������ ��쿡 �ٽ� 0���� N������ ������ �����ϰ� 
 * �����Ͽ� ������ �����͸� �����Ѵ�.
 */
public class Exercise06_2 {
	static class PQueue {
		int [] data;
		PQueue() { data = new int[100000];}
	}
	private static int heapSize = 0;
	public static void main(String[] args) {
		PQueue pqueue = new PQueue();	// ���� �̿��� �켱���� ť
		PQueue naive = new PQueue();	// naive�� �켱���� ť
		
		test(pqueue, 10000, 10000);
		heapSize=0;
		naive_test(naive, 10000, 10000);
	}

	private static void naive_test(PQueue queue, int N, int M) {
		Random rd = new Random();
		for(int i=0;i<N;i++) {
			queue.data[i] = rd.nextInt(N);
			heapSize++;
		}	// �׽�Ʈ�� ���� �ʱ� �켱���� ť�� ���� �� �д�
		
		long start = System.currentTimeMillis();
		for(int i=0;i<M;i++) {
			if(rd.nextInt(2)==0) {
				queue.data[heapSize++] = rd.nextInt(N);	// ��ť
				//System.out.println(heapSize);
			}
			else if(heapSize>=1) {
				naive_extractMax(queue.data, heapSize);						// ��ť
				//System.out.println(heapSize);
			}
		}
		System.out.println("Naive test Elapsed: "+((long)System.currentTimeMillis()-start)/1000.0);
	}
	private static int naive_extractMax(int data[], int size) {
		if(heapSize<1) {
			System.out.println("heap underflow");
			return -1;
		}

		int max = data[0];	// ��Ʈ ��尡 �׻� max
		int max_index = 0;
		for(int i=1;i<size;i++) {
			if(max<data[i]){	// O(N) �ð��� �ִ밪 ã��
				max = data[i];
				max_index=i;
			}	
		}
		data[max_index] = data[heapSize-1];
		heapSize--;	// �� ������ 1����
	
		return max;
	}
	private static void test(PQueue queue, int N, int M) {
		Random rd = new Random();
		for(int i=0;i<N;i++) {
			queue.data[i] = rd.nextInt(N);
			heapSize++;
		}	// �׽�Ʈ�� ���� �ʱ� �켱���� ť�� ���� �� �д�
		buildMaxHeap(queue.data, heapSize); // �ʱ� ť�� ������ �����
		long start = System.currentTimeMillis();
		for(int i=0;i<M;i++) {
			if(rd.nextInt(2)==0) {
				maxHeapInsert(queue.data, rd.nextInt(N));	// ��ť
				//System.out.println(heapSize);
			}
			else if(heapSize>=1) {
				extractMax(queue.data);						// ��ť
				//System.out.println(heapSize);
			}
		}
		System.out.println("Using Heap Elapsed: "+((long)System.currentTimeMillis()-start)/1000.0);
	}
	
	private static void maxHeapInsert(int [] data, int key){
		heapSize++;					// �� ����� ������Ŵ
		data[heapSize-1] = key;
		int i = heapSize-1;
		while(i>0 && data[(i-1)/2]<data[i]) {
			int temp = data[i];
			data[i] = data[(i-1)/2];
			data[(i-1)/2] = temp;
			i = (i-1)/2;
		}	// �μ�Ʈ �� ������ ��� ��忡 ���� ���� ���� �� �ʿ䰡 ����
	}
	private static int extractMax(int[] data) {
		if(heapSize<1) {
			System.out.println("heap underflow");
			return -1;
		}
		
		int max = data[0];	// ��Ʈ ��尡 �׻� max
		data[0] = data[heapSize-1];	// ������ ��带 ��Ʈ ��忡 ���� ��
		heapSize--;	// �� ������ 1����
		maxHeapify(data, 0, heapSize);
		return max;
	}
	private static void buildMaxHeap(int [] data, int size) {
		for(int i=(size-1)/2;i>=0;i--){
			maxHeapify(data, i, size);
		}
	}
	private static void maxHeapify(int[] data, int i, int size){
		if (i*2+1>size-1) {	// �ڽ� ��尡 ����?
			return;
		}
		int k;
		if(i*2+2<=size-1) {	// �ڽ� ��尡 �� ���� ���
			k = data[i*2+1]<data[i*2+2]?i*2+2:i*2+1;
		}else {				// �� ���� ���
			k = i*2+1;
		}
		if(data[i]>=data[k])
			return ;
		int temp = data[i];
		data[i] = data[k];
		data[k] = temp;
		maxHeapify(data, k, size);
	}
}