package democrud.controlller;

import democrud.security.details.UserDetailsImpl;
import democrud.security.transfer.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String userPage(Authentication authentication, Model model) {
        if (authentication == null) {
            return "redirect:/login";
        }

        for (GrantedAuthority r : authentication.getAuthorities()) {
            if (r.getAuthority().equalsIgnoreCase("user")) {
                UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
                UserDTO userDTO = new UserDTO();
                model.addAttribute("user", userDTO.getUser(details.getUser()));
                return "userPage";
            }
        }
        return "redirect:/admin/all";
    }
}