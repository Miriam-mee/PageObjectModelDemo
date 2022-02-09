import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
   @CucumberOptions( features = "src/test/java/Features/LoginDemo.feature",
            glue= {"Steps"},
           monochrome = true,
            plugin = { "pretty","junit:target/JunitReports/report.xml", "json:target/JSONReports/report.json",
            "html:target/HtmlReports"}
            )
    public class TestRunnerForLoginDemo {
}
