public class EuclidMethod {
	public static void main(String [] args) {
		System.out.println(gcd(8, 64));
	}
	public static int gcd(int p, int q){
		if(q==0) return p;	// p%q == 1 �̸� ���� ȣ�� �� q%1�� �ǹǷ� 0�� �Ǿ� base case�� �����Ѵ�
		else return gcd(q, p%q);	// p<q�� �Ǿ p%q == p �̹Ƿ� swap�� �Ͼ��
	}
}
