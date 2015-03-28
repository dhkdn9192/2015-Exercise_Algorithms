
public class Exercise06_2 {
	private static int [] data = new int[100000];
	private static int heapSize = 0;
	public static void main(String[] args) {
		int [] test = {20, 10, 15, 8, 7, 13, 14, 2, 5, 6};
		for(int i=0;i<10;i++) {
			data[i] = test[i];
			heapSize++;
		}	// �ʱ� ť�� ���� �� �д�
		buildMaxHeap(data, heapSize); // �ʱ� ť�� ������ �����
		for(int i=0;i<heapSize;i++)
			System.out.print(data[i]+", ");	// �׽�Ʈ ���
		System.out.println();
		maxHeapInsert(data, 15);			// 15�� �߰��Ѵ� (��ť)
		for(int i=0;i<heapSize;i++)
			System.out.print(data[i]+", ");
		System.out.println();
		
		System.out.println(extractMax(data));	// 20�� ��ť
		for(int i=0;i<heapSize;i++)
			System.out.print(data[i]+", ");		// ���� ť ���
		System.out.println();
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
		}
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