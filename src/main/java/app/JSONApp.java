package app;

import domain.BasicStudent;
import json.Json;
import json.JsonObject;
import json.JsonPair;
import json.JsonNumber;
import json.JsonString;
import json.JsonBoolean;
import json.JsonArray;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2
        final int MARK_THREE = 3;
        final int MARK_FOUR = 4;
        Json jMarks = new JsonArray(new JsonNumber(MARK_THREE),
                new JsonNumber(MARK_FOUR));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name",
                new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname",
                new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("exams", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj);

        print(jsonObj.projection("surname", "age", "year", "marks"));

        BasicStudent basicStudent = new BasicStudent("Andrii",
                "Rodionov", 2);
        print(basicStudent.toJsonObject());

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

        public static JsonObject sessionResult() {
            final int MARK_THREE = 3;
            final int MARK_FIVE = 5;
            JsonPair nameOOP = new JsonPair("course",
                    new JsonString("OOP"));
            JsonPair markOOP = new JsonPair("mark",
                    new JsonNumber(MARK_THREE));
            JsonPair passedOOP = new JsonPair("passed",
                    new JsonBoolean(true));
            JsonObject jsonOOP = new JsonObject(nameOOP, markOOP, passedOOP);
            JsonPair nameEnglish = new JsonPair("course",
                    new JsonString("English"));
            JsonPair markEnglish = new JsonPair("mark",
                    new JsonNumber(MARK_FIVE));
            JsonPair passedEnglish = new JsonPair("passed",
                    new JsonBoolean(true));
            JsonObject jsonEnglish = new JsonObject(nameEnglish, markEnglish,
                    passedEnglish);
            JsonPair nameMath = new JsonPair("course",
                    new JsonString("Math"));
            JsonPair markMath = new JsonPair("mark",
                    new JsonNumber(2));
            JsonPair passedMath = new JsonPair("passed",
                    new JsonBoolean(false));
            JsonObject jsonMath = new JsonObject(nameMath, markMath,
                    passedMath);
            Json jExamsList = new JsonArray(jsonOOP, jsonEnglish, jsonMath);
            JsonPair exams = new JsonPair("exams", jExamsList);
            Json jYear = new JsonNumber(2);
            JsonPair name = new JsonPair("name",
                    new JsonString("Andrii"));
            JsonPair surname = new JsonPair("surname",
                    new JsonString("Rodionov"));
            JsonPair year = new JsonPair("year", jYear);
            JsonObject andriiRodionov = new JsonObject(name, surname, year,
                    exams);
            print(andriiRodionov);
            return andriiRodionov;
        }
}
