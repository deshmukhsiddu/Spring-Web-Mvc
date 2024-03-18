package Spring.springMvc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
@Autowired
StudentRepo studentRepo;

public void addStudent(Student student) {
studentRepo.save(student);
}
public List<Student> getStudentList() {
return studentRepo.findAll();
}
}