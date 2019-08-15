package md.snow.controller;


import md.snow.entity.File;
import md.snow.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("file")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String createFile(@RequestBody File newFile){
        final File savedFile = fileRepository.save(newFile);

        return savedFile.getId();
    }


    @PostMapping( value = "{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
    produces = MediaType.TEXT_PLAIN_VALUE)
    public String uploadFile(@PathVariable  String id,
                             @RequestParam("content") MultipartFile fileContent)throws Exception{
        final File file = fileRepository
                .findById(id)
                .orElseThrow(()->new Exception("Not Found"));

        file.setData(fileContent.getBytes());

        fileRepository.save(file);

        return file.getId();
    }


    @GetMapping(value = "{id}", produces =MediaType.APPLICATION_JSON_VALUE)
    public void getFile(@PathVariable String id){
        logger.info("get");
    }


    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadFile(@PathVariable String id){
        logger.info("download");
    }
}
