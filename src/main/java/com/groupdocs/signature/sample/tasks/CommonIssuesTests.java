package com.groupdocs.signature.sample.tasks;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.PdfSignTextOptions;
import com.groupdocs.signature.options.SaveOptions;
import com.groupdocs.signature.options.WordsSignImageOptions;
import com.groupdocs.signature.sample.TestRunner;
import org.junit.Test;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov
 */
public class CommonIssuesTests {

    @Test
    public void testSIGNATUREJAVA102() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);

        // setup image signature options
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        signOptions.setLeft(100);
        signOptions.setTop(100);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("testSIGNATUREJAVA102.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("digital signatures.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSIGNATUREJAVA104() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignImageOptions signOptions = new WordsSignImageOptions(getImagesPath("sign.png"));
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("testSIGNATUREJAVA104.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("getting started.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }
}
