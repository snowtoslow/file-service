package md.snow.controller;


import md.snow.entity.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("file")
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createFile(@RequestBody File file){
        System.out.println(file.getFileName());
    }


    @PostMapping(consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void uploadFile(){
        logger.info("upload");
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
