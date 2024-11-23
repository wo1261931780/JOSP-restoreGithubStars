package wo1261931780.JOSP_restoreGithubStars.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import wo1261931780.JOSP_restoreGithubStars.entity.Repositories;
import wo1261931780.JOSP_restoreGithubStars.mapper.RepositoriesMapper;

import java.util.List;

/**
 * Created by Intellij IDEA.
 * Project:restoreGithubStars
 * Package:wo1261931780.restore_my_stars.service
 *
 * @author liujiajun_junw
 * @Date 2024-11-23-57  星期四
 * @Description
 */
@Service
public class DataService extends ServiceImpl<RepositoriesMapper, Repositories> {
	public int updateBatch(List<Repositories> list) {
		return baseMapper.updateBatch(list);
	}

	public int updateBatchUseMultiQuery(List<Repositories> list) {
		return baseMapper.updateBatchUseMultiQuery(list);
	}

	// public int updateBatchSelective(List<Repositories> list) {
	// 	return baseMapper.updateBatchSelective(list);
	// }

	public int batchInsert(List<Repositories> list) {
		return baseMapper.batchInsert(list);
	}

	public int batchInsertSelectiveUseDefaultForNull(List<Repositories> list) {
		return baseMapper.batchInsertSelectiveUseDefaultForNull(list);
	}

	public int deleteByPrimaryKeyIn(List<Long> list) {
		return baseMapper.deleteByPrimaryKeyIn(list);
	}

	public boolean insertOrUpdate(Repositories record) {
		return baseMapper.insertOrUpdate(record);
	}

	public int insertOrUpdateSelective(Repositories record) {
		return baseMapper.insertOrUpdateSelective(record);
	}
}
