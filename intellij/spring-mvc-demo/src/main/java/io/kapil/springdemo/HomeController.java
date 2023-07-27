package io.kapil.springdemo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping("/show-form")
    public String showForm() {
        return "show-form";
    }

    @RequestMapping("/show")
    public String showProcessedData() {
        return "show-process-data";
    }

	/*@RequestMapping("/show-v2")
	public String letsShoutDude(HttpServletRequest req, Model model) {

		// read the req parameter from http form
		String name = req.getParameter("studentName");

		// do some processing
		name = name.toUpperCase();

		// do some extra processing
		String result = "Yo " + name + " !";

		// add message to model
		model.addAttribute("result", result);

		return "show-process-data";
	}*/

    @RequestMapping("/show-v2")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model) {

        // read the req parameter from http form via @RequestParam

        // do some processing
        name = name.toUpperCase();

        // do some extra processing
        String result = "Yo Yo" + name + " !";

        // add message to model
        model.addAttribute("result", result);

        return "show-process-data";
    }
}