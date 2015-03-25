import java.util.Arrays;
import java.util.Random;

/*
 * Selection ������ n���� ������ �߿��� k��°�� ���� ������ ã�� �����̴�. k�� �Է����� �־�����.
 * ���� ������ �� �� k��° ������ ã�´ٸ� �ð����⵵�� O(nlogn)�� �ȴ�.
 * quickselection�̶�� �θ��� �ٸ� �� ���� ����� quicksort�� partition �Լ��� �̿��ϴ� ���̴�.
 * �� ���� �־��� �������� quicksort���� ó�� �ϳ��� ���� pivot���� �����Ͽ� pivot���� ���� ����� ū ����� ���� �Ѵ�.
 * pivot���� ���� ������ ������ p����� ��������. ���� p>=k��� �� �� �߿��� k��°�� ���� ���� recursion���� ã�´�.
 * ���� p=k-1��� pivot�� �ٷ� k��°�� ���� ���̴�. p<k-1��� ���� pivot���� ū ���� �߿��� k-p-1��°�� ���� ���� ��Ŀ������ ã�´�.
 * �� ����� �־��� ��� �ð����⵵�� quicksort�� ���� ���������� O(n^2)�̴�.
 * ������ ��սð����⵵�� O(n)�̴�.
 * quickselection �˰����� ������ �� ���� �˰���� ���������� 100000���� �����Ϳ� ���ؼ� ������ �� �� k��° ���� ã�� ����� ���϶�.
 * (�Է¿� ������ �������� �ִ� ���: k��°�� ���� ������ ������ ���� �� k��°�� ��ġ�ϴ� ���� �ǹ���. ���� �������� 1, 2, 2, 2, 3, 4�̰� k=3�̸� 2�� ����ϸ� ��). 
 */

public class Exercise05_5 {
	private static int k;
	public static void main(String [] args) {
		Random rd = new Random();
		int N = 100000;
		int [] data = new int[N];
		int [] temp = new int[N];
		for(int i=0;i<N;i++)
			data[i] = rd.nextInt(N);
		
//		System.out.println("input data:");
//		for(int i=0;i<N;i++)
//			System.out.print(data[i]+", ");
//		System.out.println();
		
		k = 55555;								// input k
		
		temp = Arrays.copyOf(data, N);
		long start = System.currentTimeMillis();
		quickSort(temp, 0, N-1);				// quickSort -> pick k-th data
		System.out.println("k-th data: "+temp[k-1]);
		System.out.println("Elapsed: "+((long) System.currentTimeMillis()-start)/1000.0);
//		System.out.println("sorted data:");
//		for(int i=0;i<N;i++)
//			System.out.print(temp[i]+", ");
//		System.out.println();
		
		temp = Arrays.copyOf(data, N);
		start = System.currentTimeMillis();
		quickSelection(temp, 0, N-1);
		System.out.println("Elapsed: "+((long) System.currentTimeMillis()-start)/1000.0);
	}
	
	private static void quickSort(int[] data, int p, int r) {
		if(p<r) {
			int q = partition(data, p, r);
			quickSort(data, p, q-1);
			quickSort(data, q+1, r);
		}
	}
	private static int partition(int[] data, int p, int r) {
		int median = data[(p+r)/2];
		int x,temp;
		int max = Math.max(Math.max(data[p], median), data[r]); 
		if(max==data[p]) {
			x = median<data[r]?data[r]:median;
			temp = median<data[r]?r:((p+r)/2);
		}else if (max==median) {
			x = data[p]<data[r]?data[r]:data[p];
			temp = data[p]<data[r]?r:p;
		}else {
			x = data[p]<median?median:data[p];
			temp = data[p]<median?((p+r)/2):p;
		}
		data[temp] = data[r];
		data[r] = x;
		
		int i=p-1;
		for(int j=p;j<r;j++) {
			if(data[j] < x) {
				i++;
				temp = data[j];
				data[j] = data[i];
				data[i] = temp;
			}
		}
		
		temp = data[i+1];
		data[i+1] = data[r];
		data[r] = temp;
		
		return i+1;
	}
	private static void quickSelection(int[] data, int p, int r) {
		if(p<r) {
			int q = partition(data, p, r);
			if(k-1==q)	{// �ǹ����� ���� ���� ������ k-1�� ���
				System.out.println("k-th data: "+data[q]);
				return;
			}
			else if(k-1<q){	// �ǹ����� ���� ���� ������ k���� ū ���
				quickSelection(data, p, q-1);
			}else if(k-1>q)	// �ǹ����� ���� ���� ������ k���� ū ���
				quickSelection(data, q+1, r);
		}else
			System.out.println("k-th data: " + data[k-1]);		// ������ �ᱹ ��� ��ģ ���
	}
}
