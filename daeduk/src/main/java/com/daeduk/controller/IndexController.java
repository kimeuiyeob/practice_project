package com.daeduk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daeduk.dto.NoticeDto;
import com.daeduk.dto.ProductSealDto;
import com.daeduk.service.NoticeService;
import com.daeduk.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController extends SessionController {

    @Autowired
    private ProductService productService;

    @Autowired
    private NoticeService noticeService;

    /* 인덱스 */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /* 회사소개 */
    @GetMapping("/companyIntroduce")
    public String companyIntroduce() {
        return "companyIntroduce";
    }

    /* 제품 안내 */
    @GetMapping("/introduceProduct")
    public String introduceProduct(Model model) {

        List<ProductSealDto> saltSeal = productService.getProductSaltSeal();
        List<ProductSealDto> trackSeal = productService.getProductTrackSeal();

        model.addAttribute("saltSeal", saltSeal);
        model.addAttribute("trackSeal", trackSeal);

        return "introduceProduct";
    }

    /* 공지사항 */
    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }

    /* 공지사항 글 지우기 */
    @PostMapping("/notice/deleteComment")
    @ResponseBody
    public ResponseEntity<String> deleteComment(@RequestBody Map<String, Object> noticeId) {

        Long commentId = Long.valueOf(noticeId.get("id").toString());
        boolean result = noticeService.deleteCommentById(commentId);

        if (result) {
            return ResponseEntity.ok("삭제 완료");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 실패");
        }
    }

    /* 공지사항 목록 불러오기 */
    @GetMapping("/notice/getComment")
    public ResponseEntity<List<NoticeDto>> getComment() {
        try {
            List<NoticeDto> comments = noticeService.getAllComments();
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /* 공지사항 글 추가하기 */
    @PostMapping("/notice/addComment")
    @ResponseBody
    public ResponseEntity<String> addComment(@RequestBody Map<String, String> commentData) {
        String commentText = commentData.get("comment");
        boolean result = noticeService.addComment(commentText);

        if (result) {
            return ResponseEntity.ok("true");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("false");
        }
    }

    /* 제품 설비 */
    @GetMapping("/manufacture")
    public String manufacture() {
        return "manufacture";
    }

    /* 로그 아웃 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/daeduk")
    public String index(Model model) {

        String userEmail = (String) model.getAttribute("userEmail");
        if (userEmail == null) {
            return "redirect:/";
        }
        return "daeduk";
    }
}
