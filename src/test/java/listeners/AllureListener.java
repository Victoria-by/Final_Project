package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener implements TestWatcher {
    private static final Logger LOG = LoggerFactory.getLogger(AllureListener.class);

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        takeScreenshotAndAttachToAllureReport();
        LOG.info("Test Aborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        takeScreenshotAndAttachToAllureReport();
        LOG.info("Test Failed");
    }
}
