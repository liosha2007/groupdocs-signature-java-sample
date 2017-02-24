package com.groupdocs.signature.sample.operations.handler;

import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.handler.output.IOutputDataHandler;
import com.groupdocs.signature.options.SaveOptions;
import com.groupdocs.signature.options.SignOptions;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudAppendBlob;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import sun.security.krb5.internal.ccache.CCacheOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

/**
 * @author liosha (02.02.2017)
 */
public class SampleAzureOutputDataHandler extends SampleAzureDataHandler implements IOutputDataHandler {
    public SampleAzureOutputDataHandler(String endpoint, String accountName, String accountKey, String containerName) throws URISyntaxException, StorageException {
        super(endpoint, accountName, accountKey, containerName);
    }

    @Override
    public OutputStream createFile(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        try {
            CloudBlobContainer container = getContainerReference();
            String name = fileDescription.getGUID().toLowerCase();
            CloudBlockBlob blob = container.getBlockBlobReference(name);
            try {
                CloudAppendBlob appendBlob = container.getAppendBlobReference(name);
                appendBlob.createOrReplace();
                return appendBlob.openWriteNew()/*OpenWrite(true)*/;
            } catch (Exception exception) {
                // Azure Storage Emulator does not support append BLOBs,
                // so we emulate appending
                return new CCacheOutputStream(blob.openOutputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OutputStream createStream(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        throw new NotImplementedException();
    }
}
