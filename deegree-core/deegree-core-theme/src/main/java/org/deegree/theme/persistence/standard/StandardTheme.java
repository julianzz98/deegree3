/*----------------------------------------------------------------------------
 This file is part of deegree, http://deegree.org/
 Copyright (C) 2001-2010 by:
 - Department of Geography, University of Bonn -
 and
 - lat/lon GmbH -

 This library is free software; you can redistribute it and/or modify it under
 the terms of the GNU Lesser General Public License as published by the Free
 Software Foundation; either version 2.1 of the License, or (at your option)
 any later version.
 This library is distributed in the hope that it will be useful, but WITHOUT
 ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 details.
 You should have received a copy of the GNU Lesser General Public License
 along with this library; if not, write to the Free Software Foundation, Inc.,
 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 Contact information:

 lat/lon GmbH
 Aennchenstr. 19, 53177 Bonn
 Germany
 http://lat-lon.de/

 Department of Geography, University of Bonn
 Prof. Dr. Klaus Greve
 Postfach 1147, 53001 Bonn
 Germany
 http://www.geographie.uni-bonn.de/deegree/

 Occam Labs Schmitz & Schneider GbR
 Godesberger Allee 139, 53175 Bonn
 Germany
 http://www.occamlabs.de/

 e-mail: info@deegree.org
 ----------------------------------------------------------------------------*/
package org.deegree.theme.persistence.standard;

import static org.deegree.commons.utils.StringUtils.repeat;

import java.util.List;

import org.deegree.layer.Layer;
import org.deegree.layer.metadata.LayerMetadata;
import org.deegree.theme.Theme;
import org.deegree.workspace.Resource;
import org.deegree.workspace.ResourceMetadata;

/**
 * Standard theme implementation.
 *
 * @author <a href="mailto:schmitz@occamlabs.de">Andreas Schmitz</a>
 * @since 3.4
 */
public class StandardTheme implements Theme {

	private final List<Theme> themes;

	private final List<Layer> layers;

	private LayerMetadata metadata;

	private ResourceMetadata<Theme> resourceMetadata;

	public StandardTheme(LayerMetadata metadata, List<Theme> themes, List<Layer> layers,
			ResourceMetadata<Theme> resourceMetadata) {
		this.metadata = metadata;
		this.themes = themes;
		this.layers = layers;
		this.resourceMetadata = resourceMetadata;
	}

	@Override
	public void init() {
		// nothing to do
	}

	@Override
	public void destroy() {
		// nothing to do
	}

	@Override
	public LayerMetadata getLayerMetadata() {
		return metadata;
	}

	@Override
	public List<Layer> getLayers() {
		return layers;
	}

	@Override
	public List<Theme> getThemes() {
		return themes;
	}

	public String toString(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(repeat(indent, "  "));
		sb.append(" - ");
		sb.append(metadata.getName());
		sb.append(" ");
		sb.append(layers.size());
		sb.append(" layers\n");
		indent += 2;
		for (Theme t : themes) {
			if (t instanceof StandardTheme) {
				sb.append(((StandardTheme) t).toString(indent));
			}
			else {
				sb.append(t);
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return toString(0);
	}

	@Override
	public ResourceMetadata<? extends Resource> getMetadata() {
		return resourceMetadata;
	}

}
