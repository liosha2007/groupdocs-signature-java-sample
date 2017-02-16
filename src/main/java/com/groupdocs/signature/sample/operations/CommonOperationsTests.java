package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.CellsSaveFileFormat;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.domain.HorizontalAlignment;
import com.groupdocs.signature.domain.VerticalAlignment;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.options.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class CommonOperationsTests {

    @Test
    public void testGetSourceDocumentFromAbsolutePath() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the signature handler without Signature Config object
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        SignOptions signOptions = new PdfSignImageOptions(getImagesPath("signature.jpg"));
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testGetSourceDocumentFromAbsolutePath.pdf");
        // sign document with image
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testGetSourceDocumentFromRelativePath() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SignOptions signOptions = new PdfSignImageOptions("signature.jpg");
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testGetSourceDocumentFromRelativePath.pdf");
        // sign document
        String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testGetSourceDocumentFromUri() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the signature handler without Signature Config object
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        SignOptions signOptions = new PdfSignImageOptions("http://groupdocs.com/images/banner/carousel2/conversion.png");
        // save options
        SaveOptions saveOptions = new SaveOptions(OutputType.String, "co_testGetSourceDocumentFromUri.pdf");
        // sign document with image
        String signedPath = handler.<String>sign("https://www.adobe.com/content/dam/Adobe/en/feature-details/acrobatpro/pdfs/combine-multiple-documents-into-one-pdf-file.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testGetSourceDocumentFromStream() throws IOException {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        // instantiating the signature handler without Signature Config object
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup image signature options
        SignOptions signOptions = new PdfSignImageOptions("http://groupdocs.com/images/banner/carousel2/conversion.png");
        // save options
        SaveOptions saveOptions = new SaveOptions(OutputType.String, "co_testGetSourceDocumentFromStream.pdf");
        InputStream fileStream = new FileInputStream(getStoragePath("test.pdf"));
        // sign document with image
        String signedPath = handler.<String>sign(fileStream, signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testLoadingALicenseFromFile() {
        // Path to license file
        String licensePath = LICENSE_PATH;
        License license = new License();
        // Set license
        license.setLicense(licensePath);
    }

    @Test
    public void testLoadingALicenseFromAStreamObject() throws IOException {
        // Obtain license stream
        InputStream licenseStream = new FileInputStream(LICENSE_PATH);
        // Instantiate GroupDocs.Signature handler
        License license = new License();
        // setup license
        license.setLicense(licenseStream);
    }

    @Test
    public void testOpenPasswordProtectedDocuments() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setStoragePath(STORAGE_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        SignOptions signOptions = new CellsSignTextOptions("John Smith");
        // specify load options
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");
        // specify save options
        SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testOpenPasswordProtectedDocuments.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, loadOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSaveSignedDocumentsWithDifferentFileFormat() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setStoragePath(STORAGE_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        SignOptions signOptions = new CellsSignTextOptions("John Smith");
        // specify load options
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");
        // specify save options
        CellsSaveOptions saveOptions = new CellsSaveOptions(OutputType.String);
        saveOptions.setOutputFileName("co_testSaveSignedDocumentsWithDifferentFileFormat.ods");
        saveOptions.setFileFormat(CellsSaveFileFormat.ODS);
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, loadOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Test
    public void testSaveSignedDocumentsWithDifferentFileName() {
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setStoragePath(STORAGE_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
        SignOptions signOptions = new CellsSignTextOptions("John Smith");
        // specify load options
        LoadOptions loadOptions = new LoadOptions();
        // specify save options
        CellsSaveOptions saveOptions = new CellsSaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testSaveSignedDocumentsWithDifferentFileName.xls");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.xls"), signOptions, loadOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore // does not work
    @Test
    public void testSetupMultipleSignatureOptions() throws Exception {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);// instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // define Signature Options Collection
        SignatureOptionsCollection collection = new SignatureOptionsCollection();
        // specify text option
        PdfSignTextOptions signTextOptions = new PdfSignTextOptions("Mr. John", 100, 100, 100, 100);
        // add to collection
        collection.add(signTextOptions);
        // specify image options
        PdfSignImageOptions signImageOptions = new PdfSignImageOptions("signature.jpg");
        signImageOptions.setLeft(200);
        signImageOptions.setTop(200);
        signImageOptions.setWidth(100);
        signImageOptions.setHeight(100);
        // add to collection
        collection.add(signImageOptions);
        // specify digital options
        PdfSignDigitalOptions signDigitalOptions = new PdfSignDigitalOptions(new FileInputStream(getCertificatePath("test.pfx")));
        signDigitalOptions.setPassword("1234567890");
        signDigitalOptions.setVerticalAlignment(VerticalAlignment.Bottom);
        signDigitalOptions.setHorizontalAlignment(HorizontalAlignment.Center);
        // add to collection
        collection.add(signDigitalOptions);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testSetupMultipleSignatureOptions.pdf");
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), collection, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore // does not work
    @Test
    public void testImposePdfDigitalSignatureWithTextSignatureAboveAndUnderSignatureArea() throws Exception {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // define Signature Options Collection
        SignatureOptionsCollection collection = new SignatureOptionsCollection();
        // specify text option
        PdfSignTextOptions signTextOptionsFirst = new PdfSignTextOptions("Mr. John First");
        signTextOptionsFirst.setLeft(0);
        signTextOptionsFirst.setTop(0);
        // add to collection
        collection.add(signTextOptionsFirst);
        // specify digital options
        PdfSignDigitalOptions signDigitalOptions = new PdfSignDigitalOptions(new FileDescription(getCertificatePath("test.pfx")));
        signDigitalOptions.setPassword("1234567890");
        signDigitalOptions.setReason("Any reason");
        signDigitalOptions.setLocation("Some location");
        signDigitalOptions.setLeft(0);
        signDigitalOptions.setTop(35);
        signDigitalOptions.setWidth(350);
        // add to collection
        collection.add(signDigitalOptions);
        // specify text option
        PdfSignTextOptions signTextOptionsSecond = new PdfSignTextOptions("Mr. John Second");
        signTextOptionsSecond.setLeft(0);
        signTextOptionsSecond.setTop(100);
        // add to collection
        collection.add(signTextOptionsSecond);
        final SaveOptions saveOptions = new SaveOptions();
        // sign document
        String signedPath = handler.<String>sign(getStoragePath("test.pdf"), collection, saveOptions);
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("co_testImposePdfDigitalSignatureWithTextSignatureAboveAndUnderSignatureArea-java.pdf");
        System.out.println("Signed file path is: " + signedPath);
    }
}
