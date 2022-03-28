package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utils.ScreenshotUtils;

public class AllureListener implements TestWatcher {
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        ScreenshotUtils.takeScreenshotAndAttachToAllureReport();
    }
}
