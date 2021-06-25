package com.swufe.javaee.request_response;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.TriangleAvatar;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "AvatarServlet", value = "/avatar")
public class AvatarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Avatar avatar = TriangleAvatar.newAvatarBuilder().build();

        BufferedImage image = avatar.create(123456L);

        ImageIO.write(image, "png", response.getOutputStream());
    }
}
