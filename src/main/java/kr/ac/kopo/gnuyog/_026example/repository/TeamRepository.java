package kr.ac.kopo.gnuyog._026example.repository;

import kr.ac.kopo.gnuyog._026example.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer>
{

}