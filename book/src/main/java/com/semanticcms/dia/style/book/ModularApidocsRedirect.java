/*
 * semanticcms-dia-style - Default style for Java API for embedding Dia-based diagrams in web pages.
 * Copyright (C) 2021, 2022  AO Industries, Inc.
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
 * along with semanticcms-dia-style.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.semanticcms.dia.style.book;

import com.aoapps.net.URIParametersUtils;
import com.aoapps.servlet.http.HttpServletUtil;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dia/style/apidocs/com/*")
public class ModularApidocsRedirect extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpServletUtil.sendRedirect(
			HttpServletResponse.SC_MOVED_PERMANENTLY, req, resp,
			"/dia/style/apidocs/com.semanticcms.dia.style/com" + Objects.toString(req.getPathInfo(), ""),
			URIParametersUtils.of(req.getQueryString()), true, false
		);
	}
}
