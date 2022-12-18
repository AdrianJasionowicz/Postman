package letter.status.demo.Repository;

import letter.status.demo.Entity.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status, Integer> {


 List<Status> findAll();
}
