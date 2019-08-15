package md.snow.repository;

import md.snow.entity.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FileRepository extends CrudRepository<File,String> {


}
