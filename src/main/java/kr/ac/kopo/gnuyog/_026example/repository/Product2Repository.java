package kr.ac.kopo.gnuyog._026example.repository;

import kr.ac.kopo.gnuyog._026example.domain.Product2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product2Repository extends JpaRepository<Product2, Integer>
{

}
