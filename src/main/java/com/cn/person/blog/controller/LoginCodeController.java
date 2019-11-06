package com.cn.person.blog.controller;

import com.cn.person.blog.constant.CommonConstant;
import com.cn.person.blog.entity.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author moment
 * @date 2019/10/24 9:39
 * @describe
 */
@CrossOrigin
@Controller
public class LoginCodeController extends BaseController {
    /**
     *
     */
    @ResponseBody
    @RequestMapping(value = "/captcha.jpg")
    public void randomImg(HttpServletResponse response) {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 在内存中创建图象
        int width = 80, height = 35;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 生成随机类
        Random random = new Random();
        // 设定背景色
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);
        // 设定字体
        g.setFont(new Font("Arial", Font.PLAIN, 24));
        // 取随机产生的认证码(6位数字)
        String sRand = "";
        String s = "012345678901234567890123456789012345678901234567890123456789";
        for (int i = 0; i < 4; i++) {
            char rand = s.charAt(random.nextInt(s.length()));
            sRand += rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(rand), 13 * i + 12, 27);
        }
        g.drawOval(5, 10, 60, 15);
        // 图象生效
        g.dispose();
        setSessionAttribute(CommonConstant.CHECK_CODE, sRand);
        ServletOutputStream output;
        try {
            output = response.getOutputStream();
            // 输出图象到页面
            ImageIO.write(image, "JPEG", output);
        } catch (IOException e) {

        }
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


}
