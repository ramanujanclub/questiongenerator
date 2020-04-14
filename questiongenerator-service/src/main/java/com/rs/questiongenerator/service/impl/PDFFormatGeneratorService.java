package com.rs.questiongenerator.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.rs.questiongenerator.domain.Question;
import com.rs.questiongenerator.domain.QuestionOption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
@AllArgsConstructor
public class PDFFormatGeneratorService {



    /**
     *
     * @param questions
     * @return
     */
    public void generatedQuestionPaper (List<Question> questions) {
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Data\\temp_pdf\\QuestionPaper.pdf"));
            document.open();
            int count = 1;
            for (Question question : questions) {
                document.add(createPDFQuestionParagraph(question, count++));
                document.add(createPDFOptionsParagraph(question));
                document.add(createPDFAnswerParagraph());
                // Empty paragraph for one blank line
                document.add(new Paragraph("    "));
            }
            document.close();
            writer.close();
            System.out.println("PDF generated");
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private Paragraph createPDFQuestionParagraph(Question question, int count) {
        String startTxt = "Q"+count+". ";
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Paragraph paragraph = new Paragraph(startTxt+question.getQuestionDescription(), blueFont);
        return paragraph;
    }

    private Paragraph createPDFOptionsParagraph(Question question) {
        StringBuffer questionOptionText = new StringBuffer();
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        for (QuestionOption questionOption : question.getQuestionOptions().getMultipleQuestionOption()) {
            String optionNumberTxt = "("+questionOption.getOptionKey()+")";
            questionOptionText.append(optionNumberTxt).append(" "+questionOption.getOptionValue()).append("    ");
        }
        Paragraph paragraph = new Paragraph(questionOptionText.toString(), blueFont);
        return paragraph;
    }

    private Paragraph createPDFAnswerParagraph() {
        Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        Paragraph paragraph = new Paragraph("Answer:______________ ", blueFont);
        return paragraph;
    }
}
