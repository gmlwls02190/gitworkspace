package model.heart;

public interface HeartService {
	boolean insertHeart(HeartVO vo);
	HeartVO getHeart(HeartVO vo);
	boolean updateHeart(HeartVO vo);
	boolean deleteHeart(HeartVO vo);
}
