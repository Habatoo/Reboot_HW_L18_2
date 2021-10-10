package laptenkov.genre;

import laptenkov.Music;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс {@link PopMusic} объектов типа поп музыки.
 */
@Component
public class PopMusic implements Music {

    /**
     * Объект {@link Enum} с треками жанра {@link PopMusic}.
     */
    public enum PopMusicBox {
        track_1("PopMusic", "Ed Sheeran", "Bad Habits"),
        track_2("PopMusic", "Dua Lipa", "Love Again"),
        track_3("PopMusic", "Coldplay, BTS", "My Universe");

        public final String genre;
        public final String author;
        public final String name;

        PopMusicBox(String genre,
                    String author,
                    String name) {
            this.genre = genre;
            this.author = author;
            this.name = name;
        }

        /**
         * Метод randomTrack() для выбора случайного трека.
         */
        private static final List<PopMusicBox> VALUES = Arrays.asList(values());
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static PopMusicBox randomTrack() {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }

        @Override
        public String toString() {
            return "Now playing " +
                    "genre '" + genre + '\'' +
                    ", author '" + author + '\'' +
                    ", composition name '" + name + '\'';
        }
    }

    /**
     * Метод для реализации всеми жанрами музыки.
     * Возвращает случайный трек из {@link Enum}.
     */
    @Override
    public String play() {
        return PopMusicBox.randomTrack().toString();
    }
}
