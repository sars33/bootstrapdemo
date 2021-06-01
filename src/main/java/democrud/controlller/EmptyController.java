package democrud.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmptyController {
    @GetMapping("/")
    public String toLoginPage() {
        return "redirect:/login";
    }
}
