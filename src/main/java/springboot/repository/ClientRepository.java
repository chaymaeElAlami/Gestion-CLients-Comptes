package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.entity.Client;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value="select * from t_client c where c.nom like %:keyword% or c.prenom like %:keyword% ",nativeQuery = true)
    List<Client> findByTypeLike(@Param("keyword") String keyword);
}
