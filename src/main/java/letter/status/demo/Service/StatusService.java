package letter.status.demo.Service;


import letter.status.demo.Entity.Status;
import letter.status.demo.Exception.StatusNotFound;
import letter.status.demo.Repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    public Status getById(Integer id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.orElseThrow(() -> new StatusNotFound("Error Delivery ID Not Found"));
    }

    public Status updateStatus(Status updater) {
        return statusRepository.save(updater);
    }

    public Status add(Status object) {
        if (object.getId() != null) {
            throw new RuntimeException("Delivery Id Already exist");
        }
        return statusRepository.save(object);
    }

    public void deleteById(Integer id) {
statusRepository.deleteById(id);
    }
/*
    public Status patchById(Integer id, boolean send, boolean ontheway, boolean delivered) {
      return  statusRepository.save(send,ontheway,delivered);
    }

 */
}
