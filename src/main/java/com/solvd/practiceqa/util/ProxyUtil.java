package com.solvd.practiceqa.util;

import com.qaprosoft.carina.browsermobproxy.ProxyPool;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.proxy.CaptureType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ProxyUtil implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProxyUtil.class);
    private static final String HAR_NAME = "harFile";
    private final List<String> caughtContent = new ArrayList<>();

    public ProxyUtil() {
    }

    public ProxyUtil(String filterKey) {
        setFilter(filterKey);
    }

    public void setFilter(String key) {
        BrowserMobProxy proxy = ProxyPool.getProxy();
        LOGGER.info("Retrieved proxy by port " + proxy.getPort());
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar(HAR_NAME);

        proxy.addRequestFilter((request, contents, messageInfo) -> {
            if (contents.getTextContents().contains(key.toLowerCase())) {
                String decodedString;
                decodedString = java.net.URLDecoder.decode(contents.getTextContents(), StandardCharsets.UTF_8);
                caughtContent.add(decodedString);
                LOGGER.info("Caught content: " + decodedString);
                ProductUtil.validateUrl(decodedString);
            }
            return null;
        });
    }

    public void showHarLog() {
        BrowserMobProxy proxy = ProxyPool.getProxy();

        LOGGER.info("Saving har to a file...");
        File file = new File(HAR_NAME + ".har");
        Assert.assertNotNull(proxy.getHar(), "Har is NULL!");
        try {
            proxy.getHar().writeTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            proxy.stop();
        }
    }
}
