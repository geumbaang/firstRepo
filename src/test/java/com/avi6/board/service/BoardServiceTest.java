package com.avi6.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.avi6.board.dto.BoardDTO;
import com.avi6.board.dto.PageRequestDTO;
import com.avi6.board.dto.PageResultDTO;

import jakarta.transaction.Transactional;

//Board Service Layer Unit Test class
@SpringBootTest
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;
	
	@Test
	void boardUpdateTest() {
		BoardDTO boardDTO = BoardDTO.builder()
				.bno(10L)
				.title("바뀐 제목")
				.content("바뀐 내용입니당.")
				.build();
		
		boardService.updateArticle(boardDTO);
	}
	
	//@Test
	void delArticle() {
		boardService.delArticle(1L);
	}
	
	//@Test
	void getDetail() {
		System.out.println(boardService.get(101L));
	}
	
	//@Test//list 항목 얻어내기 테스트
	void getBoardList() {
		
		PageRequestDTO pageRequestDTO = new PageRequestDTO();//1페이지 10개의 항목 요청
		pageRequestDTO.setPage(2);//2페이지로 세팅
		
		PageResultDTO<BoardDTO, Object[]> res = boardService.getList(pageRequestDTO);
		
		
		for(BoardDTO boardDTO : res.getDtoList()) {
			System.out.println(boardDTO);
		}
		
	}
	
	//@Test//신규글 등록 테스트
	void registerTest() {
		BoardDTO boardDTO = BoardDTO.builder()
				.title("이건 신규 등록 테스트 제목글")
				.content("이건 신규 등록 테스트의 내용글")
				.writerEmail("user77@abc.com")
				.build();
		
		boardService.register(boardDTO);
	}
	
	
}
