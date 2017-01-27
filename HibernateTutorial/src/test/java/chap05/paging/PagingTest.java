package chap05.paging;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import util.*;

import org.junit.Before;
import org.junit.Test;

public class PagingTest {

	@Before
	public void setUp() throws Exception {
	}

	DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
	
	@Test
	public void testName() throws Exception {
		daoBoard.insert(new BoardArticle("Sophie", "hello", new Date()));
		assertEquals(1, daoBoard.count());
		
		daoBoard.deleteAllSetTable();
		assertEquals(0, daoBoard.count());
		
	}
	
	public void test() throws NumberFormatException, IOException, ParseException {	
		
		
		List<BoardArticle> list = FileReader_CSV.getArticles();
		for(BoardArticle boardArticle:list) {
			daoBoard.insert(boardArticle);
		}
		
		List<BoardArticle> pagingList1 = (List<BoardArticle>)daoBoard.getPagingList(1);
		System.out.println("First Page");
		for(BoardArticle boardArticle:pagingList1) {
			System.out.println(boardArticle);
		}
	
		List<BoardArticle> pagingList2 = (List<BoardArticle>)daoBoard.getPagingList(2);
		System.out.println("Second Page");
		for(BoardArticle boardArticle:pagingList2) {
			System.out.println(boardArticle);
		}	
	}

}
