package home.dj.toptrumps.image;

import home.dj.api.ImagesApi;
import home.dj.model.UploadImage201Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class ImageController implements ImagesApi {
    private final ImageService imageService;
    @Override
    public ResponseEntity<UploadImage201Response> uploadImage(MultipartFile file) {
        return new ResponseEntity<>(new UploadImage201Response().url(imageService.upload(file)), CREATED);
    }
}
