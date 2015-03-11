import java.util.Scanner;

/*
 * 1���� N������ ������ �� Ȧ���鸸�� ���� ���ϴ� ���α׷��� recursion���� �ۼ��϶�. N�� �Է����� �޴´�.
 */

public class Exercise01_2 {
	public static int n;
	
	public static void main(String [] args) {
		// �ۼ��� �޼��带 ȣ���Ͽ� ���� ���� �� ����϶�.
		try {
		n=(new Scanner(System.in)).nextInt();
		System.out.println(oddSum(1));
		}catch(Exception e){e.printStackTrace();}
	}
	/*
    / 1���� n���� ������ �� Ȧ���鸸�� ���� ���Ͽ� ��ȯ�ϴ� �޼��带
    / ���⿡ recursion���� �ۼ��϶�.
	 */
	public static int oddSum(int begin) {
		if(begin>n) return 0;
		return (begin%2==1?begin:0)+oddSum(begin+1);
	}
}