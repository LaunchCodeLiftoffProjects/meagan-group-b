package org.launchcode.Liftoff.Project.Restaurant.App.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.launchcode.Liftoff.Project.Restaurant.App.message.ResponseFile;
import org.launchcode.Liftoff.Project.Restaurant.App.message.ResponseMessage;
import org.launchcode.Liftoff.Project.Restaurant.App.models.ImageDB;
import org.launchcode.Liftoff.Project.Restaurant.App.service.ImageStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@CrossOrigin("http://localhost:8080")
public class ImageController {

    @Autowired
    private ImageStorageService storageService;

    @PostMapping("/restaurant/view/{restaurantId}")
    public String uploadFile(@RequestParam("image") MultipartFile image) {
/*        String message = "";*/
        try {
            storageService.store(image);

/*            message = "Uploaded the image successfully: " + image.getOriginalFilename();*/
           /* return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));*/
            return "redirect:../";
        }   catch (Exception e) {
/*            message = "Could not upload the image: " + image.getOriginalFilename() + "!";*/
/*            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message))*/;
            return "redirect:../";
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        ImageDB imageDB = storageService.getImage(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + imageDB.getName() + "\"")
                .body(imageDB.getData());
    }

}
