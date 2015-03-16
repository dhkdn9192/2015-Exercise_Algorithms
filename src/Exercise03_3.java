/*
 * N super-queen problem�� N*N ü�� ���忡 N���� super-queen�� ���� �����̴�.
 * N queen������ ���������� � �� ���� ���� ��. ���� ��, Ȥ�� ���� �밢���� ���� �� ����.
 * �ű⿡ ���ؼ� � �� ���� ����� "��"�� �� ���� ������ �� �ִ� ��ġ�� �������� �ȵȴ�.
 * �� (���� 2ĭ, ���� 1ĭ) Ȥ�� (���� 2ĭ, ���� 1ĭ) ������ ��ġ�� �� ���� �������� �ȵȴ�.
 * �̷� ������ �����ϵ��� N���� ���� ���� �� �ִ� N>1�� �ּ� ���� ã�ƶ�.
 */
public class Exercise03_3 {
	private static int N;
	private static int[] cols;	// �� �ະ�� �� ��° ���� ���� ������ ������ �迭. cols[1] = 2�� 1�� ��, 2������ ���� ���Ҵٴ� ��. �̷ν� ������ �迭�� �� �ʿ䰡 ��������.

	public static void main(String [] args) {
		long start = System.currentTimeMillis();
		N=2;	// �������� 2 �̻��� N�� ���Ͽ� ���϶�� �䱸�Ͽ���.
		cols = new int[N+1];
		while(!superQueens(0)) {
			// �� 0���� �����ұ�? 0���� �����ؾ� 1�� 1������ cols[level+1] = i�� �˻��� �� ����.
			
			// ���� N�� ���� superQueens�� �˻��� �غ� �ܰ�
			N++;
			cols = new int[N+1];
		}
		System.out.println(N);
		for(int i=1;i<=N;i++)
			System.out.println("("+i+", "+cols[i]+")");
		System.out.println("Elapsed: "+(((long)System.currentTimeMillis())-start)/1000.0);
	}
	public static boolean superQueens(int level) {
		if(!promising(level))
			return false;
		else if(level==N) {
			return true;
		}
		for(int i=1;i<=N;i++) {
			cols[level+1] = i;	// ���� �������� ������ �˻��� cols �ε����� ������
			if(superQueens(level+1))
				return true;
		}
		return false;
	}
	public static boolean promising(int level) {
		for(int i=1;i<level;i++) {
			if(cols[i]==cols[level])	// ���� ���� �ֳ�? 
				return false;
			if(level-i==Math.abs(cols[level]-cols[i]))	// �밢�� �� �ֳ�?
				return false;
			if(level-1>0&&(cols[level]-2>0||cols[level]+2<=N))	// KNGIHT�� 8���� ���� �̵� ���� ������ cols�� ����ϴ� �� ���ٿ��� �������θ� �˻��ϸ� �ȴ�.
				if(cols[level-1]==cols[level]-2 || cols[level-1]==cols[level]+2)
					return false;
			if(level-2>0&&(cols[level]-1>0||cols[level]+1<=N))
				if(cols[level-2]==cols[level]-1 || cols[level-2]==cols[level]+1)
					return false;
		}
		return true;
	}
}
