package serPak;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPak.DAO;
import devPak.Car;

/**
 * Servlet implementation class ServletInsertCar
 */
@WebServlet("/ServletInsertCar")
public class ServletInsertCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String make = request.getParameter("make");
		String type = request.getParameter("type");
		
		if (make != null && make.length() > 0 && type != null && type.length() > 0) {
			DAO dao = new DAO();
			Car c = new Car(make, type);
			dao.insertCar(c);
			request.setAttribute("msg", "Car inserted!");
			request.getRequestDispatcher("view/test_insert.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Type all fields in!!");
			request.getRequestDispatcher("view/test_insert.jsp").forward(request, response);
		}
	}

}
