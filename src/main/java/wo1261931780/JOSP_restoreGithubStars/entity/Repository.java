package wo1261931780.JOSP_restoreGithubStars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author junw
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
	// 仓库拥有者
	private String owner;
	// 仓库名称
	private String repo;
}
