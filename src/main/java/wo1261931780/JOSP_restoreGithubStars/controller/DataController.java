package wo1261931780.JOSP_restoreGithubStars.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wo1261931780.JOSP_restoreGithubStars.config.ShowResult;
import wo1261931780.JOSP_restoreGithubStars.entity.Repositories;
import wo1261931780.JOSP_restoreGithubStars.service.DataService;
import wo1261931780.JOSP_restoreGithubStars.service.GitHubService;

import java.util.List;

/**
 * 数据管理控制器
 * @author liujiajun_junw
 */
@RestController
@RequestMapping("/data")
@Slf4j
public class DataController {
	@Autowired
	private DataService dataService;
	@Autowired
	private GitHubService gitHubService;

	/**
	 * 先在 github 中获取最新数据，然后将其保存到本地数据库
	 * @return 成功失败
	 */
	@PutMapping("/queryAndSaveAllRepository")
	public ShowResult<String> getStarredRepositories() {
		List<Repositories> repositoriesList = gitHubService.getStarredRepositories("wo1261931780");
		repositoriesList.forEach(repositories -> dataService.insertOrUpdate(repositories));
		boolean success = !repositoriesList.isEmpty();
		if (success) {
			return ShowResult.sendSuccess("同步成功,共保存" + repositoriesList.size() + "个仓库", "操作成功");
		}
		return ShowResult.sendError("同步失败,未获取到数据");
	}

	/**
	 * 查询本地的数据库，不调用远程 api
	 * @param page 页数
	 * @param limit 每页数据量
	 * @return 分页结果
	 */
	@GetMapping("/queryDatabase")
	public ShowResult<Page<Repositories>> getDatabase(
			@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit
	) {
		Page<Repositories> repositoriesPage = new Page<>();
		repositoriesPage.setCurrent(page);
		repositoriesPage.setSize(limit);
		LambdaQueryWrapper<Repositories> wrapper = new LambdaQueryWrapper<>();
		wrapper.orderByDesc(Repositories::getId);
		Page<Repositories> respage = dataService.page(repositoriesPage, wrapper);
		log.info("查询到 {} 条数据", respage.getTotal());
		return ShowResult.sendSuccess(respage);
	}
}
