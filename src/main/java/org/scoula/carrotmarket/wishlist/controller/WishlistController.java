package org.scoula.carrotmarket.wishlist.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.carrotmarket.wishlist.dto.WishlistDTO;
import org.scoula.carrotmarket.wishlist.service.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService service;

    // 내가 찜한 상품 목록 조회
    @GetMapping("/list")
    public void list(@RequestParam("userId") Integer userId,
                     Model model) {

        model.addAttribute("list", service.getListByUser(userId));
    }

    // 찜 상세 조회
    @GetMapping("/get")
    public void get(@RequestParam("wishlistId") Integer wishlistId,
                    Model model) {

        model.addAttribute("wishlist", service.get(wishlistId));
    }

    // 등록 화면
    @GetMapping("/create")
    public void create() {
        log.info("create page");
    }

    // 찜 등록
    @PostMapping("/create")
    public String create(WishlistDTO wishlist) {

        log.info("create : " + wishlist);

        service.create(wishlist);

        return "redirect:/wishlist/list?userId=" + wishlist.getUserId();
    }

    // 수정
    @PostMapping("/update")
    public String update(WishlistDTO wishlist,
                         RedirectAttributes ra) {

        if (service.update(wishlist)) {
            ra.addFlashAttribute("result", "success");
        }

        return "redirect:/wishlist/get?wishlistId=" + wishlist.getWishlistId();
    }

    // 삭제
    @PostMapping("/delete")
    public String delete(@RequestParam("wishlistId") Integer wishlistId,
                         @RequestParam("userId") Integer userId,
                         RedirectAttributes ra) {

        if (service.delete(wishlistId)) {
            ra.addFlashAttribute("result", "success");
        }

        return "redirect:/wishlist/list?userId=" + userId;
    }
}