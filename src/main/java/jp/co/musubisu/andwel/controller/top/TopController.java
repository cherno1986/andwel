package jp.co.musubisu.andwel.controller.top;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {

	/** ロガー **/
	private static final Logger log = LoggerFactory.getLogger(TopController.class);

    @RequestMapping(value = "/top/admin")
    public String index(Model model) {
    	log.info("トップ処理開始（管理）");


    	log.info("トップ処理終了（管理）");
        return "top/admin/index";
    }
}
