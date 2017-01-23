package chap04;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import chap01.crud.Member;
import util.DaoCommon;

public class BoardArticleTest {
	
	
	public static final String SOPHIE = "Sophie";
	DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
	DaoCommon<Member>  daoMember = new DaoCommon<Member>(Member.class);
	
	@Before
	public void setUp() throws Exception {
	
	}

	@Test
	public void test() {		
		BoardArticle boardArticle = new BoardArticle(SOPHIE, "hello", new Date());
		daoBoard.insert(boardArticle);
		
		BoardArticle getBoardArticle = daoBoard.selectById(1);
		assertEquals(SOPHIE, getBoardArticle.getUserId());
	}

}
