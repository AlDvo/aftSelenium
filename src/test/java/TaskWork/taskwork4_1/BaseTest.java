package TaskWork.taskwork4_1;

import TaskWork.taskwork4_1.manager.DriverManager;
import TaskWork.taskwork4_1.util.AllureReporter;
import TaskWork.taskwork4_1.util.TestPropertis;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureReporter.class)
public class BaseTest {

    private DriverManager driverManager = DriverManager.getDriverManager();
    private TestPropertis testPropertis = TestPropertis.getTestPropertis();

    @BeforeEach
    public void Before() {
        driverManager.getDriver().get(testPropertis.getProperty("base.url"));
    }

    @AfterEach
    public void After(){driverManager.quitDriver();}
}
