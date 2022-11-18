package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

import mantenimientos.GestionModCompra;
import model.ModCompra;

public class CboModCompra extends TagSupport{
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			ArrayList<ModCompra> lstModCompra = new GestionModCompra().listaModCompra();
			for (ModCompra m : lstModCompra) {
				out.println(String.format("<option value='%s'>%s</option>", m.getCodmod(), m.getModalidad()));
			}
		} catch (IOException e) {
			System.out.println("Error en la etiqueta CboModCompra: " + e.getMessage());
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException{
		return EVAL_PAGE;
	}
}
