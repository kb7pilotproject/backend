package org.scoula.carrotmarket.wishlist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;
import org.scoula.carrotmarket.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    final private WishlistService service;

    // 찜목록 상세 조회
    @GetMapping("/{wishlistId}")
    public void get(@RequestParam("wishlistId") Integer wishlistId,
                    Model model){
        model.addAttribute("wishlist", service.get(wishlistId));
    }

    // 등록 처리
    @PostMapping("/create/{wishlistId}")
    public String create(WishlistDTO wishlist){
        log.info("create : " + wishlist);
        service.create(wishlist);
        return "redirect:/wishlist/get?wishlistId=" + wishlist.getWishlistId();
    }

    // 수정
    @PostMapping("/update")
    public String update(WishlistDTO wishlist, RedirectAttributes ra){
        if(service.update(wishlist)){
            ra.addFlashAttribute("result","success");
        }
        return "redirect:/wishlist/get?wishlistId="
                + wishlist.getWishlistId();
    }

    // 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("wishlistId") Integer wishlistId, RedirectAttributes ra){
        if(service.delete(wishlistId)){
            ra.addFlashAttribute("result","success");
        }
        return "redirect:/";
    }

}
