package project.steam.abc.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import project.steam.abc.review.dto.ReviewDTO;
import project.steam.abc.review.service.ReviewService;


@Controller

@Slf4j

public class ReviewController {
	
	@Autowired
	
	private ReviewService reviewService;
	
	
	// ========= 리뷰 전체 조회 ===========
	
//	@RequestMapping(value = "ReviewSelect" , method = RequestMethod.GET)
	@RequestMapping("/ReviewSelect")
	public String list(Model model) {
		model.addAttribute("list", reviewService.reviewSelectAll());
		log.info("전체 조회 " + model);
		return "./review/review_select_all_view";
	}
	
	// ============ 리뷰 상세 조회 ========
	
//	@RequestMapping (value = "/ReviewSelectDetail", method = RequestMethod.GET)
	@RequestMapping ("/ReviewSelectDetail")
	public String detail(Model model, ReviewDTO reviewDTO) {
		model.addAttribute("reviewDTO", reviewService.reviewSelect(reviewDTO.getRvno()));
		log.info("상세 조회" + model);
		return "./review/review_select_view";
	}
	
	// ======= 리뷰 작성  =============
	
	@RequestMapping("/ReviewInsert")
	public String insert() {
		return "./review/review_insert";
	}
	
	@RequestMapping(value = "/ReviewInsert", method = RequestMethod.POST)
	public String insert ( Model model, ReviewDTO reviewDTO) {
		//model.addAttribute("list", reviewService.reviewSelectAll());
		reviewService.reviewInsert(reviewDTO);
		model.addAttribute("reviewDTO");
		System.out.println(reviewDTO);
		log.info("리뷰 작성 값 확인 ===============" +reviewDTO);
		log.info("리뷰 작성 값 확인 ===============" + reviewService);
		return "./review/review_insert_view";
	}
	
	
	// ========== 리뷰 수정 ==============
	
	@RequestMapping(value = "ReviewUpdate", method = RequestMethod.GET)
	
	public String update(Model model, ReviewDTO reviewDTO) {
		
		model.addAttribute("reviewDTO", reviewService.reviewSelect(reviewDTO.getRvno()));
		return "./review/review_update";
	}
	
	@RequestMapping(value = "ReviewUpdate", method = RequestMethod.POST)
	
	public String update(ReviewDTO reviewDTO) {
		
		reviewService.reviewUpdate(reviewDTO);
		return "./review/review_update_view";
	
	}
	
	// =========== 리뷰 삭제 ============
	
	@RequestMapping(value = "/ReviewDelete", method = RequestMethod.GET)
//	@RequestMapping("./ReviewDelete")
	
	public String delete() {
		return "./review/review_delete";
	}
	
	@RequestMapping(value = "/ReviewDelete", method = RequestMethod.POST)
	
	public String delete(ReviewDTO reviewDTO) {
		
		reviewService.reviewDelete(reviewDTO.getRvno());
		return "./review/review_delete_view";
	}

	

}
