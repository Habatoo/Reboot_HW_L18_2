package laptenkov.genre;

import laptenkov.Music;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс {@link ClassicalMusic} объектов типа классической музыки.
 */
@Component
public class ClassicalMusic implements Music {

    /**
     * Объект {@link Enum} с треками жанра {@link ClassicalMusic}.
     */
    public enum ClassicalMusicBox {
        track_1("ClassicalMusic", "Mozart", "Eine kleine Nachtmusik"),
        track_2("ClassicalMusic", "Beethoven", "Für Elise"),
        track_3("ClassicalMusic", "Puccini", "O mio babbino caro' from Gianni Schicchi"),
        track_4("ClassicalMusic", "J.S. Bach", "Toccata and Fugue in D minor");

        public final String genre;
        public final String author;
        public final String name;

        ClassicalMusicBox(String genre,
                          String author,
                          String name) {
            this.genre = genre;
            this.author = author;
            this.name = name;
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
    public List<Object> play() {
        return Arrays.asList(ClassicalMusicBox.values());
    }
}
