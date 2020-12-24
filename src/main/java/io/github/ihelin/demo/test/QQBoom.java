package io.github.ihelin.demo.test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

public class QQBoom {

    public static void main(String[] args) throws AWTException {
        String sentence = "从前有座山,山里有座庙,庙里有个老和尚和小和尚,和尚对小和尚说：";
        Robot robot = new Robot();
        robot.delay(3000);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        String[] authors = sentence.split("[,]");
        for (int j = 0; j < 5; j++) {
            for (String text : authors) {
                Transferable tText = new StringSelection(text);
                clip.setContents(tText, null);
                robot.keyPress(KeyEvent.VK_META);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_META);
                robot.delay(500);
                robot.keyPress(KeyEvent.VK_ENTER);
            }
        }
    }
}
