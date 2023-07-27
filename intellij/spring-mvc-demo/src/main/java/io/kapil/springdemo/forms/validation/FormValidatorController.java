package io.kapil.springdemo.forms.validation;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 27/07/23
 * @Time 3:17 pm
 */

@Controller
@RequestMapping("/form-validator")
public class FormValidatorController {


    // add an initbinder ... to convert trim input strings
    //remove leading & trailing whitespaces from input string
    // resolve issue for our validation

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }


    @RequestMapping("/")
    public String home(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer); // attributeName should match with modelAttribute in jsp form
        return "form-validation";
    }

    @RequestMapping("/process-form")
    public String getFormData(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {

        // log input data and do uppercase

        System.out.println(customer);
        if (result.hasErrors()) {
            return "form-validation";
        }
        return "form-confirmation";
    }
}
