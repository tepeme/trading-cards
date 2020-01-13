package com.tepe.tradingcards.model;

import com.tepe.tradingcards.model.interfaces.Drawable;
import com.tepe.tradingcards.model.interfaces.Playable;
import com.tepe.tradingcards.util.IOUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deck implements Drawable {
    private List<Playable> playables;

    public Deck(List<Playable> playables) {
        this.playables = playables;
    }

    public List<Playable> getPlayables() {
        return this.playables;
    }

    /**
     * Returns size of the {@code Playable}s in this {@code Drawable}
     * @return int
     */
    @Override
    public int getSize() {
        if (Objects.isNull(this.playables)) {
            return 0;
        }
        return this.playables.size();
    }

    /**
     * Adds given {@code Playable} to this {@code Drawable}
     * @param playable
     */
    @Override
    public void add(Playable playable) {
        if (Objects.isNull(playables)) {
            playables = new ArrayList<>();
        }
        playables.add(playable);
    }

    /**
     * Adds all given {@code Playable}s to this {@code Drawable}
     * @param playables List of {@code Playable}s
     */
    @Override
    public void addAll(List<Playable> playables) {
        if (Objects.isNull(this.playables)) {
            this.playables = new ArrayList<>();
        }
        this.playables.addAll(playables);
    }

    /**
     * Checks if this {@code Drawable} is empty
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Removes and returns top {@code Playable} in this {@code Drawable}
     * @param
     * @return
     */
    @Override
    public Playable draw() {
        if (hasEnoughPlayable(1)) {
            return this.playables.remove(0);
        }
        IOUtil.getInstance().print("Deck is empty! Can not draw.");
        return null;
    }

    /**
     * Prints all {@code Playable}s in this {@code Drawable}
     *
     */
    public void print() {
        if (!Objects.isNull(playables)) {
            for (int i = 0; i < this.playables.size(); i++) {
                this.playables.get(i).print();
                if (i != this.playables.size() - 1) {
                    IOUtil.getInstance().printBreak();
                }
            }
        }
    }


    /**
     * Checks if this has enough playables
     * @param size
     * @return
     */
    private boolean hasEnoughPlayable(int size) {
        return getSize() >= size;
    }

    /**
     * Discards last {@code Playable} in this {@code Drawable}
     * @return
     */
    @Override
    public Playable discardLast() {
        return this.playables.remove(getSize()-1);
    }

    /**
     * Checks if the size of this {@code Drawable} is bigger than {@code maxSize}
     * @param maxSize
     * @return
     */
    @Override
    public boolean isOverloaded(int maxSize) {
        return getSize() > maxSize;
    }

    /**
     * Returns the {@code Playable} with the given id. Returns null if there is no such playable in this {@code Drawable}.
     * @param id ID of the {@code Playable}
     * @return {@code Playable}
     */
    @Override
    public Playable findById(int id) {
        for (Playable playable : playables) {
            if (id == playable.getId()) {
                return playable;
            }
        }
        return null;
    }

    /**
     * Returns the {@code Playable} with the given name. Returns null if there is no such playable in this {@code Drawable}.
     * @param name Name of the {@code Playable}
     * @return {@code Playable}
     */
    @Override
    public Playable findByName(String name) {
        for (Playable playable : playables) {
            if (name.equals(playable.getName())) {
                return playable;
            }
        }
        return null;
    }

    @Override
    public boolean containsPlayableForMana(int mana) {
        if (Objects.isNull(this.playables)) {
            return false;
        }
        return this.getPlayables().stream().anyMatch(playable -> playable.getManaCost() <= mana);
    }

    @Override
    public void discard(Playable playable) {
        if (Objects.isNull(this.playables)) {
            return;
        }
        this.playables.remove(playable);
    }
}
