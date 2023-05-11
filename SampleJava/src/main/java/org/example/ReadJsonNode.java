package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.example.model.Item;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReadJsonNode {
    public static void main(String[] args) throws IOException {
        String jsonString = FileUtils.readFileToString(new File("D:\\CT-Sample-Setup\\Sample-Exercise-Check\\Inventory.json"), StandardCharsets.UTF_8);
        System.out.printf(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue(jsonString, JsonNode.class);
        JsonNode at = jsonNode.at("/InventoryStockFeed/articleStockDetails/article_stockinfo/item");

        List<Item> items = readFromInputObj(at, Item.class, objectMapper);


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