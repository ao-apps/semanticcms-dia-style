/*
 * semanticcms-dia-style - Default style for Java API for embedding Dia-based diagrams in web pages.
 * Copyright (C) 2016, 2017, 2020  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-dia-style.
 *
 * semanticcms-dia-style is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-dia-style is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-dia-style.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.dia.style;

import com.aoindustries.web.resources.registry.Style;
import com.aoindustries.web.resources.servlet.RegistryEE;
import com.semanticcms.core.renderer.html.HtmlRenderer;
import com.semanticcms.dia.model.Dia;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the styles for diagrams in RegistryEE and HtmlRenderer.")
public class DiaStyle implements ServletContextListener {

	public static final Style SEMANTICCMS_DIA = new Style("/semanticcms-dia-style/semanticcms-dia.css");

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();

		// Add our CSS file
		RegistryEE.get(servletContext).global.styles.add(SEMANTICCMS_DIA);

		HtmlRenderer htmlRenderer = HtmlRenderer.getInstance(servletContext);
		// Add link CSS class
		htmlRenderer.addLinkCssClass(Dia.class, "semanticcms-dia-link");
		// Add list item CSS class
		htmlRenderer.addListItemCssClass(Dia.class, "semanticcms-dia-list-item");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}
}
