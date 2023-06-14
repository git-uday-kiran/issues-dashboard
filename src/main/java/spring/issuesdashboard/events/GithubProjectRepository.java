package spring.issuesdashboard.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubProjectRepository extends JpaRepository<GithubProject, Long> {
    GithubProject findByRepoName(String repoName);
}
