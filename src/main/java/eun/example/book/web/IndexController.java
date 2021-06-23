package eun.example.book.web;

import eun.example.book.service.posts.PostsService;
import eun.example.book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsservice;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsservice.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsservice.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
