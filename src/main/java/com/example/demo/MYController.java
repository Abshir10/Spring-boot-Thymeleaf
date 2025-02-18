package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller

public class MYController {
   @Autowired
   MyService myService;

    @GetMapping("")
    public String homePage(){
        return  "homepage";
    }

    @GetMapping("admin")
    public String admin(Model model ){
        model.addAttribute("students", myService.getAllStudents());

        return  "admin";
    }

    @GetMapping("/courses")
    public String courses (  Model model) {
        model.addAttribute("mymodel", new MyModel());
        return "courses" ;
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute MyModel mymodel) {
        // Assuming you want to save the model or process it
        myService.saveCourse(mymodel);
        return "redirect:/courses"; // Redirect to avoid form resubmission
    }


//    <!DOCTYPE html>
//<html xmlns:th="http://www.thymeleaf.org">
//<head>
//    <title>User Form</title>
//</head>
//<body>
//    <h1>User Form</h1>
//<form action="#" th:action="@{/user}" th:object="${user}" method="post">
//    <label>Name:</label>
//    <input type="text" th:field="*{name}" required/><br/>
//
//    <label>Email:</label>
//    <input type="email" th:field="*{email}" required/><br/>
//
//    <button type="submit">Submit</button>
//</form>
//</body>
//</html>

}
