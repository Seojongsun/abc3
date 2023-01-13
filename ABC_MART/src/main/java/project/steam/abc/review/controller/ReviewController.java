package project.steam.abc.review.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import project.steam.abc.review.dto.ReviewDTO;
import project.steam.abc.review.service.ReviewService;
import project.steam.abc.review.utils.Paging;
import project.steam.abc.review.utils.UploadFileUtils;

@Controller

@Slf4j

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Autowired(required = false)
	@Qualifier("uploadPath")
	private String uploadPath;

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
	@RequestMapping("/ReviewSelectDetail")
	public String detail(Model model, ReviewDTO reviewDTO) {
		model.addAttribute("reviewDTO", reviewService.reviewSelect(reviewDTO.getRvno()));
		log.info("상세 조회" + model);
		return "./review/review_select_view";
	}

//	// ======= 리뷰 작성  원본 =============
//	
//	@RequestMapping("/ReviewInsert")
//	public String insert() {
//		return "./review/review_insert";
//	}
//	
//	@RequestMapping(value = "/ReviewInsert", method = RequestMethod.POST)
//	public String insert ( Model model, ReviewDTO reviewDTO) {
//		reviewService.reviewInsert(reviewDTO);
//		model.addAttribute("list", reviewService.reviewSelectAll());	
//		
//		log.info("리뷰 작성 값 확인 ===============" + model);
//		log.info("리뷰 작성 값 확인 ===============" + reviewService);
//		return "./review/review_insert_view";
//		
//	}

	// ======= 리뷰 작성 이미지 파일 업로드 포함 =============

	@RequestMapping("/ReviewInsert")
	public String insert() {
		return "./review/review_insert";
	}

	@RequestMapping(value = "/ReviewInsert", method = RequestMethod.POST)
	public String insert(Model model, MultipartFile file, ReviewDTO reviewDTO) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		reviewDTO.setRvimg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		reviewDTO.setRvthumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);

		reviewService.reviewInsert(reviewDTO);
		model.addAttribute("list", reviewService.reviewSelectAll());

		log.info("리뷰 작성 값 확인 ===============" + model);
		log.info("리뷰 작성 값 확인 ===============" + reviewService);
		
		return "./review/review_insert_view";

	}

	// ========== 리뷰 수정 ==============

	@RequestMapping(value = "/ReviewUpdate", method = RequestMethod.GET)

	public String update(Model model, ReviewDTO reviewDTO) {

		model.addAttribute("reviewDTO", reviewService.reviewSelect(reviewDTO.getRvno()));
//		model.addAttribute("list", reviewService.reviewSelectAll());
		return "./review/review_update";
	}

	@RequestMapping(value = "/ReviewUpdate", method = RequestMethod.POST)

	public String update( MultipartFile file,  ReviewDTO reviewDTO ) throws  Exception {
		
		log.info("post reviewDTO review_update");
		
//		model.addAttribute("list", reviewService.reviewSelectAll());
	

		   // 새로운 파일이 등록되었는지 확인
		   if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			   
		    // 기존 파일을 삭제
//		    new File(uploadPath + req.getParameter("rvimg")).delete();
//		    new File(uploadPath + req.getParameter("rvthumbimg")).delete();
		    
		    new File(uploadPath + reviewDTO.getRvimg()).delete();
		    new File(uploadPath + reviewDTO.getRvthumbimg()).delete();
		    
		    // 새로 첨부한 파일을 등록
		    String imgUploadPath = uploadPath + File.separator + "imgUpload";
		    String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		    String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		    
		    reviewDTO.setRvimg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		    reviewDTO.setRvthumbimg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		    
		   } else {  // 새로운 파일이 등록되지 않았다면
		    // 기존 이미지를 그대로 사용
//		    reviewDTO.setRvimg(req.getParameter("rvimg"));
//		    reviewDTO.setRvthumbimg(req.getParameter("rvthumbimg"));
			   
		    reviewDTO.setRvimg(reviewDTO.getRvimg());
		    reviewDTO.setRvimg(reviewDTO.getRvthumbimg());
		    
		   }
		   
			reviewService.reviewUpdate(reviewDTO);
			
			System.out.println("리뷰 디티오 ==========" + reviewDTO);
			System.out.println("리뷰 서비스 ==========" + reviewService);
			
//			model.addAttribute("list", reviewService.reviewSelectAll());
		
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
	
	
	
	
	// =========== 리뷰 목록 조회
	
	@RequestMapping ( value = "/list", method = RequestMethod.GET)
	public String list ( Model model , Paging paging) throws Exception{
		model.addAttribute("list", reviewService.list(paging));
		return "review/list";
		
	}
	
	
		
		
	}
	

