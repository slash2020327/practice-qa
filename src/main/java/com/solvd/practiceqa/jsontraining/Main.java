package com.solvd.practiceqa.jsontraining;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.solvd.practiceqa.jsontraining.store.Buying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = new File("src/main/resources/store.json");
        File outputJson = new File("src/main/resources/output.json");
        Filter priceFilter = filter(where("price").gt(10));

        try {
            List<String> titles = JsonPath.read(jsonFile, "$..book[*].title");
            titles.forEach(LOGGER::info);

            String firstAuthor = JsonPath.read(jsonFile, "$.store.book[0].author");
            LOGGER.info(firstAuthor);

            LOGGER.info("Filtering books with price > 10");
            List<Object> books =
                    JsonPath.parse(jsonFile).read("$.store.book[?]", priceFilter);
            books.forEach(book -> LOGGER.info(book.toString()));

            LOGGER.info("Double data parsing");
            Double firstPrice = JsonPath.<Double>read(jsonFile, "$.store.book[0].price");
            LOGGER.info(firstPrice.toString());

            Buying jsonStore = mapper.readValue(jsonFile, Buying.class);
            LOGGER.info("Json to store parsed");

            mapper.writeValue(outputJson, jsonStore);
            LOGGER.info("Store to json parsed");

        } catch (IOException e) {
            LOGGER.warn("Unable to parse data");
        }

    }
}
