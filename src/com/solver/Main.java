package com.solver;

import com.solver.models.Hand;
import com.solver.models.Match;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static final String FILE_PATH = "poker.txt";
    static int p1WinCount = 0;
    static int drawCount = 0;
    static int p2WinCount = 0;

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get(FILE_PATH))) {
            stream.forEach(
                    line -> {
                        String[] lineCards = line.split(" ");
                        Match match = new Match(new Hand(Arrays.copyOfRange(lineCards, 0, 5)),
                                                new Hand(Arrays.copyOfRange(lineCards, 5, 10)));
                        int resultOfMatch = 0;
                        try {
                            resultOfMatch = match.didPlayerOneWin();
                        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        if (resultOfMatch > 0) {
                            p1WinCount++;
                        } else if (resultOfMatch == 0) {
                            drawCount ++;
                        } else {
                            p2WinCount++;
                        }
                    }
            );

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(p1WinCount + " player one win count");
        System.out.println(drawCount + " draws");
        System.out.println(p2WinCount + " player two win count");
    }
}
