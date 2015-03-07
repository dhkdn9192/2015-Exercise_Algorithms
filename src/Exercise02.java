public class Exercise02 {
	public static void main(String [] args) {
		int n=10;
		int [] data = {12, 1, 0, 3, 7, 4, 9, 5, 1, 15};
		// �ۼ��� �޼��带 ȣ���Ͽ� ���� ���� �� ����϶�.
		System.out.println(evenSum(data,0));
		System.out.println(oddSum(data,0));
	}
	/*
    / �迭 data�� ����� n���� ������ �� ¦���鸸�� ���� ���Ͽ� ��ȯ�ϴ� �޼��带
    / ���⿡ recursion���� �ۼ��϶�.
	 */
	public static int evenSum(int [] data, int begin) {
		if(begin>data.length-1) return 0;
		int temp = data[begin];
		return (temp%2==0?temp:0)+evenSum(data, begin+1);
	}
	public static int oddSum(int [] data, int begin) {
		if(begin>data.length-1) return 0;
		int temp = data[begin];
		return (temp%2==1?temp:0)+evenSum(data, begin+1);
	}

}