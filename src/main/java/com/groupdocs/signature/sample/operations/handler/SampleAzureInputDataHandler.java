package com.groupdocs.signature.sample.operations.handler;

import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.handler.input.IInputDataHandler;
import com.microsoft.azure.storage.StorageException;

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
                return null;
        }

        @Override
        public InputStream getStream(String guid) {
                return null;
        }

//public SampleAzureInputDataHandler(String endpoint,
//        String accountName,
//        String accountKey,
//        String containerName)
//
//        {
//                super(endpoint, accountName, accountKey, containerName);
//        }
//public FileDescription GetFileDescription(String guid)
//        {
//        FileDescription result = new FileDescription(guid);
//        return result;
//        }
//public InputStream getStream(String guid)
//        {
//        MemoryStream result = new MemoryStream();
//        CloudBlobContainer container = GetContainerReference();
//        CloudBlockBlob blob = container.GetBlockBlobReference(guid);
//        using (Stream content = blob.OpenRead())
//        {
//        content.CopyTo(result);
//        }
//        result.Seek(0, SeekOrigin.Begin);
//        return result;
//        }
}
