package org.aurifa.demo.strutter.helper;

/**
 * Replicator. Interface.
 *
 * @author Rene Gielen
 */

public interface Replicator {

    <T> T deepCopy( T origin );
}
