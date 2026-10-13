package kr.ac.kopo.gnuyog._026example.repository;

import kr.ac.kopo.gnuyog._026example.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>
{

}