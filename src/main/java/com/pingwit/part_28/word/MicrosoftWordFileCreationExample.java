package com.pingwit.part_28.word;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class MicrosoftWordFileCreationExample {
    public static void main(String[] args) throws Exception {
        XWPFDocument document = new XWPFDocument();

        String font = "Courier";

        createImage(document, Path.of("src/main/java/com/pingwit/part_28/word/1200x1200bf-60.png"));
        createTitle(document, font, "Chuxx Morris");
        createSubTitle(document, font, "Solomon Grundy");

        Files.readAllLines(Path.of("src/main/java/com/pingwit/part_28/word/salomon_grundy.txt"))
                .forEach(line -> createRegularText(document, font, line));

        write(document);
    }

    private static void createTitle(XWPFDocument document, String font, String text) {
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText(text);
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily(font);
        titleRun.setFontSize(20);
    }

    private static void createSubTitle(XWPFDocument document, String font, String text) {
        XWPFParagraph subtitle = document.createParagraph();
        subtitle.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun subtitleRun = subtitle.createRun();
        subtitleRun.setText(text);
        subtitleRun.setColor("00CC44");
        subtitleRun.setBold(true);
        subtitleRun.setFontFamily(font);
        subtitleRun.setFontSize(16);
        subtitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
    }

    private static void createRegularText(XWPFDocument document, String font, String text) {
        XWPFParagraph subtitle = document.createParagraph();
        subtitle.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun subtitleRun = subtitle.createRun();
        subtitleRun.setText(text);
        subtitleRun.setColor("000000");
        subtitleRun.setBold(true);
        subtitleRun.setFontFamily(font);
        subtitleRun.setFontSize(12);
    }

    private static void createImage(XWPFDocument document, Path imagePath) throws Exception {
        XWPFParagraph imageParagraph = document.createParagraph();
        imageParagraph.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun imageRun = imageParagraph.createRun();
        imageRun.addPicture(
                Files.newInputStream(imagePath),
                XWPFDocument.PICTURE_TYPE_PNG, imagePath.toFile().getName(),
                Units.toEMU(200), Units.toEMU(200)
        );
    }

    private static void write(XWPFDocument document) {
        String currentDirectory = "src/main/java/com/pingwit/part_28/word";
        String outputFileName = currentDirectory + "/MyFavouriteSong.docx";

        try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
            document.write(fos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
