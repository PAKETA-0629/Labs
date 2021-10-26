package net.proselyte.springbootdemo.service;

        import net.proselyte.springbootdemo.model.Subject;
        import net.proselyte.springbootdemo.repository.SubjectRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(Long id){
        return subjectRepository.getOne(id);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    public Subject saveUser(Subject user){
        return subjectRepository.save(user);
    }

    public void deleteById(Long id){
        subjectRepository.deleteById(id);
    }
}

