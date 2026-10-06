package kr.ac.kopo.gnuyog._026example.repository;

import jakarta.transaction.Transactional;
import kr.ac.kopo.gnuyog._026example.domain.Member;
import kr.ac.kopo.gnuyog._026example.domain.Member3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface Member3Repository2 extends JpaRepository<Member3, Integer>
{
    // 전체 행(Entity)을 조회
    @Transactional
    @Query(value = "select * from Member3", nativeQuery = true) // 표준 SQL
//    @Query(value = "select entity from Member3 entity") // JPQL
    public List<Member3> selectMembers();

    // 특정한 id를 지닌 한 행 조회
    @Transactional
    @Query(value = "SELECT * FROM Member3 WHERE ID = ?", nativeQuery = true)
//    @Query(value = "SELECT ENTITY FROM Member3 ENTITY WHERE ID = :e_id")
    public Member3 selectById(@Param("e_id")int id);

    // 멤버3 삽입
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Member3(name, age, email) VALUES(?, ?, ?)", nativeQuery = true)
//  @Query(value = "INSERT INTO Member3(name, age, email) VALUES(:e_name, :e_age, :e_email)")
    public int insertMember(@Param("e_name") String name, @Param("e_age")int age,
                            @Param("e_email")String email);

    // 멤버3 수정
    @Transactional
    @Modifying
    @Query(value = "UPDATE Member3 SET name = :e_name, age = :e_age, email = :e_email WHERE id = :e_id",
            nativeQuery = true)
    public int updateMember(@Param("e_name") String name,
                            @Param("e_age") int age,
                            @Param("e_email") String email,
                            @Param("e_id") int id);
    // 멤버 3 삭제
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Member3 WHERE id = ?", nativeQuery = true)
    // @Query("DELETE FROM Member3 WHERE id = e_id")
    public int deleteMember(@Param("e_id") int id);
}
