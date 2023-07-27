package io.kapil.springdemo.forms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 27/07/23
 * @Time 12:31 pm
 */

@Controller
@RequestMapping("/form")
public class FormTagController {

    @RequestMapping("/")
    public String home(Model model) {

        Student student = new Student();

        /*student.setFirstName("Kapil");
        student.setLastName("kaushik");*/

        model.addAttribute("student", student); // attributeName should match with modelAttribute in jsp form
        return "form-index";
    }

    @RequestMapping("/process-form")
    public String getFormData(@ModelAttribute("student") Student student) {

        // log input data and do uppercase

        System.out.println(student);

        student.setLastName(student.getLastName().toUpperCase());
        student.setFirstName(student.getFirstName().toUpperCase());

        if (student.getCountry().equals("IND"))
            student.setCountry("Hindustan");

        return "form-data";
    }
}
