package egovframework.rte.rex.brd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.rex.brd.service.EgovBoardService;
import egovframework.rte.rex.com.service.SearchVO;

/**
 * 게시판에 관한 비지니스클래스를 정의한다.
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
@Service("boardService")
public class EgovBoardServiceImpl  implements EgovBoardService{

	/** BoardDAO */
    @Resource(name="boardDAO")
	private BoardDAO boardDAO; //데이터베이스 접근 클래스
    
	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	public List selectBoardList(SearchVO searchVO) throws Exception {
		return boardDAO.selectBoardList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 글 총 갯수
	 * @exception Exception
	 */
	public int selectBoardListTotCnt(SearchVO searchVO) throws Exception{
		return boardDAO.selectBoardListTotCnt(searchVO);
	}

}
