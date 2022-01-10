package domain;

import json.Jsonable;
import json.JsonObject;
import json.JsonPair;
import json.JsonNumber;
import json.JsonString;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    private String name;
    private String surname;
    private Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair jName = new JsonPair("name", new JsonString(name));
        JsonPair jSurname = new JsonPair("surname", new JsonString(surname));
        JsonPair jYear = new JsonPair("year", new JsonNumber(year));
        return new JsonObject(jName, jSurname, jYear);
    }
}
