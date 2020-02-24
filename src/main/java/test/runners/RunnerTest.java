package test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/test/resources.feature/feature"},
        glue = {"src/main/test/glue"}
)

public class RunnerTest {
}
