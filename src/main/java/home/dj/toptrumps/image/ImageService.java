package home.dj.toptrumps.image;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class ImageService {

    @Value("${gcp.bucket.id}")
    private String gcpBucketId;

    public String upload(MultipartFile file) {
        try {
            StorageOptions options = StorageOptions.newBuilder().setCredentials(GoogleCredentials.getApplicationDefault()).build();
            Storage storage = options.getService();
            Bucket bucket = storage.get(gcpBucketId);
            Blob blob = bucket.create(UUID.randomUUID().toString(), file.getBytes(), file.getContentType());
            return blob.getMediaLink();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
