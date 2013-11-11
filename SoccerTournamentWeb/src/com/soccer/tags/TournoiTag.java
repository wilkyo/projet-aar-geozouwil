package com.soccer.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.soccer.valueobjects.VORencontreLight;
import com.soccer.valueobjects.VOTournoi;

public class TournoiTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VOTournoi tournoi;

	/**
	 * @return the tournoi
	 */
	public VOTournoi getTournoi() {
		return tournoi;
	}

	/**
	 * @param tournoi
	 *            the tournoi to set
	 */
	public void setTournoi(VOTournoi tournoi) {
		this.tournoi = tournoi;
	}

	public int doEndTag() throws JspException {
		try {
			if (Integer.lowestOneBit(tournoi.getRencontres().size() + 1) != tournoi
					.getRencontres().size() + 1)
				throw new JspException("Bad size: "
						+ tournoi.getRencontres().size());
			pageContext.getOut().write(
					"<div class=\"bloc_tournoi\">" + "<h2>" + tournoi.getNom()
							+ "</h2>");
			int cpt = 1;
			for (VORencontreLight r : tournoi.getRencontres()) {
				pageContext.getOut().write("<div class=\"bloc_rencontre\">");
				if (r.isFake()) {
					pageContext.getOut().write("En attente");
				} else {
					pageContext.getOut().write(
							r.getHotes() + " VS " + r.getVisiteurs() + "<br />"
									+ r.getScoreHotes() + " - "
									+ r.getScoreVisiteurs() + "<br />"
									+ r.getDateRencontre());
				}
				pageContext.getOut().write("</div>");
				cpt++;
				if (Integer.lowestOneBit(cpt) == cpt) {
					pageContext.getOut().write("<br />");
				}
			}
			pageContext.getOut().write("</div>");
		} catch (IOException e) {
			throw new JspException("ERREUR BALIIIIIIIIISE");
		}
		return TournoiTag.EVAL_PAGE;
	}
}
