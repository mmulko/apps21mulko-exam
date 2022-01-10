package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected String name;
    protected String surname;
    protected Integer year;
    protected List<Tuple<String, Integer>> exams = new ArrayList<>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams.addAll(Arrays.asList(exams));
    }

    @Override
    public JsonObject toJsonObject() {
        List<JsonObject> examsList = new ArrayList<>();
        JsonPair jName = new JsonPair("name", new JsonString(name));
        JsonPair jSurname = new JsonPair("surname", new JsonString(surname));
        JsonPair jYear = new JsonPair("year", new JsonNumber(year));
        for (Tuple<String, Integer> exam : exams) {
            JsonPair examName = new JsonPair("course", new JsonString(exam.key));
            JsonPair examMark = new JsonPair("mark", new JsonNumber(exam.value));
            JsonPair examStatus = new JsonPair("passed", new JsonBoolean(exam.value > 2));
            JsonObject jsonExam = new JsonObject(examName, examMark, examStatus);
            examsList.add(jsonExam);
        }
        Json jsonExams = new JsonArray(examsList.toArray(new JsonObject[0]));
        JsonPair jExam = new JsonPair("exams", jsonExams);
        return new JsonObject(jName, jSurname, jYear, jExam);
    }
}