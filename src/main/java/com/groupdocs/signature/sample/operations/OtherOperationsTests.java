package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.*;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.handler.input.IInputDataHandler;
import com.groupdocs.signature.handler.output.IOutputDataHandler;
import com.groupdocs.signature.options.*;
import com.groupdocs.signature.sample.operations.handler.SampleAzureInputDataHandler;
import com.groupdocs.signature.sample.operations.handler.SampleAzureOutputDataHandler;
import com.microsoft.azure.storage.StorageException;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class OtherOperationsTests {
    final String DevStorageEmulatorUrl = "http://127.0.0.1:10000/devstoreaccount1/";
    final String DevStorageEmulatorAccountName = "devstoreaccount1";
    final String DevStorageEmulatorAccountKey = "Eby8vdM02xNOcqFlqUwJPLlmEtlCDXJ1OUzFT50uSRZ6IFsuFq2UVErCz4I6tq/K1SZFPTOtr/KBHBeksoGMGw==";
    final String INPUT_FILE_NAME = "INPUT_FILE_NAME";

    @Test
    public void testHowToUseCustomInputDataHandler() throws FileNotFoundException, URISyntaxException, StorageException {
        SignatureConfig config = new SignatureConfig();
        config.setOutputPath(OUTPUT_PATH);

        String fileName;

        SaveOptions saveOptions = new SaveOptions(OutputType.String);
        IInputDataHandler customInputStorageProvider =
                new SampleAzureInputDataHandler(DevStorageEmulatorUrl, DevStorageEmulatorAccountName, DevStorageEmulatorAccountKey, "testbucket");
        SignatureHandler<String> handlerWithCustomStorage = new SignatureHandler<String>(config, customInputStorageProvider);
        applyLicense();

        InputStream imageStream = new FileInputStream(getImagesPath("Autograph_of_Benjamin_Franklin.png"));
        PdfSignImageOptions options = new PdfSignImageOptions(imageStream);
        options.setDocumentPageNumber(1);
        options.setTop(500);
        options.setWidth(200);
        options.setHeight(100);
        fileName = handlerWithCustomStorage.sign(getStoragePath(INPUT_FILE_NAME), options, saveOptions);
        System.out.println("Document signed successfully. The output filename: " + fileName);
    }

    @Test
    public void testHowToUseCustomOutputDataHandler() throws URISyntaxException, StorageException, FileNotFoundException {
        SignatureConfig config = new SignatureConfig();
        config.setStoragePath(STORAGE_PATH);

        String fileName;
        SaveOptions saveOptions = new SaveOptions(OutputType.String);
        IOutputDataHandler customOutputStorageProvider = new SampleAzureOutputDataHandler(
                DevStorageEmulatorUrl, DevStorageEmulatorAccountName, DevStorageEmulatorAccountKey, "tempbucket");
        SignatureHandler<String> handlerWithCustomStorage = new SignatureHandler<String>(config, customOutputStorageProvider);
        applyLicense();
        InputStream imageStream = new FileInputStream(getImagesPath("Autograph_of_Benjamin_Franklin.png"));
        PdfSignImageOptions options = new PdfSignImageOptions(imageStream);
        options.setDocumentPageNumber(1);
        options.setTop(500);
        options.setWidth(200);
        options.setHeight(100);
        fileName = handlerWithCustomStorage.sign(INPUT_FILE_NAME, options, saveOptions);
        System.out.println("Document signed successfully. The output filename: " + fileName);
    }

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
        signOptions.setBackgroundColor(Color.decode("#FFF5F5"));
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
        saveOptions.setOutputFileName("oo_testSetupFontAndTextColorOptions");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

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
        signOptions.setBackgroundColor(Color.decode("#FFF5F5"));
        signOptions.setBackgroundTransparency(0.5);
        // setup border settings
        signOptions.setBorderColor(Color.BLACK);
        signOptions.setBorderDashStyle(ExtendedDashStyle.DashDot);
        signOptions.setBorderWeight(1.2);
        signOptions.setBorderTransparency(0.5);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("oo_testSetupBackgroundAndBorderSettings");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

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
        saveOptions.setOutputFileName("oo_testSetupImageSignatureRectangleAndMargins");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.docx"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

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
        PdfSignImageOptions signOptions = new PdfSignImageOptions(getImagesPath("signature.jpg"));
        // specify horizontal alignment to the right
        signOptions.setHorizontalAlignment(HorizontalAlignment.Right);
        // specify vertical alignment
        signOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("oo_testSetupSignatureAreaAlignment");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore // does not work
    @Test
    public void testAlignSignatureOnDocumentPage() throws Exception {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup digital signature options
        PdfSignDigitalOptions signOptions = new PdfSignDigitalOptions(new FileDescription(getCertificatePath("test.pfx")), getImagesPath("signature.jpg"));
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
        saveOptions.setOutputFileName("oo_testAlignSignatureOnDocumentPage");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }
}
