package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/java/features",
  glue = "steps",
  plugin = {
    "pretty",
    "html:target/HtmlReports/report.html",
    "json:target/JsonReports/report.json",
    "junit:target/JUnitReports/report.xml"
  },
  monochrome = true
)
public class TestRunner {
}
