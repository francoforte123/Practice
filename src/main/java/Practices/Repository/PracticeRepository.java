package Practices.Repository;

import Practices.Entitie.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracticeRepository extends JpaRepository<Practice, Long> {

    @Query(value = "select * from practices where practices.number_id_user= ? and practices.is_delete= false", nativeQuery = true)
    Iterable<Practice> findPracticeWithIdUser(String numberIdUser);
    @Query(value = "select * from practices where practices.number_practice= ? and practices.is_delete= false", nativeQuery = true)
    Optional<Practice> getWithCode(String code);
}
