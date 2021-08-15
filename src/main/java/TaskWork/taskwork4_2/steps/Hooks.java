package TaskWork.taskwork4_2.steps;

import TaskWork.taskwork4_2.manager.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before() {
        InitManager.initFramework();
    }


    @After
    public void after() {
        InitManager.quitFramework();
    }
}
