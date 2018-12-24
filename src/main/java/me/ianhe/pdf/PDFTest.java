package me.ianhe.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author iHelin
 * @date 2018-12-04 09:24
 */
public class PDFTest {

    public static void main(String[] args) {
//        createBlank("demo/t.pdf");
        readPDF("/Users/iHelin/Downloads/1.pdf");
    }

    public static void createBlank(String outputFile) {
        //首先创建pdf文档类
        PDDocument document = null;
        try {
            document = new PDDocument();
            //实例化pdf页对象
            PDPage blankPage = new PDPage();
            PDPage blankPage1 = new PDPage();
            PDPage blankPage2 = new PDPage();
            //插入文档类
            document.addPage(blankPage);
            document.addPage(blankPage1);
            document.addPage(blankPage2);
            //记得一定要写保存路径,如"H:\\text.pdf"
            document.save(outputFile);
            System.out.println("over");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取pdf中文字信息(全部)
     */
    public static void readPDF(String inputFile) {
        //创建文档对象
        PDDocument doc;
        String content;
        try {
            //加载一个pdf对象
            doc = PDDocument.load(new File(inputFile));
            //获取一个PDFTextStripper文本剥离对象
            PDFTextStripper textStripper = new PDFTextStripper();
            content = textStripper.getText(doc);
            System.out.println("内容:" + content);
            System.out.println("全部页数" + doc.getNumberOfPages());
            //关闭文档
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
