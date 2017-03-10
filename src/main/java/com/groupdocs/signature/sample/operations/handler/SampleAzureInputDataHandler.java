package com.groupdocs.signature.sample.operations.handler;

import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.handler.input.IInputDataHandler;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobInputStream;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * @author liosha (02.02.2017)
 */
public class SampleAzureInputDataHandler extends SampleAzureDataHandler implements IInputDataHandler {
    public SampleAzureInputDataHandler(String endpoint, String accountName, String accountKey, String containerName) throws URISyntaxException, StorageException {
        super(endpoint, accountName, accountKey, containerName);
    }

    @Override
    public FileDescription getFileDescription(String guid) {
        FileDescription result = new FileDescription(guid);
        return result;
    }

    @Override
    public InputStream getStream(String guid) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        try {
            CloudBlobContainer container = null;
            container = getContainerReference();
            CloudBlockBlob blob = container.getBlockBlobReference(guid);
            BlobInputStream content = blob.openInputStream();
            IOUtils.copy(content, result);
            return new ByteArrayInputStream(result.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
