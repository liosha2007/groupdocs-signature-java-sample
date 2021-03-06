package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.HorizontalAlignment;
import com.groupdocs.signature.domain.MeasureType;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.*;
import org.junit.Ignore;
import org.junit.Test;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class ImageOperationsTests {

    @Test
    public void testSignCellsDocumentWithImageSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        CellsSignImageOptions signOptions = new CellsSignImageOptions("signature.jpg");
        // image position
        signOptions.setRowNumber(10);
        signOptions.setColumnNumber(10);
        signOptions.setSignAllPages(true);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSignCellsDocumentWithImageSignature.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnDocumentPage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        CellsSignImageOptions signOptions = new CellsSignImageOptions(getImagesPath("signature.jpg"));
        // specify horizontal alignment
        signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        // specify separate left margin value
        signOptions.getMargin().setLeft(20);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnDocumentPage.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSignPDFDocumentsExamples() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        PdfSignImageOptions signOptions = new PdfSignImageOptions(getImagesPath("signature.jpg"));
        // image position
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSignPDFDocumentsExamples.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnPdfDocumentPage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        PdfSignImageOptions signOptions = new PdfSignImageOptions(getImagesPath("signature.jpg"));
        // specify horizontal alignment to the right
        signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        // specify separate left margin value
        signOptions.getMargin().setLeft(20);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnPdfDocumentPage.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyAdjustmentSizeMarginsAndIntentsOfImageSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        PdfSignImageOptions signOptions = new PdfSignImageOptions(getImagesPath("signature.jpg"));
        // specify Size
        signOptions.setHeight(25);
        signOptions.setWidth(25);
        signOptions.setSizeMeasureType(MeasureType.Percents);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        signOptions.setMarginMeasureType(MeasureType.Percents);
        // specify Intents
        signOptions.setTop(50);
        signOptions.setLeft(20);
        signOptions.setLocationMeasureType(MeasureType.Percents);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyAdjustmentSizeMarginsAndIntentsOfImageSignature.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSignSlidesDocumentsExamples() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignImageOptions signOptions = new SlidesSignImageOptions(getImagesPath("signature.jpg"));
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSignSlidesDocumentsExamples");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnSlidesDocumentPage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignImageOptions signOptions = new SlidesSignImageOptions(getImagesPath("signature.jpg"));
        // specify horizontal alignment
        signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        // specify separate left margin value
        signOptions.getMargin().setLeft(20);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnSlidesDocumentPage.ppt");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyAdjustmentSizeMarginsAndIntentsOfImageSlidesSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        SlidesSignImageOptions signOptions = new SlidesSignImageOptions(getImagesPath("signature.jpg"));
        // specify Size
        signOptions.setHeight(25);
        signOptions.setWidth(25);
        signOptions.setSizeMeasureType(MeasureType.Percents);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        signOptions.setMarginMeasureType(MeasureType.Percents);
        // specify Intents
        signOptions.setTop(50);
        signOptions.setLeft(20);
        signOptions.setLocationMeasureType(MeasureType.Percents);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyAdjustmentSizeMarginsAndIntentsOfImageSlidesSignature");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.ppt"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSignWordsDocumentsExamples() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignImageOptions signOptions = new WordsSignImageOptions(getImagesPath("signature.jpg"));
        signOptions.setLeft(10);
        signOptions.setTop(10);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSignWordsDocumentsExamples.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnWordsDocumentPage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignImageOptions signOptions = new WordsSignImageOptions(getImagesPath("signature.jpg"));
        // specify horizontal alignment
        signOptions.setHorizontalAlignment(HorizontalAlignment.Center);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        // specify separate left margin value
        signOptions.getMargin().setLeft(20);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyMarginsAndAlignmentOfImageSignatureAppearanceOnWordsDocumentPage.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSpecifyAdjustmentSizeMarginsAndIntentsOfImageWordsSignature() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        WordsSignImageOptions signOptions = new WordsSignImageOptions(getImagesPath("signature.jpg"));
        // specify Size
        signOptions.setHeight(25);
        signOptions.setWidth(25);
        signOptions.setSizeMeasureType(MeasureType.Percents);
        // specify Margin
        signOptions.setMargin(new Padding(10));
        signOptions.setMarginMeasureType(MeasureType.Percents);
        // specify Intents
        signOptions.setTop(50);
        signOptions.setLeft(20);
        signOptions.setLocationMeasureType(MeasureType.Percents);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("io_testSpecifyAdjustmentSizeMarginsAndIntentsOfImageWordsSignature.docx");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }
}
