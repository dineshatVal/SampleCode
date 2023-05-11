package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = FileUtils.readFileToString(new File("D:\\CT-Sample-Setup\\Sample-Exercise-Check\\Inventory.json"), StandardCharsets.UTF_8);
        System.out.printf(str);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue(str, JsonNode.class);
        JsonNode at = jsonNode.at("/InventoryStockFeed/articleStockDetails/article_stockinfo/item");

        List<Item> items = readFromInputObj(at, Item.class, objectMapper);
        System.out.println("Testing");

    }
    private static List<Item> readFromInputObj(JsonNode jsonNode, Class deserializeClass, ObjectMapper objectMapper) {
        try {
            return objectMapper.readValue(objectMapper.treeAsTokens(jsonNode), objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, deserializeClass));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}