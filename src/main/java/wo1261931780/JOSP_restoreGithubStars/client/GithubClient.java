package wo1261931780.JOSP_restoreGithubStars.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import wo1261931780.JOSP_restoreGithubStars.DTO.GithubDTO;
import wo1261931780.JOSP_restoreGithubStars.service.DataService;
import wo1261931780.JOSP_restoreGithubStars.entity.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author junw
 */
@Component
@Slf4j
public class GithubClient {
	@Value("${github.token}")
	private String githubToken;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DataService dataService;

	/**
	 * 获取指定用户的所有星标仓库列表
	 *
	 * @param username GitHub 用户名
	 * @return 仓库列表
	 */
	public List<GithubDTO> getGithubStarList(String username) {
		String apiUrl = "https://api.github.com/users/%s/starred";
		// 每页请求的数量
		int perPage = 100;

		// 初始页码
		int page = 1;

		List<GithubDTO> allGithubDTO = new ArrayList<>();

		while (true) {
			// 构建带有分页参数的 URL
			String url = String.format(apiUrl + "?per_page=%d&page=%d", username, perPage, page);

			// 设置请求头
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", "Bearer " + githubToken);
			headers.set("Accept", "application/vnd.github.v3+json");
			headers.set("X-GitHub-Api-Version", "2022-11-28");

			// 创建 HttpEntity，包含请求头
			HttpEntity<Void> entity = new HttpEntity<>(headers);

			try {
				// 使用 exchange 方法进行 GET 请求
				ResponseEntity<GithubDTO[]> response = restTemplate.exchange(
						url,
						HttpMethod.GET,
						entity,
						GithubDTO[].class
				);
				GithubDTO[] githubDTOS = response.getBody();
				// 如果没有更多仓库，则退出循环
				if (githubDTOS == null || githubDTOS.length == 0) {
					break;
				}
				// 将获取到的仓库添加到总列表中
				allGithubDTO.addAll(Arrays.asList(githubDTOS));
				log.info("Github stars list: {}", allGithubDTO.size());
				// if (allGithubDTO.size() >= 200) {
				// 	int batched = dataService.batchInsert(allGithubDTO);
				// 	log.info("Github stars list batched: {}", batched);
				// 	if (batched > 0) {
				// 		allGithubDTO.clear();
				// 	}
				// }
				page++; // 请求下一页
			} catch (HttpClientErrorException e) {
				log.error("Error fetching data from GitHub API: {}", e.getMessage());
				break; // 出现错误时退出循环
			}
		}
		log.info("Github stars list: {}", allGithubDTO.size());
		return allGithubDTO;
	}

	public ResponseEntity<Void> starRepository(Repository repository) {
		String url = String.format("https://api.github.com/user/starred/%s/%s", repository.getOwner(), repository.getRepo());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "token " + githubToken);
		headers.set("Accept", "application/vnd.github+json");

		HttpEntity<Void> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.PUT, entity, Void.class);
	}

	public ResponseEntity<Void> unstarRepository(Repository repository) {
		String url = String.format("https://api.github.com/user/starred/%s/%s", repository.getOwner(), repository.getRepo());

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "token " + githubToken);
		headers.set("Accept", "application/vnd.github+json");

		HttpEntity<Void> entity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.DELETE, entity, Void.class);
	}


}
