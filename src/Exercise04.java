import java.util.Scanner;


public class Exercise04 {
	public static double[][] combinations;
	public static void main(String [] args){
		try {
			Scanner kb = new Scanner(System.in);
			int N=kb.nextInt(); 
			int M=kb.nextInt();
			combinations = new double[N+M+1][];
			for(int i=0;i<=N+M;i++) combinations[i] = new double[N+1];
			
			long start = System.currentTimeMillis();
			System.out.println(memorize_combination(N+M,N));
			System.out.println("Elapsed: "+(((long)System.currentTimeMillis())-start)/1000.0);
			}catch(Exception e){e.printStackTrace();}
	}
	public static double memorize_combination(int n, int k){
		if(k==0) {combinations[n][k]=1;return 1;}
		else if(k==n) {combinations[n][k]=1;return 1;}
		else{
			combinations[n][k] = (combinations[n-1][k]==0?memorize_combination(n-1,k):combinations[n-1][k])+(combinations[n-1][k-1]==0?memorize_combination(n-1,k-1):combinations[n-1][k-1]);
			return combinations[n][k];
		}
	}
	/*
	 * C(N+M,N)�� ������
	 * N*M �׸��忡�� [0][0]���� [N-1][M-1]���� �ִܰŸ��� �̵��� ���� ��μ��� ���ϴ� �����̴�.
	 * �Ʒ��� �̵��� D, ���������� �̵��� R�̶� �� ��
	 * N���� D, M���� R�� �ʿ��ϴ�.
	 * D�� R�� N+M���� ��ĭ�� ä��� ��츦 �����ϸ� ���,
	 * N+M���� ��ĭ �� D�� R�� �� �ڸ��� ���� ���̴�.
	 * D�� �� �ڸ��� �� �� -> C(N+M,N) == C(N+M,M) <- R�� �� �ڸ��� �� ��
	 */
}