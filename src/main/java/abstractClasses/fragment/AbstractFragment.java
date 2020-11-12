package abstractClasses.fragment;

import org.openqa.selenium.WebDriver;

public class AbstractFragment {

    protected WebDriver driver;

    public AbstractFragment(WebDriver driver) {
        this.driver = driver;
    }
}
