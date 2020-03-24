package cn.chen.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/validationServlet")
public class validationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;

        // create an object image in buffer memory
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // modify image
        Graphics g = img.getGraphics(); //get the pen
        g.setColor(Color.pink);//set color of pen
        g.fillRect(0, 0, width, height);

        g.setColor(Color.blue);
        g.drawRect(0, 0, width-1, height-1);

        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        for(int i = 0; i < 4; i++)
        {
            int index = r.nextInt(str.length());
            char ch = str.charAt(index);
            g.drawString(ch+"", width/5*i, height/2);
        }

        // add some noisy lines in img
        g.setColor(Color.green);

        for(int i = 0; i < 10; i++)
        {
            int x1 = r.nextInt(width);
            int x2 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int y2 = r.nextInt(height);

            g.drawLine(x1, y1, x2, y2);
        }
//        g.drawString("A", 20, 25);
//        g.drawString("b", 40, 25);
//        g.drawString("v", 60, 25);
//        g.drawString("W", 80, 25);

        //show the image to page
        ImageIO.write(img, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
