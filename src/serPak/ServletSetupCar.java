package serPak;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPak.DAO;
import devPak.GearList;

/**
 * Servlet implementation class ServletSetupCar
 */
@WebServlet("/ServletSetupCar")
public class ServletSetupCar extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSetupCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		
		if (idString != null && idString.length() > 0) {
			request.setAttribute("msg", idString);
			request.getRequestDispatcher("view/test_setup_car.jsp").forward(request, response);
		} else {
			response.sendRedirect("view/test_insert.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("carId");
		String[] aGear = request.getParameterValues("gear");
		
		ArrayList<GearList> alGearList = new ArrayList<GearList>();
		GearList gl = null;
		int idCar = Integer.parseInt(idString);
		
		if(aGear != null && aGear.length > 0)
			for (String gear : aGear) {
				gl = new GearList(idCar, Integer.parseInt(gear));
				alGearList.add(gl);
			}
		DAO dao = new DAO();
		dao.setupGear(alGearList, idCar);
		response.sendRedirect("view/test_insert.jsp");
	}

}
