package com.avi6.board.service;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.avi6.board.dto.ReplyDTO;

@SpringBootTest
public class ReplyServiceTest {

	@Autowired
	private ReplyService replyService;
	
	@Test
	void getReplyList() {
		List<ReplyDTO> res = replyService.getList(22L);
		
		res.forEach(dto -> System.out.println(dto));
	}
	
	//@Test
	void registerTest() {
		ReplyDTO replyDTO = ReplyDTO.builder()
				.text("신규 댓글입니당")
				.replyer("guest")
				.bno(14L)
				.build();
		
		replyService.register(replyDTO);
	}
}
