/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import dao.ClickDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;

/**
 *
 * @author Enrique
 */
@WebServlet(name = "Grafica", urlPatterns = {"/Grafica"})
public class Grafica extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClickDAO dao = new ClickDAO();
        JSONArray datos = dao.getDataMain();
        PrintWriter out = response.getWriter();
        String clase;
        int clicks;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Bubble Chart</title>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,600,200italic,600italic&subset=latin,vietnamese' rel='stylesheet' type='text/css'>");
        out.println("<script src=\"js/jquery.min.js\"></script>");
        out.println("<script src=\"js/d3.min.js\"></script>");
        out.println("<script src=\"js/d3-transform.js\"></script>");
        out.println("<script src=\"js/extarray.js\"></script>");
        out.println("<script src=\"js/misc.js\"></script>");
        out.println("<script src=\"js/micro-observer.js\"></script>");
        out.println("<script src=\"js/microplugin.js\"></script>");
        out.println("<script src=\"js/bubble-chart.js\"></script>");
        out.println("<script src=\"js/central-click.js\"></script>");
        out.println("<script src=\"js/lines.js\"></script>");
        out.println("<script>");
        out.println("$(document).ready(function () {");
        out.println("var bubbleChart = new d3.svg.BubbleChart({");
        out.println("supportResponsive: true,");
        //container: => use @default
        out.println("size: 600,");
        //viewBoxSize: => use @default
        out.println("innerRadius: 600 / 3.5,");
        //outerRadius: => use @default
        out.println("radiusMin: 50,");
        //radiusMax: use @default
        //intersectDelta: use @default
        //intersectInc: use @default
        //circleColor: use @default
        out.println("data: {");
        out.println("items: [");
        //*****
        for (int i = 0; i < 9; i++) {
            clicks = datos.getJSONObject(i).getInt("clicks");
            clase = datos.getJSONObject(i).getJSONObject("elemento").getString("clase");
            out.println("{text: \"" + clase + "\", count: \"" + clicks + "\"},");
            System.out.println("{text: \"" + clase + "\", count: \"" + clicks + "\"},");
        }
        //*****
        out.println("],");
        out.println("eval: function (item) {return item.count;},");
        out.println("classed: function (item) {return item.text.split(\" \").join(\"\");}");
        out.println("},");
        out.println("plugins: [");
        out.println("{");
        out.println("name: \"central-click\",");
        out.println("options: {");
        out.println("text: \"(See more detail)\",");
        out.println("style: {");
        out.println("\"font-size\": \"12px\",");
        out.println("\"font-style\": \"italic\",");
        out.println("\"font-family\": \"Source Sans Pro, sans-\",");
        //"font-weight": "700",
        out.println("\"text-anchor\": \"middle\",");
        out.println("\"fill\": \"white\"");
        out.println("},");
        out.println("attr: {dy: \"65px\"},");
        out.println("centralClick: function() {");
        //out.println("alert(\"Here is more details!!\");");
        out.println("}");
        out.println("}");
        out.println("},");
        out.println("{");
        out.println("name: \"lines\",");
        out.println("options: {");
        out.println("format: [");
        out.println("{// Line #0");
        out.println("textField: \"count\",");
        out.println("classed: {count: true},");
        out.println("style: {");
        out.println("\"font-size\": \"28px\",");
        out.println("\"font-family\": \"Source Sans Pro, sans-serif\",");
        out.println("\"text-anchor\": \"middle\",");
        out.println("fill: \"white\"");
        out.println("},");
        out.println("attr: {");
        out.println("dy: \"0px\",");
        out.println("x: function (d) {return d.cx;},");
        out.println("y: function (d) {return d.cy;}");
        out.println("}");
        out.println("},");
        out.println("{// Line #1");
        out.println("textField: \"text\",");
        out.println("classed: {text: true},");
        out.println("style: {");
        out.println("\"font-size\": \"14px\",");
        out.println("\"font-family\": \"Source Sans Pro, sans-serif\",");
        out.println("\"text-anchor\": \"middle\",");
        out.println("fill: \"white\"");
        out.println("},");
        out.println("attr: {");
        out.println("dy: \"20px\",");
        out.println("x: function (d) {return d.cx;},");
        out.println("y: function (d) {return d.cy;}");
        out.println("}");
        out.println("}");
        out.println("],");
        out.println("centralFormat: [");
        out.println("{// Line #0");
        out.println("style: {\"font-size\": \"50px\"},");
        out.println("attr: {}");
        out.println("},");
        out.println("{// Line #1");
        out.println("style: {\"font-size\": \"30px\"},");
        out.println("attr: {dy: \"40px\"}");
        out.println("}");
        out.println("]");
        out.println("}");
        out.println("}]");
        out.println("});");
        out.println("});");
        out.println("</script>");
        out.println("<style>");
        out.println(".bubbleChart {");
        out.println("min-width: 100px;");
        out.println("max-width: 700px;");
        out.println("height: 700px;");
        out.println("margin: 0 auto;");
        out.println("}");
        out.println(".bubbleChart svg{");
        out.println("background: #000000;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body style=\"background: #000000\">");
        out.println("<div class=\"bubbleChart\"/>");
        out.println("</body>");
        out.println("</html>");

        /*
        //json.put("resultado", true);
        response.setContentType("application/json utf-8");
        out.print(datos);
        for (int i = 0; i < datos.length(); i++) {
        System.out.println(datos);
        //out.print(datos.get(i));
        }*/
        destroy();
    }
}
