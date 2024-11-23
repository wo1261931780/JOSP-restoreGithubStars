package wo1261931780.JOSP_restoreGithubStars.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wo1261931780.JOSP_restoreGithubStars.entity.Repositories;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * Project:restoreGithubStars
 * Package:wo1261931780.restore_my_stars.mapper
 *
 * @author liujiajun_junw
 * @Date 2024-11-20-42  星期五
 * @Description
 */

@Mapper
public interface RepositoriesMapper extends BaseMapper<Repositories> {
	int updateBatch(@Param("list") List<Repositories> list);

	int updateBatchUseMultiQuery(@Param("list") List<Repositories> list);

	int batchInsert(@Param("list") List<Repositories> list);

	int batchInsertSelectiveUseDefaultForNull(@Param("list") List<Repositories> list);

	int deleteByPrimaryKeyIn(List<Long> list);

	boolean insertOrUpdate(Repositories record);

	int insertOrUpdateSelective(Repositories record);
}
