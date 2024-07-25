package com.exam.Bam.app;

import java.util.Scanner;

import com.exam.Bam.controller.ArticleController;
import com.exam.Bam.controller.Controller;
import com.exam.Bam.controller.MemberController;

public class App {
	public void run() {
		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		memberController.makeTestData();
		articleController.makeTestData();
		
		while (true) {
			System.out.printf("명령어) ");
			
			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("exit")) {
				break;
			} 
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			String[] cmdBits = cmd.split(" ");

			if (cmdBits.length < 2) {
				System.out.println("존재하지 않는 명령어 입니다");
				continue;
			}

			String controllerName = cmdBits[0];
			String methodName = cmdBits[1];

//			if (methodName.equals("write") || methodName.equals("modify") || methodName.equals("delete") || methodName.equals("logout")) {
//				if (Controller.loginedMember == null) {
//					System.out.println("로그아웃부터 하고 와");
//					continue;
//				}
//			} else if (methodName.equals("join") || methodName.equals("login")) {
//				if (Controller.loginedMember != null) {
//					System.out.println("로그인부터 하고 와");
//					continue;
//			}
			switch (methodName) {
			case "write":
			case "modify":
			case "delete":
			case "logout":
				if (Controller.loginedMember != null) {
					System.out.println("로그인부터 하고 와");
					continue;
				}
				break;
			case "join":
			case "login":
				if (Controller.loginedMember != null) {
					System.out.println("로그아웃부터 하고 와");
					continue;
				}
			}
			
			Controller controller = null;

			if (controllerName.equals("member")) {
				controller = memberController;
			} else if (controllerName.equals("article")) {
				controller = articleController;
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
				continue;
			}
			
			controller.doAction(cmd, methodName);
		}
		
		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}