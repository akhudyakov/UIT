package Steps;

import Pages.BasePage;

/**
 * Created by Andrey on 31.05.2017.
 */
public class CommonStep extends BasePage {

    public void appStart() {
        driver.get(BASE_URL);
    }

    public void appStop() {
        driver.quit();
    }
}
