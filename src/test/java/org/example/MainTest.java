package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class MainTest {

    @DataProvider
    public Object[][] testData() throws IOException {
        return getTestData("src/test/resources/triangleTestData.csv");
    }

    @Test(dataProvider = "testData")
    public void processTriangleData(String sideA, String sideB, String sideC, String expected, String status) {
        List<String> actual = List.of(sideA, sideB, sideC);
        if (status.equals("s")){
            String message = String.format("triangle with sides %s is %s", actual, expected);
            assertEquals(Main.processTriangleData(actual), message);
        } else {
            assertEquals(Main.processTriangleData(actual), expected);
        }
    }

    public static Object[][] getTestData(String fileName) throws IOException {
        List<Object[]> records = new ArrayList<>();
        String record;
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
        file.readLine();
        while ((record = file.readLine()) != null) {
            String[] fields = record.split(";");
            records.add(fields);

        }
        file.close();
        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);

        }
        return results;
    }
}