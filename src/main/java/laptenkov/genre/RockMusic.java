package laptenkov.genre;

import laptenkov.Music;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс {@link RockMusic} объектов типа рок музыки.
 */
@Component
public class RockMusic implements Music {

    /**
     * Объект {@link Enum} с треками жанра {@link RockMusic}.
     */
    public enum RockMusicBox {
        track_1("RockMusic", "Van Helen", "Jump"),
        track_2("RockMusic", "Twenty One Pilots", "Level of Concern"),
        track_3("RockMusic", "Machine Gun Kelly", "Bloody Valentine");

        public final String genre;
        public final String author;
        public final String name;

        RockMusicBox(String genre,
                     String author,
                     String name) {
            this.genre = genre;
            this.author = author;
            this.name = name;
        }

        /**
         * Метод randomTrack() для выбора случайного трека.
         */
        private static final List<RockMusicBox> VALUES = Arrays.asList(values());
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static RockMusicBox randomTrack() {
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
        return RockMusicBox.randomTrack().toString();
    }

}
