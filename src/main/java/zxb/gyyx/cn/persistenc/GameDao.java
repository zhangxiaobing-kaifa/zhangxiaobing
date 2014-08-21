package zxb.gyyx.cn.persistenc;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zxb.gyyx.cn.entity.GameInfo;
import zxb.gyyx.cn.persistenc.Base;

public class GameDao extends Base {
	private SqlSession session = null;

	public List<GameInfo> queryList() {
		String smtpId = "GameInfo.queryList";
		List<GameInfo> list = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList(smtpId, null);
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return list;
	}
}
