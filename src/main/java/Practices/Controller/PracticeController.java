package Practices.Controller;

import Practices.Entitie.Practice;
import Practices.Exception.AlreadyRegisteredException;
import Practices.Exception.GenericException;
import Practices.Exception.NotFoundException;
import Practices.Service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/practice")
public class PracticeController {

    @Autowired
    PracticeService practiceService;

    @PostMapping("/createPractice")
    public ResponseEntity create(@RequestBody Practice practice) throws AlreadyRegisteredException {
        return practiceService.createThePractice(practice);
    }

    @GetMapping("/practices")
    public List<Practice> allPractices(){
        return practiceService.getAllPractice();
    }

    @GetMapping("/singlePractice")
    public Practice singlePractice(@RequestParam long id) throws NotFoundException {
        return practiceService.getSinglePractice(id);
    }

    @GetMapping("/practiceWithCode")
    public Practice practiceWithCode(@RequestParam String code) throws NotFoundException {
        return practiceService.getPracticeWithCode(code);
    }

    @PutMapping("/deletePractice")
    public void delete(@RequestParam long id) throws NotFoundException, GenericException {
        practiceService.deletePractice(id);
    }

    @GetMapping("/practiceWithIdOfUser")
    public List<Practice> acticeOfUser(@RequestParam String numberIdUser){
        return practiceService.getPracticeOfUser(numberIdUser);
    }
}
