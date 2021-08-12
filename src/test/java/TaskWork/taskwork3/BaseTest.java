package TaskWork.taskwork3;

import TaskWork.taskwork3.manager.DriverManager;
import TaskWork.taskwork3.util.TestPropertis;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
