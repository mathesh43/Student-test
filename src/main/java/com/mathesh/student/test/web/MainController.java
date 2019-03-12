/**
 * 
 */
package com.mathesh.student.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mathesh
 *
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String greeting() {
        return "redirect:swagger-ui.html";
    }
}
