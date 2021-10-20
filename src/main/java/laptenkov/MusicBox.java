package laptenkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Класс {@link MusicBox} для воспроизведения музыки различных
 * жанров. Музыка выбирается случайно внутри жанра.
 * При начале проигрывания озвучиваются жанр, автор и название песни.
 * @author habatoo
 */
@Component
public class MusicBox {
    private List<Music> musicList;
    Random RANDOM = new Random();

    public MusicBox(List<Music> musicList) {
        this.musicList = musicList;
    }

    /**
     * Метод {@link MusicBox#play()}
     * воспроизводит музыку переданную в качестве параметра.
     * Выход после ввода слова "quit".
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.next().equals("quit")) {
            List<Object> musicCompositions = musicList.get(RANDOM.nextInt(musicList.size())).play();
            System.out.println(musicCompositions.get(RANDOM.nextInt(musicCompositions.size())));
        }
    }

}
