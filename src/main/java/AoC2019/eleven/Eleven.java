package AoC2019.eleven;

import AoC2019.nine.Output;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static AoC2019.nine.Nine.processParameterMode;

public class Eleven {

    // INPUT
    // 0 = black cell   |   1 = white cell

    // OUTPUT
    // 0 = paint black  |   1 = paint white
    // 0 = left         |   1 = right

    static long processInput(ArrayList<Long> numbers) {
        Map<Point, Panel> panelMap = new HashMap<>();
        panelMap.put(new Point(0,0), new Panel(0, Panel.Direction.UP));

        int i = 0;
        int relativeBase = 0;
        StringBuilder outputBuilder = new StringBuilder();
        Point currentPos = new Point(0,0);

        int paintedPanels = 0;
        int existing = 0;

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }

            int input = panelMap.get(currentPos).getCurrentPanel();

            Output output = processParameterMode(numbers, i, opCode, input, relativeBase);
            outputBuilder.append(output.getCode());

            if (outputBuilder.length() == 2) {
                String outputVals = outputBuilder.toString();

                if (outputVals.charAt(0) == '0') {
                    paintedPanels++;
                    panelMap.get(currentPos).paintPanelBlack();
                } else {
                    paintedPanels++;
                    panelMap.get(currentPos).paintPanelWhite();
                }

                if (outputVals.charAt(1) == '0') {
                    switch (panelMap.get(currentPos).getDirection()) {
                        case UP:
                            currentPos = new Point(currentPos.x - 1, currentPos.y);

                            System.out.println(Panel.Direction.LEFT);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.LEFT));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.LEFT);
                            }
                            break;
                        case DOWN:
                            currentPos = new Point(currentPos.x + 1, currentPos.y);

                            System.out.println(Panel.Direction.RIGHT);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.RIGHT));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.RIGHT);
                            }
                            break;
                        case LEFT:
                            currentPos = new Point(currentPos.x, currentPos.y - 1);

                            System.out.println(Panel.Direction.DOWN);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.DOWN));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.DOWN);
                            }
                            break;
                        case RIGHT:
                            currentPos = new Point(currentPos.x, currentPos.y + 1);

                            System.out.println(Panel.Direction.UP);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.UP));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.UP);
                            }
                            break;
                    }
                } else {
                    switch (panelMap.get(currentPos).getDirection()) {
                        case UP:
                            currentPos = new Point(currentPos.x + 1, currentPos.y);

                            System.out.println(Panel.Direction.RIGHT);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.RIGHT));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.RIGHT);
                            }
                            break;
                        case DOWN:
                            currentPos = new Point(currentPos.x - 1, currentPos.y);

                            System.out.println(Panel.Direction.LEFT);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.LEFT));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.LEFT);
                            }
                            break;
                        case LEFT:
                            currentPos = new Point(currentPos.x, currentPos.y + 1);

                            System.out.println(Panel.Direction.UP);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.UP));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.UP);
                            }
                            break;
                        case RIGHT:
                            currentPos = new Point(currentPos.x, currentPos.y - 1);

                            System.out.println(Panel.Direction.DOWN);

                            if (panelMap.get(currentPos) == null) {
                                panelMap.put(currentPos, new Panel(0, Panel.Direction.DOWN));
//                                paintedPanels++;
                            } else {
                                existing++;
                                panelMap.get(currentPos).setDirection(Panel.Direction.DOWN);
                            }
                            break;
                    }
                }

                outputBuilder = new StringBuilder();
            }

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }
            i += output.getIndex();
        }

        return paintedPanels;
    }
}
