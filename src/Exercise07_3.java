import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * �ּҷ� ������ �ִ�. ������ �� ������ �� ����� ���ؼ� �̸�, �ּ�, ��ȭ��ȣ, �׸��� �̸��� �ּ� �ʵ��
 * �����ȴ�. �� �ʵ�� ������ ���� �������� ���ڿ��̸�, �ʵ�� �ʵ�� �ϳ��� �������� ���еǾ� �ִ�.
 * �� �ּҷ� ������ ���� �� ������ ����� �ϳ��� ��ü�� ������ �� ������ ���� ������� ����� �����ϴ� ���α׷��� �ۼ��϶�.
 * ��, �ݵ�� Java API, Ȥ�� C, C++ ǥ�� ���̺귯���� �����ϴ� ���� ����� ����϶�.
 * �� ���� �˰����� ���� �����ؼ��� �ȵȴ�.
 */
public class Exercise07_3 {
	public static class Person {
		public String name, address, phone, mail;
		Person(String n, String a, String p, String m) {name=n;address=a;phone=p;mail=m;}
		String Print() {
			return name+" "+address+" "+phone+" "+mail;
		}
		public static Comparator<Person> nameComparator = new Comparator<Person>() {
			public int compare(Person A, Person B) {
				return A.name.compareTo(B.name);
			}
		};
		public static Comparator<Person> addressComparator = new Comparator<Person>() {
			public int compare(Person A, Person B) {
				return A.address.compareTo(B.address);
			}
		};
		public static Comparator<Person> phoneComparator = new Comparator<Person>() {
			public int compare(Person A, Person B) {
				return A.name.compareTo(B.phone);
			}
		};
		public static Comparator<Person> mailComparator = new Comparator<Person>() {
			public int compare(Person A, Person B) {
				return A.name.compareTo(B.mail);
			}
		};
	}
	
	private static final int MAX = 1000;
	public static void main(String [] args) {
		try {
			Scanner sc = new Scanner(new File("input07_3.txt"));
			Person[] people = new Person[MAX];		// people ������ ���� �ְ� Ȯ�� 
			int size = 0, i=0;
			while(sc.hasNext()) {
				people[i] = new Person(sc.next().trim(),sc.next().trim(),sc.next().trim(),sc.next().trim());
				i++;
				size++;
			}	// file read complete
			sc.close();
			sc = new Scanner(System.in);
			boolean isExit = false;
			while(!isExit) {
				String cmd = sc.nextLine();
				if(cmd.equals("sort by name")) {		// sort by name
					Arrays.sort(people, 0, size, Person.nameComparator);	// ������ �����Ƿ� �ݵ�� ������ ������ ��� ��
				}else if(cmd.equals("sort by address")) {
					Arrays.sort(people, 0, size, Person.addressComparator);	// sort by address
				}else if(cmd.equals("sort by phone")) {
					Arrays.sort(people, 0, size, Person.phoneComparator);	// sort by phone
				}else if(cmd.equals("sort by email")) {
					Arrays.sort(people, 0, size, Person.mailComparator);	// sort by mail
				}else if(cmd.equals("print")) {
					Print(people, size);		// print
				}else if(cmd.equals("exit")) {
					isExit = true;//System.exit(0);				// exit
				}	
			}
			sc.close();
		} catch(FileNotFoundException e) { System.out.println("file not found...");}
	}
	private static void Print(Person[] people, int size) {
		for(int i=0;i<size;i++)
			System.out.println(people[i].Print());
		System.out.println();
	}
}
