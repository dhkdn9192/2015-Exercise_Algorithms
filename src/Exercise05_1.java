import java.util.Arrays;
import java.util.Random;

/*
 * 1������ �ۼ��� ���α׷��� ����/�̿��Ͽ� N=100, 1000, 10000, 100000�� ���ؼ� ���� 100������ ����
 * �����͸� �����Ͽ� 3���� ���� �˰������� ������ �� ��� ����ð��� �����Ͽ� �Ʒ��� ���� ������ ���̺�� ����ϴ�
 * ���α׷��� �ۼ��϶�.
 */
public class Exercise05_1 {
	private static int N;
	public static void main(String [] args) {
		Random rd = new Random();
		int[] cases = {100, 1000, 10000, 100000};
		int [] data;
		int [] temp;
		long begin; long end;
		double selectionSum;
		double bubbleSum;
		double insertionSum;
		double mergeSum;
		double quickSum;
		double medQuickSum;
		double table[][] = new double[4][6];

		System.out.println((4+9)/2);
		System.out.println("Sort test");
		int[] test = {9,5,2,6,3,3,1,4,2,2};
//		for(int j=0;j<10;j++)
//			test[j] = rd.nextInt(10);
		for(int i=0;i<10;i++)
			System.out.print(test[i]+", ");
		System.out.println();
		medQuickSort(test, 0, 10-1);
		System.out.println("result: ");
		for(int i=0;i<10;i++)
			System.out.print(test[i]+", ");
		System.out.println();
		
		System.out.println("N\tSelection sort\tBubble sort\tInsertion sort\tMerge sort\tQuick sort\tQuick sort(Median of three)");
		
		for(int t=0;t<cases.length;t++){
			N = cases[t];
			data = new int[N];
			temp = new int[N];
			selectionSum = 0;
			bubbleSum = 0;
			insertionSum = 0;
			mergeSum=0;
			quickSum=0;
			medQuickSum=0;
			for(int i=0;i<10;i++) {
				for(int j=0;j<N;j++)
					data[j] = rd.nextInt(N);
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				selectionSort(temp);
				end = System.currentTimeMillis();
				selectionSum+=(end-begin)/1000.0;
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				bubbleSort(temp);
				end = System.currentTimeMillis();
				bubbleSum+=(end-begin)/1000.0;
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				insertionSort(temp);
				end = System.currentTimeMillis();
				insertionSum+=(end-begin)/1000.0;
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				mergeSort(temp,0,N-1);
				end = System.currentTimeMillis();
				mergeSum+=(end-begin)/1000.0;
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				quickSort(temp,0,N-1);
				end = System.currentTimeMillis();
				quickSum+=(end-begin)/1000.0;
				
				temp = Arrays.copyOf(data, N);
				begin = System.currentTimeMillis();
				medQuickSort(temp,0,N-1);
				end = System.currentTimeMillis();
				medQuickSum+=(end-begin)/1000.0;
			}
			table[t][0]=selectionSum/10;
			table[t][1]=bubbleSum/10;
			table[t][2]=insertionSum/10;
			table[t][3]=mergeSum/10;
			table[t][4]=quickSum/10;
			table[t][5]=medQuickSum/10;
			
			System.out.print(cases[t]+"\t");
			for(int j=0;j<6;j++)
				System.out.print(String.format("%.4f", table[t][j])+"\t\t");
			System.out.println();
		}
	}
	
	private static void selectionSort(int[] data) {
		int max; int tempIndex;
		for(int last=data.length-1;last>0;last--) {
			tempIndex=0;
			for(int i=1;i<=last;i++) {
				if(data[tempIndex]<data[i]) {
					tempIndex=i;
				}
			}
			max = data[tempIndex];			// swap�� �� ���� ��
			data[tempIndex] = data[last];
			data[last] = max;
			
		}
	}
	
