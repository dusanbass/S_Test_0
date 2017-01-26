package serPak;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPak.DAO;
import devPak.Gear;

/**
 * Servlet implementation class ServletInsertGear
 */
@WebServlet("/ServletInsertGear")
public class ServletInsertGear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsertGear() {
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
		String name = request.getParameter("name");
		if (name != null && name.length() > 0) {
			Gear g = new Gear(name);
			DAO dao = new DAO();
			dao.insertGear(g);
			request.setAttribute("msg", "Gear inserted");
			request.getRequestDispatcher("view/test_insert_gear.jsp").forward(request, response);			
		} else{
			request.setAttribute("msg", "Enter gear name!");
			request.getRequestDispatcher("view/test_insert_gear.jsp").forward(request, response);
		}
	}

}
