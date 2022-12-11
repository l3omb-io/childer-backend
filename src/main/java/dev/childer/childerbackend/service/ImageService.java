package dev.childer.childerbackend.service;

import dev.childer.childerbackend.models.ImageModel;
import dev.childer.childerbackend.repositories.ImageRepository;
import dev.childer.childerbackend.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;


    public String uploadImage(MultipartFile file) throws IOException {

        ImageModel imageModel = imageRepository.save(ImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.toObjects(ImageUtils.compressImage(file.getBytes()))).build());

        if (imageModel != null){
            return "http://localhost:8080/image/" + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){

        Optional<ImageModel> dbImageData = imageRepository.findByName(fileName);
        byte[] image = ImageUtils.decompressImage(ImageUtils.toPrimitives(dbImageData.get().getImageData()));
        return image;
    }
}
