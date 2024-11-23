package wo1261931780.JOSP_restoreGithubStars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wo1261931780.JOSP_restoreGithubStars.entity.Repositories;
import wo1261931780.JOSP_restoreGithubStars.entity.Repository;
import wo1261931780.JOSP_restoreGithubStars.service.GitHubService;

import java.util.List;

/**
 * @author junw
 */
@RestController
@RequestMapping("/api/repositories")
public class GitHubController {
	@Autowired
	private GitHubService gitHubService;

	@GetMapping("/stars/{username}")
	public List<Repositories> getStarredRepositories(@PathVariable String username) {
		return gitHubService.getStarredRepositories("wo1261931780");
		// return gitHubService.getStarredRepositories(username);
	}

	// Endpoint to star a repository
	@PutMapping("/star")
	public ResponseEntity<Void> starRepository(@RequestBody Repository repository) {
		return gitHubService.starRepository(repository);
	}

	// Endpoint to unstar a repository
	@DeleteMapping("/unstar")
	public ResponseEntity<Void> unstarRepository(@RequestBody Repository repository) {
		return gitHubService.unstarRepository(repository);
	}
}
