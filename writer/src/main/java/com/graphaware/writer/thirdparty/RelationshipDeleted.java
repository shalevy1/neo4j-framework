/*
 * Copyright (c) 2015 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.writer.thirdparty;

import com.graphaware.common.representation.RelationshipRepresentation;
import org.neo4j.graphdb.Relationship;

/**
 * {@link WriteOperation} representing a {@link Relationship} being deleted.
 */
public class RelationshipDeleted extends CreateOrDelete<RelationshipRepresentation, Relationship> {

    /**
     * Create the operation.
     *
     * @param deletedRelationship representation of the deleted relationship. Must not be <code>null</code>.
     */
    public RelationshipDeleted(RelationshipRepresentation deletedRelationship) {
        super(deletedRelationship);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperationType getType() {
        return OperationType.RELATIONSHIP_DELETED;
    }
}
