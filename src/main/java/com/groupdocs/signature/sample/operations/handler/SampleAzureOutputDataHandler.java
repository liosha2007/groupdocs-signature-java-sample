package com.groupdocs.signature.sample.operations.handler;

import com.aspose.ms.System.IO.Stream;
import com.groupdocs.signature.domain.FileDescription;
import com.groupdocs.signature.handler.output.IOutputDataHandler;
import com.groupdocs.signature.options.SaveOptions;
import com.groupdocs.signature.options.SignOptions;

import java.io.InputStream;

/**
 * @author liosha (02.02.2017)
 */
public class SampleAzureOutputDataHandler extends SampleAzureDataHandler implements IOutputDataHandler {
    @Override
    public InputStream createFile(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        return null;
    }

    @Override
    public Stream createFileInternal(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        return null;
    }

    @Override
    public InputStream createStream(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        return null;
    }

    @Override
    public Stream createStreamInternal(FileDescription fileDescription, SignOptions signOptions, SaveOptions saveOptions) {
        return null;
    }
//    public SampleAzureOutputDataHandler(string endpoint,
//                                        string accountName,
//                                        string accountKey,
//                                        string containerName) :
//    base(endpoint, accountName, accountKey, containerName)
//    {
//    }
//    public Stream CreateFile(FileDescription fileDescription, SignOptions signOptions = null,
//                             SaveOptions saveOptions = null)
//    {
//        CloudBlobContainer container = GetContainerReference();
//        string name = fileDescription.GUID.ToLower();
//        CloudBlockBlob blob = container.GetBlockBlobReference(name);
//        using (MemoryStream emptyStream = new MemoryStream())
//        {
//            blob.UploadFromStream(emptyStream);
//        }
//        try
//        {
//            CloudAppendBlob appendBlob = container.GetAppendBlobReference(name);
//            appendBlob.CreateOrReplace();
//            return appendBlob.OpenWrite(true);
//        }
//        catch (Microsoft.WindowsAzure.Storage.StorageException exception)
//        {
//            // Azure Storage Emulator does not support append BLOBs,
//            // so we emulate appending
//            return new CachingAzureStream(blob);
//        }
//    }
//    public Stream CreateStream(FileDescription fileDescription, SignOptions signOptions = null,
//                               SaveOptions saveOptions = null)
//    {
//        throw new NotImplementedException();
//    }
}
