package com.groupdocs.signature.sample.operations;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.options.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.groupdocs.signature.sample.TestRunner.*;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class DigitalOperationsTests {

    @Ignore
    @Test
    public void testDigitalSigningOfCellsDocument() throws IOException {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup digital signature options
        InputStream certificateStream = new FileInputStream(getCertificatePath("SherlockHolmes.pfx"));
        CellsSignDigitalOptions signOptions = new CellsSignDigitalOptions(certificateStream);
        signOptions.getSignature().setComments("Test comment");
        signOptions.getSignature().setSignTime(new Date(2017, 1, 25, 10, 41, 54));
        signOptions.setPassword("1234567890");
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("do_testDigitalSigningOfCellsDocument");
        // sign document
        String signedPath = handler.<String>sign("test.xls", signOptions, saveOptions);
        //File stream must be closed after signing
        certificateStream.close();
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testDigitalSigningOfPDFDocument() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup digital signature options
        PdfSignDigitalOptions signOptions = new PdfSignDigitalOptions(new FileDescription("SherlockHolmes.pfx"), "signature.jpg");
        signOptions.setReason("Test reason");
        signOptions.setContact("Test contact");
        signOptions.setLocation("Test location");
        signOptions.setPassword("1234567890");
        // image position
        signOptions.setLeft(100);
        signOptions.setTop(100);
        signOptions.setWidth(100);
        signOptions.setHeight(100);
        signOptions.setDocumentPageNumber(1);
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("do_testDigitalSigningOfPDFDocument");
        // sign document
        String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testDigitalSigningOfSlidesDocument() {
        // At this moment Slides Documents are not supported by GroupDocs Digital Signature. This feature will be available in future releases
    }

    @Ignore
    @Test
    public void testDigitalSigningOfWordDocument() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup digital signature options
        WordsSignDigitalOptions signOptions = new WordsSignDigitalOptions("SherlockHolmes.pfx");
        signOptions.getSignature().setComments("Test comment");
        signOptions.getSignature().setSignTime(new Date(2017, 1, 25, 10, 41, 54));
        signOptions.setPassword("1234567890");
        final SaveOptions saveOptions = new SaveOptions();
        saveOptions.setOutputType(OutputType.String);
        saveOptions.setOutputFileName("do_testDigitalSigningOfWordDocument");
        // sign document
        String signedPath = handler.<String>sign("test.docx", signOptions, saveOptions);
        System.out.println("Signed file path is: " + signedPath);
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfCellsDocumentWithCERCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup digital verification options
        CellsVerifyDigitalOptions verifyOptions = new CellsVerifyDigitalOptions("SherlockHolmes.cer");
        verifyOptions.setComments("Test1");
        verifyOptions.setSignDateTimeFrom(new Date(2017, 1, 26, 14, 55, 7));
        verifyOptions.setSignDateTimeTo(new Date(2017, 1, 26, 14, 55, 9));

        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.xls", verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfCellsDocumentWithPFXCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup digital verification options
        CellsVerifyDigitalOptions verifyOptions1 = new CellsVerifyDigitalOptions("DrWatson.pfx");
        //password is needed to open .pfx certificate
        verifyOptions1.setPassword("1234567890");
        CellsVerifyDigitalOptions verifyOptions2 = new CellsVerifyDigitalOptions("SherlockHolmes.cer");
        VerifyOptionsCollection verifyOptionsCollection = new VerifyOptionsCollection(verifyOptions1, verifyOptions2);

        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.xls", verifyOptionsCollection);
        System.out.println("Signed file verification result: " + result.isValid());
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfPDFDocumentWithCERCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup digital verification options
        PDFVerifyDigitalOptions verifyOptions = new PDFVerifyDigitalOptions("DrWatson.cer");
        verifyOptions.setReason("Test reason");
        verifyOptions.setContact("Test contact");
        verifyOptions.setLocation("Test location");
        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.pdf", verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfPDFDocumentWithPFXCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup digital verification options
        PDFVerifyDigitalOptions verifyOptions1 = new PDFVerifyDigitalOptions("DrWatson.pfx");
        //password is needed to open .pfx certificate
        verifyOptions1.setPassword("1234567890");
        PDFVerifyDigitalOptions verifyOptions2 = new PDFVerifyDigitalOptions("SherlockHolmes.cer");
        VerifyOptionsCollection verifyOptionsCollection =
                new VerifyOptionsCollection(verifyOptions1, verifyOptions2);
        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.pdf", verifyOptionsCollection);
        System.out.println("Signed file verification result: " + result.isValid());
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfSlidesDocument() {
        // At this moment Slides Documents are not supported by GroupDocs Digital Signature Verification. This feature will be available in future releases
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfWordsDocumentWithCERCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);

        VerifyOptionsCollection verifyOptionsCollection = new VerifyOptionsCollection();
        // setup digital verification options
        WordsVerifyDigitalOptions verifyOptions = new WordsVerifyDigitalOptions("SherlockHolmes.cer");
        verifyOptions.setComments("Test1");
        verifyOptions.setSignDateTimeFrom(new Date(2017, 1, 26, 14, 55, 57));
        verifyOptions.setSignDateTimeTo(new Date(2017, 1, 26, 14, 55, 59));
        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.Docx", verifyOptions);
        System.out.println("Signed file verification result: " + result.isValid());
    }

    @Ignore
    @Test
    public void testDigitalVerificationOfWordsDocumentWithPFXCertificateContainer() {
        // setup Signature configuration
        SignatureConfig signConfig = new SignatureConfig();
        signConfig.setStoragePath(STORAGE_PATH);
        signConfig.setOutputPath(OUTPUT_PATH);
        signConfig.setImagesPath(IMAGES_PATH);
        signConfig.setCertificatesPath(CERTIFICATES_PATH);
        // instantiating the conversion handler
        SignatureHandler handler = new SignatureHandler(signConfig);
        // setup digital verification options
        WordsVerifyDigitalOptions verifyOptions1 = new WordsVerifyDigitalOptions("DrWatson.pfx");
        //password is needed to open .pfx certificate
        verifyOptions1.setPassword("1234567890");
        WordsVerifyDigitalOptions verifyOptions2 = new WordsVerifyDigitalOptions("SherlockHolmes.cer");
        VerifyOptionsCollection verifyOptionsCollection =
                new VerifyOptionsCollection(verifyOptions1, verifyOptions2);
        //verify document
        VerificationResult result = handler.verify("test_digitalsigned.Docx", verifyOptionsCollection);
        System.out.println("Signed file verification result: " + result.isValid());
    }

}
