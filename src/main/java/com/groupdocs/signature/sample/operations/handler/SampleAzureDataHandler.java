package com.groupdocs.signature.sample.operations.handler;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageCredentialsAccountAndKey;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author liosha (02.02.2017)
 */
public class SampleAzureDataHandler {
    private CloudBlobClient _remoteStorage;
    private String _containerName;

    public SampleAzureDataHandler(String endpoint,
                                  String accountName,
                                  String accountKey,
                                  String containerName) throws URISyntaxException, StorageException {
        StorageCredentials credentials = new StorageCredentialsAccountAndKey(accountName, accountKey);
        CloudStorageAccount account = new CloudStorageAccount(credentials, new URI(endpoint), null, null, null);
        _remoteStorage = account.createCloudBlobClient();
        _containerName = containerName;
        final Integer defTimeout = _remoteStorage.getDefaultRequestOptions().getTimeoutIntervalInMs();
        _remoteStorage.getDefaultRequestOptions().setTimeoutIntervalInMs(defTimeout);
        CloudBlobContainer container = _remoteStorage.getContainerReference(containerName);
        container.createIfNotExists();
        _remoteStorage.getDefaultRequestOptions().setTimeoutIntervalInMs(defTimeout);
    }

    public CloudBlobContainer getContainerReference() throws URISyntaxException, StorageException {
        CloudBlobContainer container = _remoteStorage.getContainerReference(_containerName);
        return container;
    }
}
