package spring.issuesdashboard.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.issuesdashboard.github.GithubClient;
import spring.issuesdashboard.github.RepositoryEvent;

@Controller
public class EventController {

    private final GithubProjectRepository githubProjectRepository;
    private final GithubClient githubClient;

    public EventController(GithubProjectRepository githubProjectRepository, GithubClient githubClient) {
        this.githubProjectRepository = githubProjectRepository;
        this.githubClient = githubClient;
    }

    @GetMapping("/events/{repoName}")
    @ResponseBody
    public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
        GithubProject project = githubProjectRepository.findByRepoName(repoName);
        return  this.githubClient.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
    }
}
