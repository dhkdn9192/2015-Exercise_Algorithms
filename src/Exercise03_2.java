/*
 * N=1,2,...,15�� ���ؼ� N-queens ������ ���� ������ ī��Ʈ�ϴ� ���α׷��� �ۼ��϶�.
 */
public class Exercise03_2 {
	private static int N;
	private static int[] cols;	// �� �ະ�� �� ��° ���� ���� ������ ������ �迭. cols[1] = 2�� 1�� ��, 2������ ���� ���Ҵٴ� ��. �̷ν� ������ �迭�� �� �ʿ䰡 ��������.
	private static int cnt;
	public static void main(String [] args) {
		long start = System.currentTimeMillis();
		for(N=1;N<=15;N++) {
			cols = new int[N+1];
			cnt = 0;
			nqueens(0);
			System.out.println(cnt);	// �� 0���� �����ұ�? 0���� �����ؾ� 1�� 1������ cols[level+1] = i�� �˻��� �� ����.
		}
		System.out.println("Elapsed: "+(((long)System.currentTimeMillis())-start)/1000.0);
	}
	public static void nqueens(int level) {
		if(!promising(level))
			return ;
		else if(level==N) {
			cnt++;
			return ;
		}
		//if(level==0) index = N/2;	// if(level==0) cols[level+1]=1~N/2 �� �� ����� ������? N�� ¦���̸� 1~N/2�� �˻��ϰ� ���� ������ �� �踦 ���ذ� ��.
		for(int i=1;i<=N;i++) {
			cols[level+1] = i; // ���� �������� ������ �˻��� cols �ε����� ������
			nqueens(level+1);
		}
	}
	public static boolean promising(int level) {
		for(int i=1;i<level;i++) {
			if(cols[i]==cols[level])	// ���� ���� �ֳ�? 
				return false;
			if(level-i==Math.abs(cols[level]-cols[i]))	// �밢�� �� �ֳ�?
				return false;
		}
		return true;
	}
}
