package RockPaperScissors;

import static org.junit.jupiter.api.Assertions.*;

class ToolTest {
    @org.junit.jupiter.api.Test
    void getStrength() {
        Rock rock = new Rock(4);
        assertEquals(4, rock.getStrength());

    }

    @org.junit.jupiter.api.Test
    void setStrength() {
        Rock rock = new Rock(4);
        rock.setStrength(6);
        assertEquals(6, rock.getStrength());
    }

}