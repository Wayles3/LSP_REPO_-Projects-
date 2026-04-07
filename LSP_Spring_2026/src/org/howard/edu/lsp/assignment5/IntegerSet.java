package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a mathematical set of integers.
 * A set contains no duplicate elements and supports standard set operations.
 * All set operations (union, intersect, diff, complement) return new IntegerSet
 * objects and do not modify the original sets.
 *
 * <p>Usage example:</p>
 * <pre>
 *   IntegerSet set1 = new IntegerSet();
 *   set1.add(1);
 *   set1.add(2);
 *   IntegerSet set2 = new IntegerSet();
 *   set2.add(2);
 *   set2.add(3);
 *   System.out.println(set1.union(set2)); // [1, 2, 3]
 * </pre>
 *
 * @author Adewale Abodunde
 * @version 1.0
 */
public class IntegerSet {

    /** Internal storage for set elements. */
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Removes all elements from this set, leaving it empty.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns {@code true} if this set contains exactly the same elements
     * as the specified set (order does not matter).
     *
     * @param b the other IntegerSet to compare against
     * @return {@code true} if both sets have the same elements; {@code false} otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }
        // Every element in this set must be in b (sizes are equal, so b subset this => equal)
        for (int val : this.set) {
            if (!b.contains(val)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns {@code true} if this set contains the specified value.
     *
     * @param value the integer to search for
     * @return {@code true} if the value is present; {@code false} otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in this set.
     *
     * @return the largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in this set.
     *
     * @return the smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new RuntimeException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds the specified item to this set if it is not already present.
     * Duplicates are silently ignored.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from this set if it is present.
     * If the item is not in the set, this method does nothing.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements that appear in either
     * this set or the specified set (or both).
     *
     * <p>Example: [1, 2, 3] union [2, 3, 4] = [1, 2, 3, 4]</p>
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (int val : intSetb.set) {
            if (!result.set.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing only the elements common to both
     * this set and the specified set.
     *
     * <p>Example: [1, 2, 3] intersect [2, 3, 4] = [2, 3]</p>
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (intSetb.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing the elements in this set that are
     * not in the specified set (set difference: this − b).
     *
     * <p>Example: [1, 2, 3] diff [2, 3, 4] = [1]</p>
     *
     * @param intSetb the other IntegerSet to subtract
     * @return a new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (!intSetb.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing the elements in the specified set
     * that are not in this set (complement: b − this).
     *
     * <p>Example: Set1 = [1, 2, 3], Set2 = [2, 3, 4] → complement = [4]</p>
     *
     * @param intSetb the other IntegerSet serving as the universal reference
     * @return a new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : intSetb.set) {
            if (!this.contains(val)) {
                result.set.add(val);
            }
        }
        return result;
    }

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @return {@code true} if the set is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of this set in ascending sorted order.
     * Elements are enclosed in square brackets and separated by a comma and a
     * single space. An empty set is represented as {@code []}.
     *
     * <p>Examples:</p>
     * <ul>
     *   <li>{@code [1, 2, 3]}</li>
     *   <li>{@code []}</li>
     * </ul>
     *
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        if (set.isEmpty()) {
            return "[]";
        }
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < sorted.size(); i++) {
            sb.append(sorted.get(i));
            if (i < sorted.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}