/*
// $Id$
// This software is subject to the terms of the Common Public License
// Agreement, available at the following URL:
// http://www.opensource.org/licenses/cpl.html.
// Copyright (C) 2007-2007 Julian Hyde
// All Rights Reserved.
// You must accept the terms of that agreement to use this software.
*/
package org.olap4j.mdx;

import org.olap4j.metadata.Cube;
import org.olap4j.type.CubeType;
import org.olap4j.type.Type;

/**
 * Usage of a {@link org.olap4j.metadata.Cube} as an expression in an MDX
 * parse tree.
 *
 * @author jhyde
 * @version $Id$
 * @since Jun 4, 2007
 */
public class CubeNode implements ParseTreeNode {
    private final ParseRegion region;
    private final Cube cube;

    /**
     * Creates a CubeNode.
     *
     * @param region Region of source code
     * @param cube Cube
     */
    public CubeNode(
        ParseRegion region,
        Cube cube)
    {
        this.region = region;
        this.cube = cube;
    }

    public ParseRegion getRegion() {
        return region;
    }

    /**
     * Returns the Cube used in this expression.
     *
     * @return cube used in this expression
     */
    public Cube getCube() {
        return cube;
    }

    public <T> T accept(ParseTreeVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Type getType() {
        return new CubeType(cube);
    }

    public void unparse(ParseTreeWriter writer) {
        writer.getPrintWriter().print(cube.getUniqueName());
    }

    public String toString() {
        return cube.getUniqueName();
    }
}

// End CubeNode.java