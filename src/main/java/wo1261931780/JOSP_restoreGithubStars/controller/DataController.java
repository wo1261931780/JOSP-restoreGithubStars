package wo1261931780.JOSP_restoreGithubStars.controller;

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

	@PutMapping("/queryAndSaveAllRepository")
	public Boolean getStarredRepositories() {
		List<Repositories> repositoriesList = gitHubService.getStarredRepositories("wo1261931780");
		repositoriesList.forEach(repositories -> dataService.insertOrUpdate(repositories));
		return !repositoriesList.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
	}

	@GetMapping("/queryDatabase")
	public Page<Repositories> getDatabase(
			@RequestParam Integer page
			, @RequestParam Integer limit
	) {
		Page<Repositories> repositoriesPage = new Page<>();
		repositoriesPage.setCurrent(page);
		repositoriesPage.setSize(limit);
		return dataService.page(repositoriesPage);
	}
}
