package com.yang.community.controller;

import com.yang.community.entity.DiscussPost;
import com.yang.community.entity.Page;
import com.yang.community.entity.User;
import com.yang.community.service.DiscussPostService;
import com.yang.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ywg
 * @date 2022/1/25 16:15
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService postService;

    @Autowired
    private UserService userService;

    @GetMapping({"/","/index"})
    public String getIndexPage(Model model, Page page,){

        //方法调用钱，SpringMVC会自动实例化Model和Page,并将Page注入Model。
        //所以，在thymeleaf中可以直接访问Page对象中的数据.
        page.setRows(postService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> postList = postService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts = new ArrayList<>();
        if(postList != null){
            for (DiscussPost post : postList) {
                Map<String,Object> map = new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount",likeCount);

                discussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts",discussPosts);
        model.addAttribute("orderMode",orderMode);
        return "/index";
    }

    @GetMapping("/error")
    public String getErrorPage(){
        return "/error/500";
    }

    @GetMapping("/denied")
    public String getDeniedPage(){
        return "/error/404";
    }
}

