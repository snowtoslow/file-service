package md.snow.service;

import md.snow.entity.File;
import md.snow.exception.BadRequestException;
import md.snow.exception.NotFoundExcepion;
import md.snow.repository.FileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class FileService {


    private final FileRepository fileRepository;



    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File setData(String id, byte[] bytes) {

        final File file = fileRepository
                .findById(id)
                .orElseThrow(NotFoundExcepion::new);

        file.setData(bytes);

        return fileRepository.save(file);


    }

    public File findById(String id) {
        final File file = fileRepository
                .findById(id)
                .orElseThrow((NotFoundExcepion::new));
        file.setData(null);
        return file;
    }

    public File save(File newFile) {
        if (isNewFileValid(newFile)){
            return fileRepository.save(newFile);
        }
        throw new BadRequestException();
    }

    private boolean isNewFileValid(File newFile) {
        final String fileName = newFile.getFileName();

        return fileName != null && fileName.length() > 0;

    }
}
