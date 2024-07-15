import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		Scanner sc = new Scanner(System.in);
		
		int lastArticleId = 0;
		List<Article> articles = new ArrayList<>();
				
		while(true) {
			System.out.printf("명령어) ");	
			
			String cmd = sc.nextLine().trim();
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			
			if(cmd.equals("article write")) {
				System.out.printf("제목: ");
				String title = sc.nextLine();
				System.out.printf("내용: ");
				String body = sc.nextLine();
				
				lastArticleId++;
				
				Article article = new Article(lastArticleId, title, body);
				
				article.id = lastArticleId;
				article.title = title;
				article.body = body;
				
				articles.add(article);
				
				System.out.println(++lastArticleId + "번 글이 생성되었습니다.");
			
			} else if(cmd.equals("article list")) {
				System.out.println("게시글이 없습니다");
			} else {
				System.out.println("존재하지않는 명령어 입니다");
			}
			
			
		}
		
		sc.close();
		
		System.out.println("==프로그램 종료==");
	}
}

class Article {
	int id;
	String title;
	String body;
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	}