package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jsonPairsList = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        if (jsonPairs != null) {
            jsonPairsList.addAll(Arrays.asList(jsonPairs));
        }
    }

    @Override
    public String toJson() {
        if (jsonPairsList.size() > 0) {
            Set<String> checkKeys = new HashSet<>();
            StringBuilder finalString = new StringBuilder();
            for (JsonPair jsonPair : jsonPairsList) {
                if (!checkKeys.contains(jsonPair.key+":")) {
                    checkKeys.add(jsonPair.key+":");
                    finalString.append(jsonPair.key).append(": ").
                            append(jsonPair.value.toJson()).append(", ");
                } else {
                    final int INDEXES_TO_GOAL = 5;
                    int intIndex = finalString.indexOf(jsonPair.key + ":")
                            + INDEXES_TO_GOAL;
                    StringBuilder buf = new StringBuilder(finalString);
                    buf.replace(intIndex, intIndex+2,
                            jsonPair.value.toJson());
                    finalString = new StringBuilder(buf);
                }
            }
            String result = finalString.substring(0, finalString.length() - 2);
            return "{" + result + "}";
        } else {
            return "{}";
        }
    }

    public void add(JsonPair jsonPair) {
        for (JsonPair jsPair : jsonPairsList) {
            if (Objects.equals(jsPair.key, jsonPair.key)) {
                jsonPairsList.remove(jsPair);
                jsonPairsList.add(jsonPair);
                break;
            }
        }
        jsonPairsList.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair jsonPair : jsonPairsList) {
            if (Objects.equals(jsonPair.key, name)) {
                return jsonPair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject jsonProjection = new JsonObject();
        for (JsonPair jsonPair : jsonPairsList) {
            for (String name : names) {
                if (Objects.equals(jsonPair.key, name)) {
                    jsonProjection.add(jsonPair);
                }
            }
        }
        return jsonProjection;
    }

    // There was no template, even no test for contains,
    // but it is stated in task, thus here you are
    public boolean contains(String name) {
        for (JsonPair jsonPair : jsonPairsList) {
            if (Objects.equals(jsonPair.key, name)) {
                return true;
            }
        }
        return false;
    }
}
