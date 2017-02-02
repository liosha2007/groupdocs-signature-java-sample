package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.*;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.io.FileNotFoundException;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class OtherOperationsTests {
    final String DevStorageEmulatorUrl = "http://127.0.0.1:10000/devstoreaccount1/";
    final String DevStorageEmulatorAccountName = "devstoreaccount1";
    final String DevStorageEmulatorAccountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";

    @Ignore
    @Test
    public void testHowToUseCustomInputDataHandler() throws FileNotFoundException {
////        String rootPath = Path.GetFullPath(@"..\..\");
//        SignatureConfig signConfig = new SignatureConfig();
//        signConfig.setOutputPath(OUTPUT_PATH);
//        signConfig.setImagesPath(IMAGES_PATH);
//
//        String fileName;
//
//        SaveOptions saveOptions = new SaveOptions(OutputType.String);
//        IInputDataHandler customInputStorageProvider = new SampleAzureInputDataHandler(DevStorageEmulatorUrl,
//                DevStorageEmulatorAccountName, DevStorageEmulatorAccountKey, "testbucket");
//        SignatureHandler handlerWithCustomStorage = new SignatureHandler(signConfig, customInputStorageProvider);
//        LicenseSetter.SetSignatureLicense(handlerWithCustomStorage);
//
//        InputStream imageStream = new FileInputStream(getImagesPath("Autograph_of_Benjamin_Franklin.png"));
//            PdfSignImageOptions options = new PdfSignImageOptions(imageStream);
//            options.setDocumentPageNumber(1);
//            options.setTop(500);
//            options.setWidth(200);
//            options.setHeight(100);
//            fileName = handlerWithCustomStorage.<String>sign(inputFileName, options, saveOptions);
//        System.out.println("Document signed successfully. The output filename: {0}", fileName);
    }

    @Ignore
    @Test
    public void testHowToUseCustomOutputDataHandler() {
////        String rootPath = Path.GetFullPath(@"..\..\");
//        SignatureConfig signConfig = new SignatureConfig();
//        signConfig.setStoragePath(STORAGE_PATH);
//        signConfig.setImagesPath(IMAGES_PATH);
//
//        String fileName;
//        SaveOptions saveOptions = new SaveOptions(OutputType.String);
//        IOutputDataHandler customOutputStorageProvider = new SampleAzureOutputDataHandler(
//                DevStorageEmulatorUrl, DevStorageEmulatorAccountName, DevStorageEmulatorAccountKey, "tempbucket");
//        SignatureHandler handlerWithCustomStorage = new SignatureHandler(signConfig, customOutputStorageProvider);
//        LicenseSetter.SetSignatureLicense(handlerWithCustomStorage);
//        InputStream imageStream = FileInputStream(getImagesPath("Autograph_of_Benjamin_Franklin.png"));
//            PdfSignImageOptions options = new PdfSignImageOptions(imageStream);
//            options.setDocumentPageNumber(1);
//            options.setTop(500);
//            options.setWidth(200);
//            options.setHeight(100);
//            fileName = handlerWithCustomStorage.<String>sign(inputFileName, options, saveOptions);
//        System.out.println("Document signed successfully. The output filename: {0}", fileName);
    }

    @Ignore
    @Test
    public void testSetupFontAndTextColorOptions() {
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
        // sign document
        String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSetupBackgroundAndBorderSettings() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
        // setup background settings
        signOptions.setBackgroundColor(Color.GRAY);
        signOptions.setBackgroundTransparency(0.5);
        // setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderDashStyle(ExtendedDashStyle.DashDot);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        // sign document
        String signedPath = handler.<String>sign("test.docx", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSetupImageSignatureRectangleAndMargins() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignTextOptions signOptions = new WordsSignTextOptions("John Smith");
        // setup Signature area Size
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setWidth(200);
        signOptions.setHeight(200);
        // setup Signature area Margins
        signOptions.setMargin(new Padding(10));
        // specify separate left margin value
        signOptions.getMargin().setLeft(20);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        // sign document
        String signedPath = handler.<String>sign("test.docx", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testSetupSignatureAreaAlignment() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        PdfSignImageOptions signOptions = new PdfSignImageOptions("signature.jpg");
        // specify horizontal alignment to the right
        signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        // sign document
        String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testAlignSignatureOnDocumentPage() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup digital signature options
        PdfSignDigitalOptions signOptions = new PdfSignDigitalOptions(new FileDescription("test.pfx"), "signature.jpg");
        signOptions.setPassword("1234567890");
        // image position to locate on right bottom corner with small margins
        signOptions.setHorizontalAlignment(HorizontalAlignment.Right); // only Margin.Right value will be used to shift the Signature rectangle
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom); // only Margin.Bottom value will be used to shift the Signature rectangle
        signOptions.getMargin().setRight(10);
        signOptions.getMargin().setBottom(10);
        // Page Number
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        // sign document
        String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }
}
