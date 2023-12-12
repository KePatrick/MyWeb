package tw.patrick.tutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.patrick.utils.GetHtml;

@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {

    public static String getHtmlContent(ServletContext context, String filePath) {
        try (InputStream inputStream = context.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            

            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file.";
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
        ServletContext context = getServletContext();
        String filePath = "";
        if(type.equals("0")) {
        	filePath = "/websource/blockStyle/block0.html";
        }
    	else if(type.equals("1")) {
    		filePath = "/websource/blockStyle/block1.html";
    	}
    	
    	else if(type.equals("2")) {
    		filePath = "/websource/blockStyle/block2.html";
    		}
    	
    	else if(type.equals("3")) {
    		filePath = "/websource/blockStyle/block3.html";
    		}

        String htmlContent = getHtmlContent(context, filePath);

        
        response.getWriter().append(htmlContent);
    }
}

