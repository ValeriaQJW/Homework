package com.swufe.javaee.request_response;

import javax.imageio.ImageIO;
import javax.jnlp.FileContents;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig

public class ImageuploadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        filePart.write("C:\\upload");}

    }