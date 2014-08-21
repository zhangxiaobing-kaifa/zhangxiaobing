package zxb.gyyx.cn.persistenc;

import net.rubyeye.xmemcached.MemcachedClient;
import zxb.gyyx.cn.entity.ServerInfo;

public class MemcachedDao {

private static MemcachedClient uniqueInstance =  MemcachedCilentCommon.createClient();
	    
	public Boolean SetInfo(ServerInfo model)
	{
		try {
			Object value = uniqueInstance.get(model.getCode()+"");
			if (value != null) {
				uniqueInstance.delete(model.getCode()+"");
			}
			uniqueInstance.set(model.getCode()+"", 20, model.getName());
			
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	public String GetInfo(String code)
	{
		try {
			Object value = uniqueInstance.get(code);
					
			return value.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
			return "";
		}
	}
}
