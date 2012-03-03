package egovframework.rte.rex.brd.service;

import java.util.List;

import egovframework.rte.rex.com.service.SearchVO;

/**
 * 게시판에 관한 인터페이스클래스를 정의한다.
 * @author 실행환경 개발팀 신혜연
 * @since 2011.07.11
 * @version 1.0
 * @see 
 * <pre>
 *  == 개정이력(Modification Information) ==
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.07.11  신혜연          최초 생성
 * 
 * </pre>
 */
public interface EgovBoardService {
    
	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @param SearchVO 검색조건
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	List selectBoardList(SearchVO searchVO) throws Exception;
	
    /**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception Exception
	 */
    int selectBoardListTotCnt(SearchVO searchVO) throws Exception;
    
}
