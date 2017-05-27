

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadSevlet
 */
@WebServlet(name = "UploadSevlet", urlPatterns = { "/UploadSevlet" })
public class UploadSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Retrieve u = new Retrieve();
		u.upload(Integer.parseInt(request.getParameter("id")),request.getParameter("object"),request.getParameter("val"));
	}

}
