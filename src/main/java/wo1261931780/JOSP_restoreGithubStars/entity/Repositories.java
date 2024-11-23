package wo1261931780.JOSP_restoreGithubStars.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
*Created by Intellij IDEA.
*Project:restoreGithubStars
*Package:wo1261931780.restore_my_stars.entity
*@author liujiajun_junw
*@Date 2024-11-20-42  星期五
*@Description 
*/

/**
 * 存储GitHub仓库信息
 * @author junw
 */
@Schema(description = "存储GitHub仓库信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "github_stars.repositories")
public class Repositories implements Serializable {
	/**
	 * 自增主键，唯一标识一条记录
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@Schema(description = "自增主键，唯一标识一条记录")
	private Long id;

	/**
	 * 仓库名称
	 */
	@TableField(value = "repositorie_name")
	@Schema(description = "仓库名称")
	private String repositorieName;

	/**
	 * 仓库的HTML链接
	 */
	@TableField(value = "html_url")
	@Schema(description = "仓库的HTML链接")
	private String htmlUrl;

	/**
	 * 编程语言
	 */
	@TableField(value = "code_language")
	@Schema(description = "编程语言")
	private String codeLanguage;

	/**
	 * Fork数量，默认为0
	 */
	@TableField(value = "forks_count")
	@Schema(description = "Fork数量，默认为0")
	private Long forksCount;

	/**
	 * Watcher数量，默认为0
	 */
	@TableField(value = "watchers_count")
	@Schema(description = "Watcher数量，默认为0")
	private Long watchersCount;

	/**
	 * 最近推送时间
	 */
	@TableField(value = "pushed_at")
	@Schema(description = "最近推送时间")
	private Date pushedAt;

	/**
	 * 创建时间
	 */
	@TableField(value = "created_at")
	@Schema(description = "创建时间")
	private Date createdAt;

	/**
	 * 更新时间
	 */
	@TableField(value = "updated_at")
	@Schema(description = "更新时间")
	private Date updatedAt;

	/**
	 * 许可证名称
	 */
	@TableField(value = "license_name")
	@Schema(description = "许可证名称")
	private String licenseName;

	/**
	 * 仓库描述
	 */
	@TableField(value = "description")
	@Schema(description = "仓库描述")
	private String description;

	private static final long serialVersionUID = 1L;
}
