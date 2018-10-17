package org.zerock.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.OrderList;
import org.zerock.domain.StoreVO;
import org.zerock.domain.Todo;
import org.zerock.service.TodoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller //어노테이션
@RequestMapping("/todo/*") //투두로 시작하는 유알엘은 모두 여기로 옴. 겟,포스트 둘다 받을땐,, 따로 받을땐 겟맵핑, 포스트맵핑 따로
@Log4j
@AllArgsConstructor //자동 주입
public class TodoController {
	//등록화면은 파라미터 필요없고 get 방식
	//void 경우 리퀘스트의 경로가 jsp이름
	//if else가 필요한 경우는 string 반환. 성공 실패를,,
	
	private TodoService service; //자동주입이용
	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
		
		return service.getStores(cat);
		
	}
	
	@GetMapping("/list2")
	@ResponseBody //jsp가 필요하지 않음. 내부적으로 결과를 반환함.
	public ResponseEntity<List<Todo>> list2(){
		//return service.getList(); //제이슨 데이타 출력
		
		return new ResponseEntity<List<Todo>>(service.getList(), HttpStatus.OK); //responseEntity로 바꾼 후
		//내가 처리를 했을 때 잘됐는지 상태까지 보내도록 하는 것.
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("list..");
	}
	
	
	@GetMapping("/register")
	public void register() {
		log.info("register");
	}
	
	//배열
	@GetMapping("/exArray")
	public String exArray(String[] ids) {
		log.info(Arrays.toString(ids));
		return "todo/success";
	}
	
	
	//ordervo
	@GetMapping("/order")
	public String order(OrderList list,Model model) { //List<OrderVO> 불가하므로 꼼수.. // 토탈을 전달하고 싶으나 리스트엔 없을 경우 모델.
		log.info(list);
		model.addAttribute("total", 3000); //토탈은 모델
		
		return "todo/success";
	}
	
	
	//버튼 누르면 포스트 동작 위해
	@PostMapping("/register")
	public String registerPost(/*@RequestParam("sample")String name, @ModelAttribute("result")*/Todo todo,RedirectAttributes rttr) { //model을 하므로써 jsp에서 result로 이름 사용 가능해짐.
		log.info(todo);
		
		//return "todo/success"; //여기로 가게 하는 것. 
		
		//리스트 추가
		//새로고침시 도배. -> redirectattribute로 바로 리스트로 가게.
		rttr.addFlashAttribute("result","SUCCESS"); //게시물 등록 성공?실패? . 플래쉬는 한번만 사용가능. 세션에 들어감.
		return "redirect:/todo/list";
	}
	
	

}
