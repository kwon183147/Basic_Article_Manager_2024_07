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
				
				Article article = new Article(lastArticleId, Util.getDateStr(), title, body);
				
				article.id = lastArticleId;
				article.title = title;
				article.body = body;
				
				articles.add(article);
				
				System.out.println(++lastArticleId + "번 글이 생성되었습니다.");
			
			} else if(cmd.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				}
				
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
					continue;
				}

				System.out.println("번호	|	제목	|		작성일");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s	|	%s\n", article.id, article.title, article.regDate);
				} 
					
			}else if (cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				
				int id = 0;
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 몰바르지 않습니다.");
					continue;
				} catch (Exception e) {
					System.out.println("error: " + e);
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if ( id ==  article.id) {
						foundArticle = article;
						break;
					} 
				}
				
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("번호: %d\n", foundArticle.id);
				System.out.printf("작성일 : %s\n", foundArticle.regDate);
				System.out.printf("제목: %d\n", foundArticle.title);
				System.out.printf("내용: %d\n", foundArticle.body);
				
			} else if (cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");

				int id = 0;

				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				} catch (Exception e) {
					System.out.println("error : " + e);
				}

				Article foundArticle = null;

				for (Article article : articles){
					if (id == article.id) {
						foundArticle = article;
						break;
					}
				}

				if (foundArticle == null) {
					System.out.println(id + "번 게시물은 존재하지 않습니다");
					continue;
				}

				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine();
				System.out.printf("수정할 내용 : ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;

				System.out.println(id + "번 게시물을 수정했습니다");

			}else if (cmd.startsWith("article delete ")) {
					
				String[] cmdBits = cmd.split(" ");
				
				int id = 0;
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("명령어가 몰바르지 않습니다.");
					continue;
				} catch (Exception e) {
					System.out.println("error: " + e);
				}
				
//				Article foundArticle = null;
				
				int foundIndex = -1;
				
				int i =0;
				for (Article article : articles) {
					if ( id ==  article.id) {
						foundIndex = i;
						break;
					} 
					
					i++;
				}
				
				if (foundIndex == -1) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				articles.remove(foundIndex);
				
				System.out.printf(id + "번 게시물이 존재하지 않습니다.");
				
			}else {
				System.out.println("존재하지않는 명령어 입니다");
			}
		}
		
		sc.close();
		
		System.out.println("==프로그램 종료==");
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String body;
	
	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
}