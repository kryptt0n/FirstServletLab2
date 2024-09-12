

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SocketFormServlet
 */

public class SocketFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocketFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("socket");
		int cost;
		switch (type) {
		case "typeA":
			cost = 1;
			break;
		case "typeB":
			cost = 3;
			break;
		case "typeC":
			cost = 7;
			break;
		default:
			cost = 0;
		}
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		if (quantity < 0) {
			response.getWriter().append("Quantity cannot be less than 0");
		} else {
			int summary = cost * quantity;
			
			response.getWriter()
			.append("Dear, " + request.getParameter("name"))
			.append(" with email: " + request.getParameter("email") + "\n")
			.append("Your total amount is: ")
			.append(String.valueOf(summary));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("socket"));
		System.out.println(request.getParameter("quantity"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		doGet(request, response);
	}

}
