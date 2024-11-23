package wo1261931780.JOSP_restoreGithubStars.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Intellij IDEA.
 * Project:restoreGithubStars
 * Package:wo1261931780.restore_my_stars.entity
 *
 * @author liujiajun_junw
 * @Date 2024-11-13-39  星期六
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionsDTO {
    private boolean admin;
    private boolean pull;
    private boolean push;
}
