package org.launchcode.Liftoff.Project.Restaurant.App.service;

import org.launchcode.Liftoff.Project.Restaurant.App.data.ImageDBRepository;
import org.launchcode.Liftoff.Project.Restaurant.App.models.ImageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class ImageStorageService {

    @Autowired
    private ImageDBRepository imageDBRepository;

    public ImageDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ImageDB ImageDB = new ImageDB(fileName, file.getContentType(), file.getBytes());

        return imageDBRepository.save(ImageDB);
    }

    public ImageDB getImage(String id) {
        return imageDBRepository.findById(id).get();
    }

    public Stream<ImageDB> getAllFiles() {
        return imageDBRepository.findAll().stream();
    }
}
