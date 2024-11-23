package wo1261931780.JOSP_restoreGithubStars.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wo1261931780.JOSP_restoreGithubStars.entity.Repositories;
import wo1261931780.JOSP_restoreGithubStars.service.DataService;
import wo1261931780.JOSP_restoreGithubStars.service.GitHubService;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * Project:restoreGithubStars
 * Package:wo1261931780.restore_my_stars.controller
 *
 * @author liujiajun_junw
 * @Date 2024-11-23-55  星期四
 * @Description
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
	public Boolean getStarredRepositories() {
		List<Repositories> repositoriesList = gitHubService.getStarredRepositories("wo1261931780");
		repositoriesList.forEach(repositories -> dataService.insertOrUpdate(repositories));
		return !repositoriesList.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * 查询本地的数据库，不调用远程 api
	 * @param page 页数
	 * @param limit 每页数据量
	 * @return 分页结果
	 */
	@GetMapping("/queryDatabase")
	public Page<Repositories> getDatabase(
			@RequestParam Integer page
			, @RequestParam Integer limit
	) {
		Page<Repositories> repositoriesPage = new Page<>();
		repositoriesPage.setCurrent(page);
		repositoriesPage.setSize(limit);
		LambdaQueryWrapper<Repositories> wrapper = new LambdaQueryWrapper<>();

		return dataService.page(repositoriesPage,wrapper);
	}
}
