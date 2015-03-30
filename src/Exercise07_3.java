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
			//Print(people, size);
			
			// sort by name
			Arrays.sort(people, 0, size, Person.nameComparator);	// ������ �����Ƿ� �ݵ�� ������ ������ ��� ��
			// print
			Print(people, size);
			// sort by address
			Arrays.sort(people, 0, size, Person.addressComparator);
			// print
			Print(people, size);
			// exit
			sc.close();
		} catch(FileNotFoundException e) { System.out.println("file not found...");}
	}
	private static void Print(Person[] people, int size) {
		for(int i=0;i<size;i++)
			System.out.println(people[i].Print());
		System.out.println();
	}
}
