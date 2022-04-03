package visual;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import functional.BaseTest;
import org.junit.jupiter.api.BeforeAll;

public class BaseEyesTest extends BaseTest {

    private static final String API_KEY = "ZYNecsLnht2LQ44c2GE4a89L106yvK2zIjtlpxuOyUNJQ110";
    protected static Eyes eyes;

    @BeforeAll
    public static void setUp() {
        eyes = new Eyes();
        eyes.setApiKey(API_KEY);
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.setForceFullPageScreenshot(true);
    }
}
