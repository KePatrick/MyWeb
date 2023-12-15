package tw.patrick.tutor;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


@WebServlet("/ImgResize")
public class ImgResize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		int width = Integer.parseInt(request.getParameter("width")) ;
		int height = Integer.parseInt(request.getParameter("height")) ;
		
		
		
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("选择图像文件");
        fileChooser.setFileFilter(new FileNameExtensionFilter("图像文件 (*.jpg, *.png, *.gif)", "jpg", "png", "gif"));
        
        
        int result = fileChooser.showOpenDialog(null);
        
        // 如果有選擇
        if (result == JFileChooser.APPROVE_OPTION) {
           
            File selectedFile = fileChooser.getSelectedFile();
            String filename = selectedFile.getName();
            // 指定输出文件路徑
            String outputImagePath = "C:\\Users\\USER\\git\\MyWeb1\\src\\main\\webapp\\pic\\"+filename;

            // 指定寬高
            int targetWidth = width;
            int targetHeight = height;
            double targetWHratio = (double)targetWidth/(double)targetHeight;

            try {
                // 讀取原始圖像
                BufferedImage originalImage = ImageIO.read(selectedFile);
                
                // 計算寬高比
                int originalWidth = originalImage.getWidth();
                int originalHeight = originalImage.getHeight();
                double originalWHratio = (double)originalWidth/(double)originalHeight;
                System.out.println("原寬"+originalWidth);
                System.out.println("原高"+originalHeight);
                System.out.println("原寬高比"+originalWHratio);
                int newWidth = originalWidth;
                int newHeight = originalHeight;
                if (targetWHratio>=originalWHratio) {
                	newWidth = (int) (originalWidth * ((double) targetHeight / originalHeight));
                    newHeight = targetHeight;
				}else {
					newHeight = (int) (originalHeight * ((double) targetWidth / originalWidth));
					newWidth = targetWidth;
					
				}
                
                
//                int newWidth = (int) (originalWidth * ((double) targetHeight / originalHeight));
//                int newHeight = targetHeight;

                // 製造bufferimage
                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
                g2d.dispose();

                // 匯出圖片
                ImageIO.write(resizedImage, "jpg", new File(outputImagePath));

                System.out.println("調整成功，" +"寬:"+newWidth+" 高:"+newHeight +"，已保存到：" + outputImagePath);
                response.getWriter().append(outputImagePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
}
	