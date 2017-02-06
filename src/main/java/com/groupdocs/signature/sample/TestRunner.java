package com.groupdocs.signature.sample;


import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.sample.operations.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.io.File;

/**
 * @author Aleksey Permyakov (01.02.2017)
 */
public class TestRunner {
    public static String PROJECT_PATH = new File("Data").getAbsolutePath();
    public static String STORAGE_PATH = PROJECT_PATH + "\\Storage";
    public static String OUTPUT_PATH = PROJECT_PATH + "\\Output";
    public static String IMAGES_PATH = PROJECT_PATH + "\\Images";
    public static String CERTIFICATES_PATH = PROJECT_PATH + "\\Certificates";
    public static String LICENSE_PATH = STORAGE_PATH + "\\GroupDocs.Total.Java.lic";

    /**
     * Main class to run tests
     *
     * @param args params
     */
    public static void main(String[] args) {
        applyLicense();

        Result result = JUnitCore.runClasses(
                CommonOperationsTests.class,
                TextOperationsTests.class,
                ImageOperationsTests.class,
                DigitalOperationsTests.class,
                OtherOperationsTests.class
        );

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            failure.getException().printStackTrace();
        }

        System.out.println(String.format("=== SUCCESS: %d, FAIL: %d, IGNORE: %d ===", result.getRunCount(), result.getFailureCount(), result.getIgnoreCount()));
    }

    static void applyLicense() {
        License lic = new License();
        if (LICENSE_PATH != null && new File(LICENSE_PATH).exists()) {
            lic.setLicense(LICENSE_PATH);
        }
    }

    public static String getStoragePath(String fileName, String... subDirectories) {
        StringBuilder builder = new StringBuilder(STORAGE_PATH);
        for (String part : subDirectories) {
            builder.append(File.separator).append(part);
        }
        return builder.append(File.separator).append(fileName).toString();
    }

    public static String getOutputPath(String fileName) {
        return OUTPUT_PATH + File.separator + fileName;
    }

    public static String getImagesPath(String fileName) {
        return IMAGES_PATH + File.separator + fileName;
    }

    public static String getCertificatePath(String fileName) {
        return CERTIFICATES_PATH + File.separator + fileName;
    }

    static {
        final java.io.File sp = new java.io.File(STORAGE_PATH);
        final java.io.File op = new java.io.File(OUTPUT_PATH);
        final java.io.File ip = new java.io.File(OUTPUT_PATH);
        final java.io.File cp = new java.io.File(CERTIFICATES_PATH);
        final java.io.File lcp = new java.io.File(LICENSE_PATH);
        if (!lcp.exists()) {
            LICENSE_PATH = System.getenv("GROUPDOCS_SIGNATURE");
            System.out.println("License file does not exists! Using license from %GROUPDOCS_SIGNATURE% ...");
        }
        if ((!sp.exists() && !sp.mkdirs()) || (!op.exists() && !op.mkdirs()) || (!ip.exists() && !ip.mkdirs()) || (!cp.exists() && !cp.mkdirs())) {
            System.err.println("Can't create data directories!!!");
        }
    }
}
