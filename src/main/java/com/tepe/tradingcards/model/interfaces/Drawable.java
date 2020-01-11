package com.tepe.tradingcards.model.interfaces;

import java.util.List;

public interface Drawable {
    /**
     * Removes and returns top {@code Playable} in this {@code Drawable}
     * @return {@code Playable}
     */
    Playable draw();

    /**
     * Prints all {@code Playable}s in this {@code Drawable}
     *
     */
    void print();

    /**
     * Returns size of the {@code Playable}s in this {@code Drawable}
     * @return int
     */
    int getSize();

    /**
     * Adds given {@code Playable} to this {@code Drawable}
     * @param playable {@code Playable} object to add
     */
    void add(Playable playable);

    /**
     * Adds all given {@code Playable}s to this {@code Drawable}
     * @param playables List of {@code Playable}s
     */
    void addAll(List<Playable> playables);

    /**
     * Checks if this {@code Drawable} is empty
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Discards last {@code Playable} in this {@code Drawable}
     * @return Discarded {@code Playable}
     */
    Playable discardLast();

    /**
     * Checks if the size of this {@code Drawable} is bigger than {@code maxSize}
     * @param maxSize Max allowed size for this {@code Drawable}
     * @return boolean
     */
    boolean isOverloaded(int maxSize);

    /**
     * Returns the {@code Playable} with the given id. Returns null if there is no such playable in this {@code Drawable}.
     * @param id ID of the {@code Playable}
     * @return {@code Playable}
     */
    Playable findById(int id);

    /**
     * Returns the {@code Playable} with the given name. Returns null if there is no such playable in this {@code Drawable}.
     * @param name Name of the {@code Playable}
     * @return {@code Playable}
     */
    Playable findByName(String name);

    boolean containsPlayableForMana(int mana);

    void discard(Playable playable);

}
