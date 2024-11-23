
package wo1261931780.JOSP_restoreGithubStars.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApifoxModel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubDTO {
    private boolean allowAutoMerge;
    private boolean allowMergeCommit;
    private boolean allowRebaseMerge;
    private boolean allowSquashMerge;
    private boolean archived;
    private String archiveUrl;
    private String assigneesUrl;
    private String blobsUrl;
    private String branchesUrl;
    private String cloneUrl;
    private String collaboratorsUrl;
    private String commentsUrl;
    private String commitsUrl;
    private String compareUrl;
    private String contentsUrl;
    private String contributorsUrl;
    private String createdAt;
    private String defaultBranch;
    private boolean deleteBranchOnMerge;
    private String deploymentsUrl;
    private String description;
    private boolean disabled;
    private String downloadsUrl;
    private String eventsUrl;
    private boolean fork;
    private long forks;
    private long forksCount;
    private String forksUrl;
    private String fullName;
    private String gitCommitsUrl;
    private String gitRefsUrl;
    private String gitTagsUrl;
    private String gitUrl;
    private boolean hasDownloads;
    private boolean hasIssues;
    private boolean hasPages;
    private boolean hasProjects;
    private boolean hasWiki;
    private String homepage;
    private String hooksUrl;
    private String htmlUrl;
    private long id;
    private String issueCommentUrl;
    private String issueEventsUrl;
    private String issuesUrl;
    private boolean isTemplate;
    private String keysUrl;
    private String labelsUrl;
    private String language;
    private String languagesUrl;
    private LicenseDTO license;
    private String mergesUrl;
    private String milestonesUrl;
    private String mirrorUrl;
    private String name;
    private long networkCount;
    private String nodeId;
    private String notificationsUrl;
    private long openIssues;
    private long openIssuesCount;
    private OwnerDTO owner;
    private PermissionsDTO permissions;
    // private boolean apifoxModelPrivate;
    private String pullsUrl;
    private String pushedAt;
    private String releasesUrl;
    private long size;
    private String sshUrl;
    private long stargazersCount;
    private String stargazersUrl;
    private String statusesUrl;
    private long subscribersCount;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String svnUrl;
    private String tagsUrl;
    private String teamsUrl;
    private String tempCloneToken;
    private Object templateRepository;
    private String[] topics;
    private String treesUrl;
    private String updatedAt;
    private String url;
    private String visibility;
    private long watchers;
    private long watchersCount;

}
