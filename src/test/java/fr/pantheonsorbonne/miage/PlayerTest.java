package fr.pantheonsorbonne.miage;
import org.junit.jupiter.api.Test;
import fr.pantheonsorbonne.miage.game.Player;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class PlayerTest {
    
    @Test
    public void haveNewPointTest(){
        Player p = new Player("sarah");
        p.haveNewPoint();
        assertEquals(p.getFinalScore(), 1);
    }
}