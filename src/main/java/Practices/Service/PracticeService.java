package Practices.Service;

import Practices.Entitie.Practice;
import Practices.Exception.AlreadyRegisteredException;
import Practices.Exception.GenericException;
import Practices.Exception.NotFoundException;
import Practices.Repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticeService {

    @Autowired
    PracticeRepository practiceRepository;


    public ResponseEntity createThePractice(Practice practice) throws AlreadyRegisteredException {
        Optional<Practice> optionalPractice= practiceRepository.getWithCode(practice.getNumberPractice());
        if (optionalPractice.isPresent()) throw new AlreadyRegisteredException("the number of practice: " + practice.getNumberPractice() + ", already registered");
        practiceRepository.save(practice);
        return ResponseEntity.ok(practice);
    }

    public List<Practice> getAllPractice(){
        List<Practice> getPractices= practiceRepository.findAll();
        if (getPractices.isEmpty()) HttpStatus.valueOf(500);
        return ResponseEntity.ok(getPractices).getBody();
    }

    public Practice getSinglePractice(long id) throws NotFoundException {
        Optional<Practice> getPractice= practiceRepository.findById(id);
        if (getPractice.isEmpty()) throw new NotFoundException("the practice with id: " + id + ", not found");
        return ResponseEntity.ok(getPractice).getBody().get();
    }

    public Practice getPracticeWithCode(String code) throws NotFoundException {
        Optional<Practice> getPractice= practiceRepository.getWithCode(code);
        if (getPractice.isEmpty()) throw new NotFoundException("the number of practice with code: " + code + ", not found");
        return ResponseEntity.ok(getPractice).getBody().get();
    }

    public void deletePractice(long id) throws NotFoundException, GenericException {
        Optional<Practice> deletePractice= practiceRepository.findById(id);
        if (deletePractice.isEmpty()) throw new NotFoundException("the practice with id: " + id + ", not found");
        if (deletePractice.get().isDelete()==false){
            deletePractice.get().setDelete(true);
        }else {
            throw new GenericException("exists product");
        }
        practiceRepository.save(deletePractice.get());
    }

    public List<Practice> getPracticeOfUser(String numberIdUser){
        List<Practice> practiceOptional= practiceRepository.findPracticeWithIdUser(numberIdUser);
        if (practiceOptional.isEmpty()) HttpStatus.valueOf(200);
        return ResponseEntity.ok(practiceOptional).getBody();
    }
}
