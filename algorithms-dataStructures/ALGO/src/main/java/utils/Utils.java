package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    private final BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(System.in));

    public String[] getStrList(String regex) {
        return getReadLine().split(regex);
    }

    public void close() {
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            printingErr(exception);
        }
    }

    private void BufferedRunner() {

    }


    private String getReadLine() {

        return null;
    }


    private void printingErr(Exception exception) {
        exception.printStackTrace();
    }


}
