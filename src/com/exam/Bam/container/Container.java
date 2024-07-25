package com.exam.Bam.container;

import java.util.ArrayList;
import java.util.List;

import com.exam.Bam.dto.Article;
import com.exam.Bam.dto.Member;

public class Container {
	public static List<Article> articles;
	public static List<Member> members;

	static {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}
}
