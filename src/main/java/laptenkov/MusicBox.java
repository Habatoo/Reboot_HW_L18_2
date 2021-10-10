package laptenkov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Класс {@link MusicBox} для воспроизведения музыки различных
 * жанров. Музыка выбирается случайно внутри жанра.
 * При начале проигрывания озвучиваются жанр, автор и название песни.
 * @author habatoo
 */
@Component
public class MusicBox {
    private Music musicRock;
    private Music musicPop;
    private Music musicClassical;

    @Autowired
    public MusicBox(@Qualifier("rockMusic") Music musicRock,
                    @Qualifier("popMusic") Music musicPop,
                    @Qualifier("classicalMusic") Music musicClassical) {
        this.musicRock = musicRock;
        this.musicPop = musicPop;
        this.musicClassical = musicClassical;
    }

    /**
     * Метод {@link MusicBox#play()}
     * воспроизводит музыку переданную в качестве параметра.
     */
    public void play() {
        System.out.println(musicRock.play());
        System.out.println(musicPop.play());
        System.out.println(musicClassical.play());
    }

}
