package Practices;

import Practices.Entitie.Practice;
import Practices.Repository.PracticeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PracticesApplicationTests {

	@Autowired
	PracticeRepository practiceRepository;


	@Test
	public void createThePractice1(){
		Practice practice= new Practice();
		practice.setNumberPractice("A001");
		practice.setNumberIdUser("A00001");
		practice.setDescription("this is the practice for purchase the car");
		practice.setData(new Date(17/7/2020));
		practice.setAmount(1000);
		practice.setNameUser("Luca");
		practice.setSurnameUser("Rossi");
		practice.setDelete(false);

		practiceRepository.save(practice);
		Assertions.assertNotNull(practice);
	}


	@Test
	public void createThePractice2(){
		Practice practice= new Practice();
		practice.setNumberPractice("A001");
		practice.setNumberIdUser("A00002");
		practice.setDescription("this is the practice for purchase the house");
		practice.setData(new Date(17/7/2020));
		practice.setAmount(1000);
		practice.setNameUser("Marco");
		practice.setSurnameUser("Neri");
		practice.setDelete(false);

		practiceRepository.save(practice);
		Assertions.assertNotNull(practice);
	}


	@Test
	public void createThePractice3(){
		Practice practice= new Practice();
		practice.setNumberPractice("A002");
		practice.setNumberIdUser("A00001");
		practice.setDescription("this is the practice for purchase the house");
		practice.setData(new Date(17/7/2020));
		practice.setAmount(1000);
		practice.setNameUser("Luca");
		practice.setSurnameUser("Rossi");
		practice.setDelete(false);

		practiceRepository.save(practice);
		Assertions.assertNotNull(practice);
	}


	@Test
	public void getAllPractices(){
		createThePractice1();
		createThePractice2();

		List<Practice> practiceList= practiceRepository.findAll();
		Assertions.assertNotNull(practiceList);
	}


	@Test
	public void getSinglePracticeWithId(){
		createThePractice1();
		createThePractice2();

		long findThePracticeWithId= 1;

		Optional<Practice> getPractice= practiceRepository.findById(findThePracticeWithId);
		Assertions.assertEquals(getPractice.get().getId(), findThePracticeWithId);
	}


	@Test
	public void getSinglePracticeWithCode(){
		createThePractice1();
		createThePractice2();

		String findPracticeWithCode= "A002";

		Optional<Practice> getPractice= practiceRepository.getWithCode(findPracticeWithCode);
		Assertions.assertEquals(getPractice.get().getNumberPractice(), findPracticeWithCode);
	}


	@Test
	public void deletePracticeWithIdOfUser(){
		createThePractice1();
		createThePractice2();

		long codeIdForDeleteTheUser= 2;

		Optional<Practice> deleteThePractice= practiceRepository.findById(codeIdForDeleteTheUser);
		deleteThePractice.get().setDelete(true);
		Assertions.assertEquals(practiceRepository.save(deleteThePractice.get()).isDelete(), true);
	}


	@Test
	public void getPracticesWithNumberIdUser(){
		createThePractice1();
		createThePractice2();
		createThePractice3();

		String numberIdTheUser= "A00001";

		Iterable<Practice> getPractice= practiceRepository.findPracticeWithIdUser(numberIdTheUser);
		Assertions.assertEquals(getPractice.iterator().next().getNumberIdUser(), numberIdTheUser);
	}
}
