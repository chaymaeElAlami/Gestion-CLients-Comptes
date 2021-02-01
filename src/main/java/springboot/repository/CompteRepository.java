package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.entity.Compte;

import java.util.List;

@Repository
public interface CompteRepository  extends JpaRepository<Compte, Long> {
    List<Compte> getComptesByClientId(Long id);
    @Query(value="select * from t_compte c where c.rib like %:keyword%  ",nativeQuery = true)
    List<Compte> findByTypeLike(@Param("keyword") String keyword);
}
