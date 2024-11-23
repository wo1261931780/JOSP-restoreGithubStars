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
public class OwnerDTO {
    private String avatarUrl;
    private String eventsUrl;
    private String followersUrl;
    private String followingUrl;
    private String gistsUrl;
    private String gravatarId;
    private String htmlUrl;
    private long id;
    private String login;
    private String nodeId;
    private String organizationsUrl;
    private String receivedEventsUrl;
    private String reposUrl;
    private boolean siteAdmin;
    private String starredUrl;
    private String subscriptionsUrl;
    private String type;
    private String url;
}
