package letter.status.demo.Controller;


import letter.status.demo.Entity.Status;
import letter.status.demo.Service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/delivery")
    public List<Status> showStatus() {
        return statusService.getAll();
    }

    @GetMapping("/delivery/{id}")
    public Status showStatus(@PathVariable Integer id) {
        return statusService.getById(id);
    }

    @PutMapping("/delivery/{id}")
    public Status updateStatu(@RequestBody Status updater, @PathVariable Integer id) {
        if (!updater.getId().equals(id)) {
            throw new IllegalArgumentException("Delivery Id not Found");
        }
        return statusService.updateStatus(updater);
    }

    @PostMapping("/delivery")
    public Status addStatus(@RequestBody Status object) {
return statusService.add(object);
    }
    @DeleteMapping("/delivery/{id}")
public void deleteStatus(@PathVariable Integer id) {
statusService.deleteById(id);
    }

 /*   @PatchMapping("/delivery/{id}/{send},{ontheway},{delivered}")
    public Status patchStatus(@PathVariable Integer id, boolean send, boolean ontheway, boolean delivered) {

        return statusService.patchById(id,send,ontheway,delivered);
    }
*/
}
