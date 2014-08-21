package zxb.gyyx.cn.persistenc;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;

public class MemcachedCilentCommon {
	 String name = null;  
	  
	    public String getName() {  
	        return name;  
	    }  
	  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	  
	    private MemcachedCilentCommon() {  
	    }  
	  
	    private static XMemcachedClient memcachedClient;
	  
	    public static XMemcachedClient createClient() {  
	        if (memcachedClient == null) {  
	        	
	        	try {
	    			memcachedClient= new XMemcachedClient("192.168.6.195",10001); 
	    	    	} 
	    		catch (Exception ex) 
	    		{
	    	    	ex.printStackTrace();
	    	    }	        	
	        }  
	        
	        return memcachedClient;  
	    }  
	  
	    public void printInfo() {  
	        System.out.println("the name is " + name);  
	    } 
}
