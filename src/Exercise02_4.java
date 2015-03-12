
public class Exercise02_4 {
	public static void main(String [] args) {
		String str1 = "abc";
		String str2 = "ab";
		System.out.println(compare(str1, str2));
		System.out.println(solution(str1,str2,0));
	}
	public static int compare(String str1, String str2){
		int temp = str2.charAt(0)-str1.charAt(0);	
		if(temp==0) {											// ���� �˻��ϴ� ���ڰ� ���� ���
			if(Math.min(str1.length(), str2.length())==1) {		// �˻��� ���ڰ� ���� �������� ���
				if(str1.length()==str2.length()) {				// �� ���� ���̰� ���� ���� ������ ��
					return 0;
				} else return str1.length()>str2.length()?1:-1;	// �� ������ ������ ������ �ʴ�
			}return compare(str1.substring(1), str2.substring(1));	// �˻��� ���ڰ� ���� ���
		} else return temp>0?-1:1;	// �� ���ڿ��� ù��° ���ڳ��� ���� ���Ͽ� �ٸ��� ����� ���
	}
	
	public static int solution(String str1, String str2, int begin) {
		if(begin==Math.min(str1.length(), str2.length())){
			return str1.length()>str2.length()?1:str1.length()<str2.length()?-1:0;
		}else return str1.charAt(begin)>str2.charAt(begin)?1:str1.charAt(begin)<str2.charAt(begin)?-1:solution(str1,str2,begin+1);
	}
}