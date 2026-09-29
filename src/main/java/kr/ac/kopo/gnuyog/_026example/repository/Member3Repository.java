package kr.ac.kopo.gnuyog._026example.repository;
// DB 접근 담당 인터페이스는 repository 패키지에 둬요.
import kr.ac.kopo.gnuyog._026example.domain.Member3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Entity 이름과 Repository 이름이 일치해야 한다
@Repository
// 스프링에게 "이것은 DB 접근 담당 빈이야"라고 알려줘요.
// (JpaRepository를 상속하면 없어도 동작하지만, 역할을 드러내려고 붙이는 게 일반적이에요.)
public interface Member3Repository extends JpaRepository<Member3, Integer>
{

}
// interface: 구현 클래스를 직접 안 만들어요. 스프링이 실행 시점에 구현체를 자동 생성해줘요.
// JpaRepository<Member3, Integer>: 첫 번째는 다룰 엔티티(Member3),
// 두 번째는 기본키 타입(id가 int이므로 Integer)이에요.
