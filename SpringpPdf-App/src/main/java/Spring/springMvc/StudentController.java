package Spring.springMvc;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class StudentController {
  @RestController
  @RequestMapping("/pdf")
  public class PdfController {
      @Autowired
      private StudentService service;
      @GetMapping("/export")
      public String exportPdf() {
          try {
        	  StudentService.generatePdf("student.pdf");
              return "PDF exported successfully!";
          } catch (DocumentException e) {
              e.printStackTrace();
              return "Error exporting PDF";
          }
      }
  }
}
  