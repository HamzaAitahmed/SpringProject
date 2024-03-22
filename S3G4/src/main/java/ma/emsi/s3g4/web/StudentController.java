package ma.emsi.s3g4.web;

import lombok.AllArgsConstructor;
import ma.emsi.s3g4.dao.StudentRepository;
import ma.emsi.s3g4.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@AllArgsConstructor
@Controller public class StudentController {
    @Autowired StudentRepository studentRepo;
    @GetMapping(path = "/index")
    public String index(Model model ,
                                @RequestParam( name="page" , defaultValue = "0" ) int page ,
                                @RequestParam( name="size" , defaultValue = "3" ) int size ,
                                @RequestParam( name="seachName" , defaultValue = "") String searchName ,
                                @RequestParam(name="id" ) int id )
    {
        //List<Student> studentlist = studentRepo.findAll();

        //Page<Student> pagestudents = studentRepo.findAll(PageRequest.of(page,size));
        Page<Student> pagestudents = studentRepo.findByFullNameContaines(searchName , PageRequest.of(page,size) );


        int[] pages = new int[pagestudents.getTotalPages()];
        for (int i=0 ; i<pages.length ; i++)
            pages[i] = i;


        model.addAttribute("PageStudent", pagestudents.getContent() );
        model.addAttribute("tabpages", pages );
        model.addAttribute("size", size );
        model.addAttribute("currentPage", page );
        model.addAttribute("seachName", searchName );

        // model.addAttribute("ListStudents",studentlist );

        return "AllStudents";
    }

    @GetMapping(path = "/delete")
    public String delete(Model model ,
                         @RequestParam( name="page" , defaultValue = "0" ) int page ,
                         @RequestParam( name="size" , defaultValue = "3" ) int size ,
                         @RequestParam( name="searchName" , defaultValue = "") String searchName,
                         @RequestParam(name="id") int id ){
        studentRepo.deleteById(id);
        return "redirect:/index?page="+page+"&size="+size+"&searchName="+searchName;
    }

    @GetMapping(path = "/edit")
    public String edit(Model model ,
                         @RequestParam( name="page" , defaultValue = "0" ) int page ,
                         @RequestParam( name="size" , defaultValue = "3" ) int size ,
                         @RequestParam( name="searchName" , defaultValue = "") String searchName,
                         @RequestParam(name="id") int id )
    {

        Student editStudent = studentRepo.findById(id).orElse(null);
        if(editStudent == null) throw new RuntimeException("probleme de chargement d objet");
        model.addAttribute("editStudent" , editStudent);
        return "edit";
    }

    @PostMapping(path = "/save")
    public String save(Model model ,  Student saveStudent){
        studentRepo.save(saveStudent);
        return "redirect:/index";
    }

    @GetMapping(path = "/create")
    public String create(Model model){
        Student createStudent = new Student();
        model.addAttribute("createStudent" , createStudent);
        return "create";
    }

}
