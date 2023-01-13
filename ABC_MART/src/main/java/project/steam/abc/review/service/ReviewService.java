package project.steam.abc.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import project.steam.abc.review.dao.ReviewDAO;
import project.steam.abc.review.dto.ReviewDTO;
import project.steam.abc.review.utils.Paging;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public List<ReviewDTO> reviewSelectAll(){
		return reviewDAO.selectAll();
	}
	
	
	public ReviewDTO reviewSelect(int rvno) {
		return reviewDAO.select(rvno);
	}
	
	public void reviewInsert(ReviewDTO reviewDTO) {
		
//		try {
			reviewDAO.insert(reviewDTO);
//		} catch (DataIntegrityViolationException e) {
//			e.printStackTrace();
//		}
	}
	
	public void reviewUpdate (ReviewDTO reviewDTO) {
		reviewDAO.update(reviewDTO);
	}
	
	public void reviewDelete(int rvno) {
		reviewDAO.delete(rvno);
	}
	
	
	// ============ 리뷰 목록 조회
	public List<ReviewDTO> list (Paging paging) throws Exception{
		return reviewDAO.list(paging);
	}
	
	// ============== 리뷰 총 갯수
	public int rvCount () throws Exception{
		return reviewDAO.rvCount();
	}
	
	
	
	
	

}
