package tw.controllers;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import tw.commands.GuessInputCommand;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import tw.core.Answer;
import tw.core.Game;
import tw.core.generator.AnswerGenerator;
import tw.views.GameView;
import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private Answer answer=new Answer();
    private GameView gameView;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private AnswerGenerator answerGenerator=Mockito.mock(AnswerGenerator.class);

    @Mock
    private GuessInputCommand guessInputCommand=Mockito.mock(GuessInputCommand.class);

    @Before
    public void setup() {
        gameView=new GameView();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void shouldBegin() throws Exception {
        Game game = new Game(answerGenerator);
        GameController gameController = new GameController(game,gameView);
        answer.createAnswer("4321");
        when(answerGenerator.generate()).thenReturn(answer);
        gameController.beginGame();
        assertEquals(systemOut(),"------Guess Number Game, You have 6 chances to guess!  ------");
    }

    private Game gamemock=Mockito.mock(Game.class);

    @Test
    public void should_Return_fail() throws Exception {
        GameController gameController = new GameController(gamemock,gameView);
        answer.createAnswer("4321");
        when(gamemock.checkCoutinue()).thenReturn(false);
        when(gamemock.checkStatus()).thenReturn("FAIL");
        gameController.play(guessInputCommand);
        assertEquals(systemOut(),"Game Status: FAIL");
    }

    @Test
    public void should_Return_successful() throws Exception {
        GameController gameController = new GameController(gamemock,gameView);
        answer.createAnswer("4321");
        when(gamemock.checkCoutinue()).thenReturn(false);
        when(gamemock.checkStatus()).thenReturn("SUCCESS");
        gameController.play(guessInputCommand);
        assertEquals(systemOut(),"Game Status: SUCCESS");
    }

}