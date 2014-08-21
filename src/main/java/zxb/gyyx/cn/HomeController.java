package zxb.gyyx.cn;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zxb.gyyx.cn.entity.GameInfo;
import zxb.gyyx.cn.entity.ServerInfo;
import zxb.gyyx.cn.persistenc.GameDao;
import zxb.gyyx.cn.persistenc.MemcachedDao;
import zxb.gyyx.cn.persistenc.ServerDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private GameDao gameDao;
	private ServerDao serverDao;

	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		gameDao = new GameDao();
		List<GameInfo> list = gameDao.queryList();
		serverDao = new ServerDao();
		List<ServerInfo> lists = serverDao.queryListById(1);
		model.addAttribute("serverList", lists);
		model.addAttribute("gameList", list);
		MemcachedDao memcached=new MemcachedDao();
		memcached.SetInfo(lists.get(0));
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(ServerInfo model,HttpServletRequest request) {
		String serverName = request.getParameter("serverName").toString();
		serverDao = new ServerDao();
		serverDao.UpdateServerById(serverName);
		return "home";
	}

	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getServerList", method = RequestMethod.GET)
	public @ResponseBody List<ServerInfo> getServerList(
			@RequestParam("gameId") int gameId) {
		serverDao = new ServerDao();
		List<ServerInfo> list = serverDao.queryListByGameId(gameId);
		return list;
	}
	
	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getServerInfoList", method = RequestMethod.GET)
	public @ResponseBody List<ServerInfo> getServerInfoList(
			@RequestParam("serverId") int serverId) {
		serverDao = new ServerDao();
		List<ServerInfo> list = serverDao.queryListById(serverId);
		return list;
	}
	
	@RequestMapping(value = "/memcahe", method = RequestMethod.GET)
	public String memcahe(Model model) {
		MemcachedDao memcached=new MemcachedDao();
		String name=memcached.GetInfo("1");
		model.addAttribute("name", name);
		return "memcahe";
	}
}
