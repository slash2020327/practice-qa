package com.solvd.practiceqa.util;

import com.solvd.practiceqa.web.service.TestDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ProductUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductUtil.class);

    public static void validateUrl(String caughtContent) {
        List<String> contents = List.of(caughtContent.split("\n"));
        contents = contents.stream().filter(text -> text.contains("url")).collect(Collectors.toList());
        for (String content : contents) {
            Assert.assertTrue(content.contains(TestDataService.getValue("title").toLowerCase()),
                    "Validation failed");
            LOGGER.info("Validation succeed");
        }
    }
}
