package net.proselyte.springbootdemo.repository;

        import net.proselyte.springbootdemo.model.Subject;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
