/*
 * Copyright (c) 2013 GraphAware
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

package com.graphaware.description.predicate;

import org.apache.log4j.Logger;

/**
 * A {@link com.graphaware.description.predicate.Predicate} comparing beta (the property value) to the
 * predefined value. Only compatible with numerical values (in which case number comparison applies), and Strings and
 * chars, in which case alphabetical comparison applies. An exception will be thrown if trying to instantiate this
 * predicate using an array or a non-numerical non-char value.
 */
abstract class ComparablePredicate extends ValueBasedPredicate<Comparable> {

    private static final Logger LOG = Logger.getLogger(ComparablePredicate.class);

    protected ComparablePredicate(Comparable value) {
        super(value);

        if (!isComparable(value)) {
            throw new IllegalArgumentException("Value for the GreaterThan predicate must be comparable, i.e. a numerical" +
                    " value, String, or char");
        }
    }

    protected final boolean isLessThan(Object value) {
        if (!isComparable(value)) {
            return false;
        }

        try {
            return getValue().compareTo(value) < 0;
        } catch (ClassCastException e) {
            LOG.warn(String.valueOf(getValue()) + " cannot be compared to " + String.valueOf(value));
            return false;
        }
    }

    protected final boolean isGreaterThan(Object value) {
        if (!isComparable(value)) {
            return false;
        }

        try {
            return getValue().compareTo(value) > 0;
        } catch (ClassCastException e) {
            LOG.warn(String.valueOf(getValue()) + " cannot be compared to " + String.valueOf(value));
            return false;
        }
    }

    protected final boolean isComparable(Object value) {
        return value instanceof Comparable;
    }
}
