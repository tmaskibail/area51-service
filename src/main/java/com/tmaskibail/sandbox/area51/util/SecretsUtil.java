package com.tmaskibail.sandbox.area51.util;

import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * This is a test bench to check the secrets feature.
 *
 * Please don't use it in production!
 */
public class SecretsUtil {

    private static final Logger LOG = LoggerFactory.getLogger(SecretsUtil.class);

    public static String accessVersion() throws IOException {
        String projectId = "tmaskibail-sandbox";
        String secretId = "db-secret";
        String versionId = "1";
        return accessSecretVersion(projectId, secretId, versionId);
    }

    private static String accessSecretVersion(String projectId, String secretId, String versionId) throws IOException {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, versionId);

            // Access the secret version
            AccessSecretVersionResponse response = client.accessSecretVersion(secretVersionName);
            String payload = response.getPayload().getData().toStringUtf8();

            LOG.debug(payload);
            return payload;
        }
    }
}
