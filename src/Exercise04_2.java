import java.util.Arrays;
import java.util.Random;

/*
 * 1������ �ۼ��� ���α׷��� ����/�̿��Ͽ� N=100, 1000, 10000, 100000�� ���ؼ� ���� 100������ ����
 * �����͸� �����Ͽ� 3���� ���� �˰������� ������ �� ��� ����ð��� �����Ͽ� �Ʒ��� ���� ������ ���̺�� ����ϴ�
 * ���α׷��� �ۼ��϶�.
 */
public class Exercise04_2 {
	public static void main(String [] args) {
		Random rd = new Random();
		int[] cases = {100, 1000, 10000, 100000};
		int N;
		int [] data;
		long begin; long end;
		double selectionSum;
		double bubbleSum;
		double insertionSum;
		double mergeSum;
		double table[][] = new double[4][4];

		System.out.println("N\tSelection sort\tBubble sort\tInsertion sort\tMerge sort");
		
		for(int t=0;t<cases.length;t++){
			N = cases[t];
			data = new int[N];
			selectionSum = 0;
			bubbleSum = 0;
			insertionSum = 0;
			mergeSum=0;
			for(int i=0;i<100;i++) {
				for(int j=0;j<N;j++)
					data[j] = rd.nextInt(N);
				
				begin = System.currentTimeMillis();
				selectionSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				selectionSum+=(end-begin)/1000.0;
				
				begin = System.currentTimeMillis();
				bubbleSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				bubbleSum+=(end-begin)/1000.0;
				
				begin = System.currentTimeMillis();
				insertionSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				insertionSum+=(end-begin)/1000.0;
				
				begin = System.currentTimeMillis();
				mergeSort(Arrays.copyOf(data, N),0,N-1);
				end = System.currentTimeMillis();
				mergeSum+=(end-begin)/1000.0;
			}
			table[t][0]=selectionSum/N;
			table[t][1]=bubbleSum/N;
			table[t][2]=insertionSum/N;
			table[t][3]=mergeSum/N;
			
			System.out.print(cases[t]+"\t");
			for(int j=0;j<4;j++)
				System.out.print(table[t][j]+"\t\t");
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
				max = data[tempIndex];
				data[tempIndex] = data[last];
				data[last] = max;
			}
			
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
	
	private static void insertionSort(int[] data) {
		for(int i=1;i<data.length;i++) {
			int j=i-1;
			while(j>=0&&data[i]<data[j]) {
				data[j+1]=data[j];
				j--;
			}
			data[j+1]=data[i];
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
	private static void merge(int[] data, int p, int q, int r) {
		int i=p, j=q+1, k=p;
		int[] tmp = new int[data.length];
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
}
