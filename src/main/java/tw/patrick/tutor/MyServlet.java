package tw.patrick.tutor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.patrick.utils.GetHtml;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if (type.equals("0")) {
			System.out.println("type0");

			out.append(GetHtml.block0Html());
		} else if (type.equals("1")) {
			System.out.println("type1");

			out.append(GetHtml.block1Html());
		}

		else if (type.equals("2")) {
			System.out.println("type2");

			out.append(GetHtml.block2Html());
		}

		else if (type.equals("3")) {
			System.out.println("type3");

			out.append(GetHtml.block3Html());
		}

	}

}
