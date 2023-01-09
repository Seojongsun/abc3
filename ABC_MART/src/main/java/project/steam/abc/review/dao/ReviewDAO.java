package project.steam.abc.review.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import project.steam.abc.review.dto.ReviewDTO;

@Repository


@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ReviewDAO {
	
	

	@Autowired
		SqlSessionTemplate sqlSessionTemplate;
	
	
	// ========== 전체 조회 ==========
	public List<ReviewDTO> selectAll(){
		return sqlSessionTemplate.selectList("selectAll");
	}
	
	
	// ================ 상세 조회 ===========
	public ReviewDTO select(int rvno) {
		return sqlSessionTemplate.selectOne("select", rvno);
	}
	
	
	// =============== 리뷰 작성 =============
	@Transactional
	public void insert(ReviewDTO reviewDTO) {
		sqlSessionTemplate.insert("insert", reviewDTO);
		System.out.println("인서트 ㅏㅡㅡㅡㅡㅡㅡㅡㅡ" + sqlSessionTemplate);
	}
	
	// =========== 리뷰 수정 ============
	public void update (ReviewDTO reviewDTO) {
		sqlSessionTemplate.update("update", reviewDTO);
	}
	
	// ============ 리뷰 삭제 ==========
	public void delete (int rvno) {
		sqlSessionTemplate.delete("delete", rvno);
	}
	
	
	

}
