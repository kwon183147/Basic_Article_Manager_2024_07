import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("명령어) ");		
			String cmd = sc.nextLine();
			System.out.println("입력된 명령어: " + cmd );
			if(cmd.equals("종료")) {
				break;
			}
		}
		sc.close();
		System.out.println("==프로그램 종료==");
	}
}
