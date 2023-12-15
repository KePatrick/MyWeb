package tw.patrick.tutor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ImgUpload
 */
@WebServlet("/ImgUpload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,  // 1 MB
    maxFileSize = 1024 * 1024 * 5,    // 5 MB
    maxRequestSize = 1024 * 1024 * 5 * 5  // 25 MB
)
public class ImgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        int width = Integer.parseInt(request.getParameter("width")) ;
		int height = Integer.parseInt(request.getParameter("height")) ;
		
        Part filePart = request.getPart("file");
        String fileName = getSubmittedFileName(filePart);

        //String outputImagePath = "C:\\Users\\USER\\Desktop\\新增資料夾 (5)\\" + fileName;
        String outputImagePath = "C:\\Users\\USER\\git\\MyWeb1\\src\\main\\webapp\\pic\\"+fileName;

        try (InputStream fileContent = filePart.getInputStream()) {
            BufferedImage originalImage = ImageIO.read(fileContent);

         // 指定寬高
            int targetWidth = width;
            int targetHeight = height;
            double targetWHratio = (double)targetWidth/(double)targetHeight;
         // 計算寬高比
            int originalWidth = originalImage.getWidth();
            int originalHeight = originalImage.getHeight();
            double originalWHratio = (double)originalWidth/(double)originalHeight;
         //處理新寬高
            int newWidth = originalWidth;
            int newHeight = originalHeight;
            if (targetWHratio>=originalWHratio) {
            	newWidth = (int) (originalWidth * ((double) targetHeight / originalHeight));
                newHeight = targetHeight;
			}else {
				newHeight = (int) (originalHeight * ((double) targetWidth / originalWidth));
				newWidth = targetWidth;
				
			}
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
            g2d.dispose();
            // 保存处理后的图像
            ImageIO.write(resizedImage, "jpg", new File(outputImagePath));
        }

        response.getWriter().append(fileName);
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
	}

}
