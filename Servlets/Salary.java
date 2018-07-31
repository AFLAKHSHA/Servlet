
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Salary
 */
@WebServlet("/Salary")
public class Salary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String Name = request.getParameter("Name");
		Integer Salary = Integer.parseInt(request.getParameter("Salary"));
		String Grade = request.getParameter("Grade");

		double bonus = 0;
		double tax;

		if (Salary > 100000 && Grade.equals("A")) {
			bonus = 0.05 * Salary;
		}
		if (Salary >= 50000 || Salary >= 100000 && Grade.equals("B")) {
			bonus = 0.07 * Salary;
		}
		if (Salary <= 50000 && Grade.equals("C")) {
			bonus = 0.20 * Salary;
		}
		tax = 0.25 * Salary;

		double NetSalary = Salary + bonus - tax;

		pw.println("Employee Name :" + Name);
		pw.println("Basic Salary :" + Salary);
		pw.println("Bonus :" + bonus);
		pw.println("Tax :" + tax);
		pw.println(" NetSalary");

		String str = "table border=1>" + "<tr><th>Name</th>" + "<th>Salary</th>" + "<th>bonus</th>" + "<th>tax</th>"
				+ "<th>NetSalary</th>" + "</tr>";

		String str2 = "<tr>" + "<td>" + Name + "</td>" + "<td>" + Salary + "</td>" + "<td>" + bonus + "</td>" + "<td>"
				+ tax + "</td>" + "<td>" + NetSalary + "</td>" + "</tr>";

		pw.println("str1 + str2");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
