package egovframework.rte.rex.brd.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.rex.com.service.SearchVO;

/**
 * 게시판 정보에 관한 데이터 접근 클래스를 정의한다. 
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
@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO{

	/**
	 * 데이터 베이스에서 게시판 목록을 읽어와 화면에 출력한다.
	 * @param SearchVO vo
	 * @return List 게시글 목록 리스트
	 * @throws Exception
	 */
	public List selectBoardList(SearchVO vo) throws Exception{
		List list = list("boardDAO.selectBoardList", vo);
		return list;
	}
	
	 /**
	 * 데이터 베이스에서 글 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 글 총 갯수
	 * @exception Exception
	 */
    public int selectBoardListTotCnt(SearchVO searchVO) throws Exception{
        return (Integer)getSqlMapClientTemplate().queryForObject("boardDAO.selectBoardListTotCnt", searchVO);
    }
}
