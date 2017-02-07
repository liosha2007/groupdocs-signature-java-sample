package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.*;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;

import static com.groupdocs.signature.sample.TestRunner.OUTPUT_PATH;
import static com.groupdocs.signature.sample.TestRunner.STORAGE_PATH;
import static com.groupdocs.signature.sample.TestRunner.getStoragePath;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class TextOperationsTests {

    @Ignore
    @Test
    public void testSignCellsDocumentWithTextSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
        // text position
        signOptions.setRowNumber(2);
        signOptions.setColumnNumber(2);
        //// text rectangle size
        signOptions.setHeight(100);
        signOptions.setWidth(100);
        //// if you need to sign all sheets set it to true
        signOptions.setSignAllPages(false);
        signOptions.setSheetNumber(2); // sign second sheet
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignCellsDocumentWithTextSignature.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAddFontBackgroundAndColorOptionsToTextSignatureAppearance() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
        // setup background settings
        signOptions.setBackgroundColor(Color.GRAY);
        signOptions.setBackgroundTransparency(0.5);
        //setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        signOptions.setBorderDashStyle(DashStyle.DashLongDashDot);
        signOptions.setBorderVisiblity(true);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(25);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testAddFontBackgroundAndColorOptionsToTextSignatureAppearance.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSavingSignedCellsDocumentsWithDifferentOutputFileType() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        SignOptions signOptions = new CellsSignTextOptions("John Smith");
        final CellsSaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSavingSignedCellsDocumentsWithDifferentOutputFileType.ods");
        // save to Open Office format
        saveOptions.setFileFormat(CellsSaveFileFormat.ODS);
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignCellsDocumentWithTextSignatureAsImage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        CellsSignTextOptions signOptions = new CellsSignTextOptions("John Smith");
        // setup background settings
        signOptions.setBackgroundColor(Color.GRAY);
        signOptions.setBackgroundTransparency(0.5);
        //setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        signOptions.setBorderDashStyle(DashStyle.DashLongDashDot);
        signOptions.setBorderVisiblity(true);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        //type of implementation
        signOptions.setSignatureImplementation(CellsTextSignatureImplementation.TextAsImage);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignCellsDocumentWithTextSignatureAsImage.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignPdfDocumentWithTextSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        signOptions.setLeft(100);
        signOptions.setTop(100);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignPdfDocumentWithTextSignature.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAddFontAndColorOptionsToTextSignatureAppearance2() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        // setup colors settings
        signOptions.setBackgroundColor(Color.GRAY);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("testAddFontAndColorOptionsToTextSignatureAppearance2.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSavingSignedPdfDocumentsWithDifferentOutputFileType() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        final PdfSaveOptions saveOptions = new PdfSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSavingSignedPdfDocumentsWithDifferentOutputFileType.epub");
        //
        saveOptions.setFileFormat(PdfSaveFileFormat.Epub);
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAddOpacityOptionsToTextSignatureAppearance() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        // setup colors settings
        signOptions.setBackgroundColor(Color.BLUE);
        // setup text color
        signOptions.setForeColor(Color.YELLOW);
        // setup opacity options
        //signOptions.setOpacity(0.35);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(36);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testAddOpacityOptionsToTextSignatureAppearance.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignPdfDocumentWithTextSignatureAsImage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        // setup colors settings
        signOptions.setBackgroundColor(Color.GRAY);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        //type of implementation
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Image);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignPdfDocumentWithTextSignatureAsImage.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignPdfDocumentWithTextSignatureAsAnnotation() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions("John Smith");
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setHeight(200);
        signOptions.setWidth(200);
        // setup colors settings
        signOptions.setBackgroundColor(Color.GRAY);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        //type of implementation
        signOptions.setSignatureImplementation(PdfTextSignatureImplementation.Annotation);
        // specify extended appearance options
        PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
        appearance.setBorderColor(Color.BLUE);
        appearance.setBorderEffect(PdfTextAnnotationBorderEffect.Cloudy);
        appearance.setBorderEffectIntensity(2);
        appearance.setBorderStyle(PdfTextAnnotationBorderStyle.Dashed);
        appearance.setHCornerRadius(10);
        appearance.setBorderWidth(5);
        appearance.setContents(signOptions.getText() + " content description");
        appearance.setSubject("Appearance Subject");
        appearance.setTitle("MrJohn Signature");
        signOptions.setAppearance(appearance);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignPdfDocumentWithTextSignatureAsAnnotation.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignSlidesDocumentWithTextSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignSlidesDocumentWithTextSignature.ppt");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAddFontAndColorOptionsToSlidesTextSignatureAppearance() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        // background color
        signOptions.setBackgroundColor(Color.GRAY);
        // border options
        signOptions.setBorderColor(Color.GREEN);
        signOptions.setBorderWeight(1);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testAddFontAndColorOptionsToTextSignatureAppearance.ppt");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSavingSignedSlidesDocumentsWithDifferentOutputFileType() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SignOptions signOptions = new SlidesSignTextOptions("John Smith");
        // specify save options
        final SlidesSaveOptions saveOptions = new SlidesSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSavingSignedSlidesDocumentsWithDifferentOutputFileType.odp");
        //saveOptions.setFileFormat(Signature.Domain.SlidesSaveFileFormat.Odp);
        saveOptions.setFileFormat(SlidesSaveFileFormat.Odp);
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignSlidesDocumentWithTextSignatureAsImage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignTextOptions signOptions = new SlidesSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        // background color
        signOptions.setBackgroundColor(Color.GRAY);
        // border options
        signOptions.setBorderColor(Color.GREEN);
        signOptions.setBorderWeight(1);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        //type of implementation
        signOptions.setSignatureImplementation(SlidesTextSignatureImplementation.TextAsImage);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignSlidesDocumentWithTextSignatureAsImage.ppt");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignWordsDocumentWithTextSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignWordsDocumentWithTextSignature.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAddFontAndColorOptionsToTextSignatureAppearance() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        // setup background settings
        signOptions.setBackgroundColor(Color.GRAY);
        signOptions.setBackgroundTransparency(0.5);
        // setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderDashStyle(ExtendedDashStyle.LongDash);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testAddFontAndColorOptionsToTextSignatureAppearance.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSavingSignedWordsDocumentsWithDifferentOutputFileType() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SignOptions signOptions = new WordsSignTextOptions("John Smith");
        // specify save options
        final WordsSaveOptions saveOptions = new WordsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSavingSignedWordsDocumentsWithDifferentOutputFileType.odt");
        saveOptions.setFileFormat(WordsSaveFileFormat.Odt);
        //saveOptions.setFileFormat(Signature.Domain.WordsSaveFileFormat.Odt);
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSignWordsDocumentWithTextSignatureAsImage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        // setup background settings
        signOptions.setBackgroundColor(Color.GRAY);
        signOptions.setBackgroundTransparency(0.5);
        // setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderDashStyle(ExtendedDashStyle.LongDash);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        // setup text color
        signOptions.setForeColor(Color.RED);
        // setup Font options
        signOptions.getFont().setBold(true);
        signOptions.getFont().setItalic(true);
        signOptions.getFont().setUnderline(true);
        signOptions.getFont().setFontFamily("Arial");
        signOptions.getFont().setFontSize(15);
        //type of implementation
        signOptions.setSignatureImplementation(WordsTextSignatureImplementation.TextAsImage);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testSignWordsDocumentWithTextSignatureAsImage.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testTextVerificationOfPDFDocument() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        String text = "John Smith, esquire";
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        PdfSignTextOptions signOptions = new PdfSignTextOptions(text);
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("to_testTextVerificationOfPDFDocument.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test2pages.pdf"), signOptions, saveOptions);
        // setup digital verification options
        PDFVerifyTextOptions verifyOptions = new PDFVerifyTextOptions(text);
        verifyOptions.setDocumentPageNumber(1);

        //verify document
        VerificationResult result = handler.verify(signedPath, verifyOptions);
        System.out.println("Verification result: " + result.isValid());
    }
}
