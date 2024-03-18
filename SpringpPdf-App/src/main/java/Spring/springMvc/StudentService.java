package Spring.springMvc;
import java.util.List;

import javax.swing.text.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class StudentService {
    @Autowired
    private StudentRepo Repository;
    
	private Object PdfWriter;

    public void generatePdf(String filePath) throws DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        List<Student> products = Repository.findAll();

        pdftable table = new pdftable(3); 
        
       
        table.addCell("Name");
        table.addCell("email");
        table.addCell("mobileNo");

        // Add table data
        for (Student student : products) {
            table.addCell(student.getStudentName());
            table.addCell(String.valueOf(student.getEmail()));
            table.addCell(String.valueOf(student.getMobileNo()));
        }

        document.add(new Paragraph("Products Report"));
        document.add(table);
        document.close();
    }
}
