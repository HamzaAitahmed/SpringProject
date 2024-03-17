package ma.emsi.s3g4.web;

import ma.emsi.s3g4.dao.StudentRepository;
import ma.emsi.s3g4.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller public class StudentController {
    @Autowired StudentRepository studentRepo;
    @GetMapping(path = "/index")
    public String FindStudents(Model model ,
                                @RequestParam( name="page" , defaultValue = "0" ) int page ,
                                @RequestParam( name="size" , defaultValue = "3" ) int size ,
                                @RequestParam( name="nameStudent") String name )
    {
        List<Student> studentlist = studentRepo.findAll();

        Page<Student> pagestudents = studentRepo.findAll(PageRequest.of(page,size));
        //Page<Student> studentByName = studentRepo.findByFullNameConataines(name);

        int[] pages = new int[pagestudents.getTotalPages()];
        for (int i=0 ; i<pages.length ; i++)
            pages[i] = i;


        model.addAttribute("PageStudent", pagestudents.getContent() );
        model.addAttribute("pages", pages );
        model.addAttribute("size", size );
        model.addAttribute("currentPage", page );

        // model.addAttribute("ListStudents",studentlist );

        return "AllStudents";
    }
}
