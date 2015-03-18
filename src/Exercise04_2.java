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
		long selectionSum;
		long bubbleSum;
		long insertionSum;
		double table[][] = new double[4][3];
		
		for(int t=0;t<cases.length;t++){
			N = cases[t];
			data = new int[N];
			selectionSum = 0;
			bubbleSum = 0;
			insertionSum = 0;
			for(int i=0;i<100;i++) {
				for(int j=0;j<N;j++)
					data[j] = rd.nextInt(N);
				
				begin = System.currentTimeMillis();
				selectionSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				selectionSum+=end-begin;
				
				begin = System.currentTimeMillis();
				bubbleSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				bubbleSum+=end-begin;
				
				begin = System.currentTimeMillis();
				insertionSort(Arrays.copyOf(data, N));
				end = System.currentTimeMillis();
				insertionSum+=end-begin;
			}
			table[t][0]=selectionSum/1000.0/N;
			table[t][1]=bubbleSum/1000.0/N;
			table[t][2]=insertionSum/1000.0/N;
		}

		System.out.println("N\tSelection sort\tBubble sort\tInsertion sort");
		for(int i=0;i<cases.length;i++){
			System.out.print(cases[i]+"\t");
			for(int j=0;j<3;j++)
				System.out.print(table[i][j]+"\t\t");
			System.out.println();
		}

	}
	
	private static void selectionSort(int[] data) {
		
		
	}
	
	private static void bubbleSort(int[] data) {
		
		
	}
	
	private static void insertionSort(int[] data) {
		
		
	}




}
