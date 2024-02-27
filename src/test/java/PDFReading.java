import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReading {

        public static void main(String args[]) throws IOException {
            //Loading an existing document
            File file = new File("src/test/resources/Html-Css(English)PDF.pdf");
            PDDocument document = new PDDocument((RandomAccessStreamCache.StreamCacheCreateFunction) file);
            //Instantiate PDFTextStripper class
            PDFTextStripper pdfStripper = new PDFTextStripper();
            //Retrieving text from PDF document
            String text = pdfStripper.getText(document);
            System.out.println(text);
            //Closing the document
            document.close();
        }
    }


