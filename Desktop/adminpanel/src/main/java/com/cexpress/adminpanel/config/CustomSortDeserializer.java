package com.cexpress.adminpanel.config;

import java.io.IOException;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class CustomSortDeserializer extends JsonDeserializer<Sort> {

@Override
public Sort deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException, JsonProcessingException {
    ArrayNode node = jp.getCodec().readTree(jp);
    Order[] orders = new Order[node.size()];
    int i = 0;
    for(JsonNode obj : node){
        orders[i] =  new Order(Direction.valueOf(obj.get("direction").asText()), obj.get("property").asText());
        i++;
    }
    Sort sort = new Sort(orders);
    return sort;
}

}