package zxb.gyyx.cn.persistenc;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Base  {

	private final static String resource = "zxb/gyyx/cn/persistenc/sqlMaps.xml";

	protected SqlSessionFactory sessionFactory;

	protected Base() {
		sessionFactory = createSession();
	}

	private SqlSessionFactory createSession() {
		if (sessionFactory == null) {
			if (sessionFactory == null) {
				try {
					sessionFactory = new SqlSessionFactoryBuilder()
							.build(Resources.getResourceAsReader(resource));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sessionFactory;
	}
}

