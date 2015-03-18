import java.util.Arrays;
import java.util.Random;

/*
 * Bubble sort, selection sort, insertion sort �˰����� �����϶�.
 * ũ�Ⱑ ���� 100, 1000, 10000, 100000���� data�� �����Ͽ� �� �˰����� ����ð��� �����϶�.
 * �ݵ�� ������ �����ͷ� ������ �˰����� ����ð��� �����ؾ� �Ѵ�.
 */
public class Exercise04_1 {
	public static void main(String [] args) {
		Random rd = new Random();
		int[] cases = {100,1000,10000,100000};
		int N;
		int [] data;
		long begin;
		long end;
		
		for(int t=0;t<cases.length;t++) {
			N = cases[t];
			data = new int[N];
			
			System.out.println("<"+N+" data case>");
			for(int i=0;i<N;i++)
				data[i] = rd.nextInt(N);
			
			begin = System.currentTimeMillis();
			selectionSort(Arrays.copyOf(data, N));
			end = System.currentTimeMillis();
			System.out.println("Selection Sort: "+(end-begin)/1000.0);
			
			begin = System.currentTimeMillis();
			bubbleSort(Arrays.copyOf(data, N));
			end = System.currentTimeMillis();
			System.out.println("Bubble Sort: "+(end-begin)/1000.0);
			
			begin = System.currentTimeMillis();
			insertionSort(Arrays.copyOf(data, N));
			end = System.currentTimeMillis();
			System.out.println("insertion Sort: "+(end-begin)/1000.0);
		}
	}
	
	private static void selectionSort(int[] data) {
		
		
	}
	
	private static void bubbleSort(int[] data) {
		
		
	}
	
	private static void insertionSort(int[] data) {
		
		
	}




}
