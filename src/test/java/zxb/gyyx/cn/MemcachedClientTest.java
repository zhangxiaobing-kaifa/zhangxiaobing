package zxb.gyyx.cn;

import java.util.List;

import junit.framework.Assert;
import zxb.gyyx.cn.entity.GameInfo;
import zxb.gyyx.cn.entity.ServerInfo;
import zxb.gyyx.cn.persistenc.GameDao;
import zxb.gyyx.cn.persistenc.MemcachedDao;
import zxb.gyyx.cn.persistenc.ServerDao;

public class MemcachedClientTest {
	MemcachedDao mem=new MemcachedDao();
	//测试设置memcached
	@org.junit.Test
	public void TestSetMemcached() {
		ServerInfo server=new ServerInfo();
		server.setCode(1);
		server.setName("b");
		
		mem.SetInfo(server);
		
	}
	
	//测试获取memcached
	@org.junit.Test
	public void TestGetMemcached() {
		String name=mem.GetInfo("1");
		Assert.assertEquals(name,"b"); 
	}

	//测试获取游戏
	@org.junit.Test
	public void TestGameDao()
	{
		GameDao gameDao=new GameDao();
		List<GameInfo> result=gameDao.queryList();
		Assert.assertEquals(result.size(),1); 
	}
	
	//测试根据游戏获取服务器列表
	@org.junit.Test
	public void TestqueryListByGameId()
	{
		ServerDao server=new ServerDao();
		List<ServerInfo> result=server.queryListByGameId(1);
		Assert.assertEquals(result.size(),3); 
	}
	
	//测试获取服务器列表
	@org.junit.Test
	public void TestqueryListById()
	{
		ServerDao server=new ServerDao();
		List<ServerInfo> result=server.queryListById(1);
		Assert.assertEquals(result.size(),1); 
	}
	
	//测试更新
	@org.junit.Test
	public void TestUpdateServerById()
	{
		ServerDao server=new ServerDao();
		server.UpdateServerById("d");
	}

}
