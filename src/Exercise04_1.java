import java.util.Arrays;
import java.util.Random;

/*
 * Bubble sort, selection sort, insertion sort �˰����� �����϶�.
 * ũ�Ⱑ ���� 100, 1000, 10000, 100000���� data�� �����Ͽ� �� �˰����� ����ð��� �����϶�.
 * �ݵ�� ������ �����ͷ� ������ �˰����� ����ð��� �����ؾ� �Ѵ�.
 */
public class Exercise04_1 {
	private static int N;
	public static void main(String [] args) {
		Random rd = new Random();
		int[] cases = {100,1000,10000,100000};
		int [] data;
		int [] temp;
		long begin;
		long end;
		
		for(int t=0;t<cases.length;t++) {
			N = cases[t];
			data = new int[N];
			temp = new int[N];
			
			System.out.println("<"+N+" data case>");
			for(int i=0;i<N;i++)
				data[i] = rd.nextInt(N);
			
			temp = Arrays.copyOf(data, N);
			begin = System.currentTimeMillis();
			selectionSort(temp);
			end = System.currentTimeMillis();
			System.out.println("Selection Sort: "+(end-begin)/1000.0);
			if(t==0) Print(temp);
			
			temp = Arrays.copyOf(data, N);
			begin = System.currentTimeMillis();
			bubbleSort(temp);
//			int bbtemp;
//			for(int last=temp.length-1;last>0;last--) {
//				for(int i=0;i<last;i++) {
//					if(temp[i]>temp[i+1]) {
//						bbtemp = temp[i];
//						temp[i] = temp[i+1];
//						temp[i+1] = bbtemp;
//					}
//				}
//			}	// ��� �Ȱ� �Լ� ȣ�� ���Ѱ� �� ������...
			end = System.currentTimeMillis();
			System.out.println("Bubble Sort: "+(end-begin)/1000.0);
			if(t==0) Print(temp);
			
			temp = Arrays.copyOf(data, N);
			begin = System.currentTimeMillis();
			insertionSort(temp);
			end = System.currentTimeMillis();
			System.out.println("Insertion Sort: "+(end-begin)/1000.0);
			if(t==0) Print(temp);
			
			temp = Arrays.copyOf(data, N);
			begin = System.currentTimeMillis();
			mergeSort(temp,0,N-1);
			end = System.currentTimeMillis();
			System.out.println("Merge Sort: "+(end-begin)/1000.0);
			if(t==0) Print(temp);
		}
	}
	private static void Print(int[] temp) {
		for(int i=0;i<N;i++) 
			System.out.print(temp[i]+", ");
		System.out.println("");
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
}
