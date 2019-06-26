package com.care.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.model.dto.MemberDTO;
import com.care.service.MemberService;

// 회원정보 관리
@Controller
@RequestMapping("/member/*") // 공통적인 url mapping
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject // MemberService 객체가 주입됨
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	@RequestMapping("login_check.do")
	public String login_check(@ModelAttribute MemberDTO dto, HttpSession session, Model model) {
		// 로그인 성공=>이름이 넘어옴, 실패=>null이 넘어옴
		logger.info("dto : " + dto);
		logger.info("session : " + session);
		logger.info("model : " + model);
		String name = memberService.loginCheck(dto, session);
		logger.info("name : " + name);
		if(name != null) { // 로그인 성공하면 시작 페이지로 이동
			return "main";
		} else { // 로그인 실패하면 login 페이지로 다시 되돌아감
			model.addAttribute("message","error");
			return "member/login";
		}
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		memberService.logout(session); // 세션 초기화 작업
		model.addAttribute("message","logout"); // 변수 저장
		return "member/login";
	}
	
	@RequestMapping("list.do") // 사용자가 요청하는 주소
	public String memberList(Model model) {
		List<MemberDTO> list = memberService.memberList();
		logger.info("회원목록 : " + list);
		model.addAttribute("list",list); // 모델에 저장
		return "member/member_list"; // 출력 페이지로 포워딩
	}
	
	@RequestMapping("write.do")
	public String write() {
		return "member/write";
	}
	
	// 폼에 입력한 데이터가 MemberDTO dto 변수에 저장됨
	// request.getParameter 생략
	@RequestMapping("insert.do")
	// @ModelAttribute MemberDTO : write.jsp -> form에서 저장된 전체데이터를 저장할 변수
	public String insert(@ModelAttribute MemberDTO dto) {
		memberService.insertMember(dto);
		return "redirect:/member/list.do"; // 목록 갱신 redirect를 안하면 포워드가 되서 주소가 안바뀜
	}
	
	// view.do?userid=kim 이라면
	// @RequestParam String userid 변수에 kim이 저장됨
	@RequestMapping("view.do")
	// @RequestParam String user id : form에서 저장된 개별값
	public String view(@RequestParam String userid, Model model) {
		// System.out.println("클릭한 아이디 : " + userid);
		// info, debug, warn, error
		logger.info("클릭한 아이디 : " + userid);
		// 회원정보를 모델에 저장
		model.addAttribute("dto", memberService.viewMember(userid));
		// view.jsp로 포워딩
		return "member/view";
	}
	
	@RequestMapping("update.do")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		boolean result = memberService.checkPw(dto.getUserid(), dto.getPasswd());
		logger.info("비밀번호 확인 : " + result);
		
		if(result) { // 비밀번호가 맞으면
			memberService.updateMember(dto); // 레코드 수정
			return "redirect:/member/list.do"; // 목록으로 이동
		} else { // 비밀번호가 틀리면
			MemberDTO dto2 = memberService.viewMember(dto.getUserid());
			dto.setJoin_date(dto2.getJoin_date()); // 날짜가 지워지지 않도록
			model.addAttribute("dto",dto);
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			return "member/view"; // 수정 페이지로 되돌아감
		}
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
		boolean result = memberService.checkPw(userid, passwd);
		if(result) {
			memberService.deleteMember(userid);
			return "redirect:/member/list.do";
		}else {
			model.addAttribute("message","비밀번호가 일치하지 않습니다.");
			model.addAttribute("dto", memberService.viewMember(userid));
			return "member/view";
		}
	}
}
