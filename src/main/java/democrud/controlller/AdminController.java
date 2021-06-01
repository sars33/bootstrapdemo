package democrud.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/all")
    public String getUsersPage() {
        return "allUsers_page";
    }

}