	private static void bubbleSort(int[] data) {
		int temp;
		for(int last=data.length-1;last>0;last--) {
			for(int i=0;i<last;i++) {
				if(data[i]>data[i+1]) {
					temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
				}
			}
		}
	}
	private static int swp;
	private static void insertionSort(int[] data) {
		for(int i=1;i<data.length;i++) {	// i�� ������������ ����
			int j = i-1; int temp = data[i];
			while(j>=0&&data[j]>temp) {	// j�� ������������ ����
				swp = data[j]; // swap(data[j], data[j+1]) not swap(data[j], data[i])!
				data[j] = data[j+1];
				data[j+1] = swp;	// �Ź� �������� �ʰ� �ѹ����� ���� �� �� ������? ������ �� ���� �ص� ���⸦ �� ���ϴ°� �� ������ ū��?
				j--;
			}
			data[j+1] = temp;	// data[j] < temp�� ��� while�� Ż���ϸ鼭 j-- �������Ƿ� j+1�� �־���.
		}
	}
	
	private static void mergeSort(int[] data, int p, int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergeSort(data, p, q);
			mergeSort(data, q+1, r);
			merge(data, p, q, r);
		}
	}
	public static int [] tmp = new int[100000];
	private static void merge(int[] data, int p, int q, int r) {
		int i=p, j=q+1, k=p;
		while(i<=q&&j<=r) {
			if(data[i]<=data[j])
				tmp[k++]=data[i++];
			else
				tmp[k++]=data[j++];
		}
		while(i<=q)
			tmp[k++]=data[i++];
		while(j<=r)
			tmp[k++]=data[j++];
		for(i=p;i<=r;i++)
			data[i]=tmp[i];
	}
	
	private static void quickSort(int [] data, int p, int r) {
		int q;	// �ǹ�
		if(p<r) {
			q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
	}
	private static int partition(int[] data, int p, int r) {
		int x=data[r];	// �ǹ����� ������ ���� ����
		int i=p-1;		// �ǹ����� ���� ��Ƽ���� �ε��� (�ǹ����� ���� �� �� ���� ū ��) �ʱ�ȭ
		int temp;
		
		for(int j=p; j<r;j++)	// r-1������ �˻��ؾ� ��
			if(data[j]<=x) {
				i++;
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		temp = data[i+1];
		data[i+1] = data[r];
		data[r] = temp;
		return i+1;	// �ǹ��� �ּҰ��� ��쿡�� �ƿ��ٿ�� �ͼ����� �߻� �ȵȴ�!
	}
	
	private static void medQuickSort(int [] data, int p, int r) {
		int q;	// �ǹ�
		if(p<r) {
			q = medPartition(data, p, r);
			medQuickSort(data, p, q-1);
			medQuickSort(data, q+1, r);
		}
	}
	private static int medPartition(int[] data, int p, int r) {
		int median=data[(p+r)/2];	// �ǹ����� ������ ���� ����
		int i=p-1;					// �ǹ����� ���� ��Ƽ���� �ε��� (�ǹ����� ���� �� �� ���� ū ��) �ʱ�ȭ
		int temp;
		int x;
		
		int max =	Math.max(Math.max(data[p], median),data[r]);	// ���� ��� ���� ���� ��ȯ. �ִ밪�� �����ؾ� �ϴ� ���� �ƴ�
		if(max==data[p]) {		// ó���� �ִ밪�� ���
			x = median<data[r]?data[r]:median;	// ���� �� �� ���� ����-�߰����� ����. ������ ���� swap �� �ʿ� ����
			temp = median<data[r]?r:((p+r)/2);	// �߰����� �ε����� ����
		}else if(max==median) {	// ����� �ִ밪�� ���
			x = data[p]<data[r]?data[r]:data[p];
			temp = data[p]<data[r]?r:p;
		}else {					// �������� �ִ밪�� ���
			x = data[p]<median?median:data[p];
			temp = data[p]<median?((p+r)/2):p;
		}
		// ������ �ǹ��� ���������� �ű�
		data[temp] = data[r];
		data[r] = x;
		
		for(int j=p; j<r;j++)	// r-1������ �˻��ؾ� ��
			if(data[j]<=x) {		// �ǹ��� ũ�ų� ����? ũ��? ���� ����
				i++;
				temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		temp = data[i+1];
		data[i+1] = data[r];
		data[r] = temp;
		return i+1;	// �ǹ��� �ּҰ��� ��쿡�� �ƿ��ٿ�� �ͼ����� �߻� �ȵȴ�!
	}
}