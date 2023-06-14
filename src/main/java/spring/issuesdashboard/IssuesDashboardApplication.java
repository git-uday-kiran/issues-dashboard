package spring.issuesdashboard;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.issuesdashboard.events.GithubProject;
import spring.issuesdashboard.events.GithubProjectRepository;

@SpringBootApplication
public class IssuesDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssuesDashboardApplication.class, args);
    }


    @Bean
    CommandLineRunner loadProjects(GithubProjectRepository repository) {
        return args -> {
            repository.save(new GithubProject(1l, "spring-projects", "spring-boot"));
            repository.save(new GithubProject(2l, "spring-io", "initializer"));
            repository.save(new GithubProject(3l, "spring-io", "sagan"));
        };
    }
}
