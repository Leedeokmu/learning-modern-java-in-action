package com.freeefly.ch7;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // 현재 문자를 소비
        action.accept(string.charAt(currentChar++));
        // 소비할 문자가 남았다면 true
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        // 남은 문자수가 10개 미만이면 더 이상 split 하지 않으므로 null을 반환
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }

        for (int splitPos = currentSize / 2 + currentChar;
             splitPos < string.length();
             splitPos++) {
            if (Character.isWhitespace(string.charAt(splitPos))) {
                WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return wordCounterSpliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
