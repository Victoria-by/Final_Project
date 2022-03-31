package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener implements TestWatcher {

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshotAndAttachToAllureReport();
    }
}
